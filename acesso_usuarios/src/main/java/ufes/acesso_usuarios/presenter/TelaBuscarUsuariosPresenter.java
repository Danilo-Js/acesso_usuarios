package ufes.acesso_usuarios.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.InclusaoState;
import ufes.acesso_usuarios.state.State;
import ufes.acesso_usuarios.view.TelaBuscarUsuariosView;

public class TelaBuscarUsuariosPresenter {

    private TelaBuscarUsuariosView telaBuscarUsuariosView;
    private TelaManterUsuarioPresenter presenterTelaManterUsuario;
    private UsuarioService usuarioService;
    private ArrayList<Usuario> usuarios = new ArrayList();
    private Usuario admin;
    private State estado;
    private JTable tableUsuarios;
    private UsuarioRepository usuarioRepository;

    public TelaBuscarUsuariosPresenter(Usuario admin) {
        this.usuarioService = UsuarioService.getInstance();
        this.telaBuscarUsuariosView = new TelaBuscarUsuariosView();
        this.telaBuscarUsuariosView.setVisible(true);
        this.telaBuscarUsuariosView.setLocationRelativeTo(null);
        this.tableUsuarios = telaBuscarUsuariosView.getTableUsuarios();
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
        System.out.println("Usuarios: " + this.usuarios.get(0).toString());
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
                new TelaManterUsuarioPresenter(admin, "alterarSenha");
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
                //
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
            }
        });

        //Botão Visualizar Usuários
        this.telaBuscarUsuariosView.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Botão Autorizar Usuário
        this.telaBuscarUsuariosView.getBtnAutorizarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Botão Enviar Notificações
        this.telaBuscarUsuariosView.getBtnEnviarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
}