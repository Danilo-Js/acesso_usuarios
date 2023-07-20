package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.observer.Observer;
import ufes.acesso_usuarios.service.NotificacaoService;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.InclusaoState;
import ufes.acesso_usuarios.state.State;
import ufes.acesso_usuarios.view.TelaBuscarUsuariosView;

public class TelaBuscarUsuariosPresenter implements Observer {

    private TelaBuscarUsuariosView telaBuscarUsuariosView;
    private TelaManterUsuarioPresenter presenterTelaManterUsuario;
    private UsuarioService usuarioService;
    private NotificacaoService notificacaoService;
    private ArrayList<Usuario> usuarios;
    private Usuario admin;
    private Usuario usuario;
    private State estado;
    private JTable tableUsuarios;

    public TelaBuscarUsuariosPresenter(Usuario admin) {
        this.usuarioService = UsuarioService.getInstance();
        this.usuarioService.adicionarObservador(this);
        this.notificacaoService = NotificacaoService.getInstance();
        this.telaBuscarUsuariosView = new TelaBuscarUsuariosView();
        this.telaBuscarUsuariosView.setVisible(true);
        this.telaBuscarUsuariosView.setLocationRelativeTo(null);
        this.tableUsuarios = telaBuscarUsuariosView.getTableUsuarios();
        this.usuarios = new ArrayList();
        this.admin = admin;
        preencherRodape();
        preencherTabela();
        //Listeners dos Botões
        listenersBotoes();
    }

    public void preencherRodape() {
        telaBuscarUsuariosView.getTxtNomeUsuario().setText(admin.getNomeUsuario());
        telaBuscarUsuariosView.getTxtTipoUsuario().setText(admin.getTipo());
        telaBuscarUsuariosView.getTxtQtdNotificacoes().setText(String.valueOf(admin.getQtdNotificacoesRecebidas()));
    }

    private void preencherTabela(Usuario usuario) {
        DefaultTableModel tabelaModelo = (DefaultTableModel) this.tableUsuarios.getModel();
        tabelaModelo.setNumRows(0);

        if (usuario != null) {
            tabelaModelo.addRow(new Object[]{
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getTipo(),
                usuario.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                usuario.isAutorizado() ? "Sim" : "Não",
                usuario.getQtdNotificacoesRecebidas(),
                usuario.getQtdNotificacoesLidas()
            });
        }
    }

    private void preencherTabela() {
        DefaultTableModel tabelaModelo = (DefaultTableModel) this.tableUsuarios.getModel();
        tabelaModelo.setNumRows(0);
        this.usuarios = usuarioService.getUsuarios();
        for (Usuario usuario : usuarios) {
            tabelaModelo.addRow(new Object[]{
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getTipo(),
                usuario.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                usuario.isAutorizado() ? "Sim" : "Não",
                usuario.getQtdNotificacoesRecebidas(),
                usuario.getQtdNotificacoesLidas()
            });
        }
    }

    private void listenersBotoes() {
        //OPÇÕES GERAIS

        //Botão Configurar
        this.telaBuscarUsuariosView.getOpcaoConfigurar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaFormatoLogPresenter();
            }
        });

        //Botão Alterar Senha
        this.telaBuscarUsuariosView.getOpcaoAlterarSenha().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenterTelaManterUsuario = new TelaManterUsuarioPresenter(admin, "alterarSenha");
            }
        });

        //Botão Sair
        this.telaBuscarUsuariosView.getOpcaoSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaBuscarUsuariosView.dispose();
                new TelaLoginPresenter();
            }
        });

        //Botão Abrir Notificações
        this.telaBuscarUsuariosView.getBtnAbrirNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceLinhaSelecionada = tableUsuarios.getSelectedRow();
                if (indiceLinhaSelecionada != -1) {
                    String nomeUsuario = (String) tableUsuarios.getValueAt(indiceLinhaSelecionada, 1);
                    usuario = usuarioService.buscarUsuario(nomeUsuario);
                    exibirMensagem("Suas mensagens foram lidas.");
                }
            }
        });

        //OPÇÕES ADMINISTRATIVAS
        //Botão Buscar Usuário
        this.telaBuscarUsuariosView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUsuario = telaBuscarUsuariosView.getInputPesquisa().getText();
                Usuario usuario = usuarioService.buscarUsuario(nomeUsuario);
                preencherTabela(usuario);
            }
        });

        //Botão Criar Usuário
        this.telaBuscarUsuariosView.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarEstado(new InclusaoState(presenterTelaManterUsuario));
                presenterTelaManterUsuario = new TelaManterUsuarioPresenter(null, "criarUsuario");
            }
        });

        //Botão Visualizar Usuários
        this.telaBuscarUsuariosView.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceLinhaSelecionada = tableUsuarios.getSelectedRow();

                if (indiceLinhaSelecionada != -1) {
                    String nome = (String) tableUsuarios.getValueAt(indiceLinhaSelecionada, 0);
                    String nomeUsuario = (String) tableUsuarios.getValueAt(indiceLinhaSelecionada, 1);
                    String senha = (String) tableUsuarios.getValueAt(indiceLinhaSelecionada, 2);
                    Usuario usuarioSelecionado = new Usuario(nome, nomeUsuario, senha);
                    presenterTelaManterUsuario = new TelaManterUsuarioPresenter(usuarioSelecionado, "verUsuario");
                } else {
                    exibirMensagem("Selecione um usuário na tabela para visualizar/editar.");
                }
            }
        });

        //Botão Autorizar Usuário
        this.telaBuscarUsuariosView.getBtnAutorizarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceLinhaSelecionada = tableUsuarios.getSelectedRow();
                if (indiceLinhaSelecionada != -1) {
                    String nomeUsuario = (String) tableUsuarios.getValueAt(indiceLinhaSelecionada, 1);
                    usuarioService.autorizarUsuario(nomeUsuario);
                    exibirMensagem("Usuário " + nomeUsuario + " autorizado a acessar o sistema.");
                } else {
                    exibirMensagem("Selecione um usuário na tabela autorizar o acesso.");
                }
            }
        });

        //Botão Enviar Notificações
        this.telaBuscarUsuariosView.getBtnEnviarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceLinhaSelecionada = tableUsuarios.getSelectedRow();
                if (indiceLinhaSelecionada != -1) {
                    String nomeUsuario = (String) tableUsuarios.getValueAt(indiceLinhaSelecionada, 1);
                    notificacaoService.enviarNotificacao(admin.getNomeUsuario(), nomeUsuario, "Seja Bem-vindo ao nosso sistema!");
                    usuarioService.atualizarUsuario(usuario);
                    exibirMensagem("Notificação enviada.");
                } else {
                    exibirMensagem("Selecione um usuário para notificar.");
                }
            }
        });

    }

    public void alterarEstado(State estado) {
        this.estado = estado;
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(telaBuscarUsuariosView, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        telaBuscarUsuariosView.dispose();
    }

    @Override
    public void atualizar() {
        preencherTabela();
    }
}
