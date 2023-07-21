package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.observer.Observer;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.EdicaoState;
import ufes.acesso_usuarios.state.InclusaoState;
import ufes.acesso_usuarios.state.State;
import ufes.acesso_usuarios.state.VisualizacaoState;
import ufes.acesso_usuarios.view.TelaManterUsuarioView;

public class TelaManterUsuarioPresenter implements Observer{

    private TelaManterUsuarioView telaManterUsuario;
    private UsuarioService usuarioService;
    private Usuario usuario;
    private State estado = null;

    public TelaManterUsuarioPresenter(Usuario usuario, String opcao) {
        this.telaManterUsuario = new TelaManterUsuarioView();
        this.usuarioService = UsuarioService.getInstance();
        this.usuarioService.adicionarObservador(this);
        this.telaManterUsuario.setVisible(true);
        this.telaManterUsuario.setLocationRelativeTo(null);
        this.telaManterUsuario.setResizable(false);
        this.usuario = usuario;
        validarOpcao(opcao);
    }

    public void validarOpcao(String opcao) {
        if (opcao.equals("verUsuario")) {
            alterarEstado(new VisualizacaoState(this, usuario.getNomeUsuario()));
            //preencherDadosVerUsuario();
            atualizar();
            // Botão Fechar
            this.telaManterUsuario.getBtnCriar().setText("Fechar");
            this.telaManterUsuario.getBtnCriar().removeActionListener(null); // Remove os ActionListeners anteriores
            this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaManterUsuario.dispose();
                }
            });
            //Abre a tela de edição
            this.telaManterUsuario.getBtnEditar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nomeUsuario = telaManterUsuario.getInputUsuario().getText();
                    Usuario usuario = usuarioService.buscarUsuario(nomeUsuario);
                    new TelaManterUsuarioPresenter(usuario, "editarUsuario");
                }
            });

            //Abre a de confirmação para excluir
            this.telaManterUsuario.getBtnExcluir().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Exibe a mensagem de confirmação
                    if (mensagemExclusao("Deseja realmente excluir o usuário?")) {
                        String nomeUsuario = telaManterUsuario.getInputUsuario().getText();
                        usuarioService.removerUsuario(nomeUsuario);
                        telaManterUsuario.dispose();
                        exibirMensagem("Usuário excluído com sucesso.");
                    } else {
                    }
                }
            });

        } else if (opcao.equals("criarUsuario")) {
            if (estado instanceof InclusaoState) {
                this.telaManterUsuario.getBtnCriar().setText("Criar");
                this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        estado.criarUsuario();
                        exibirMensagem("Usuário " + telaManterUsuario.getInputUsuario().getText() + " criado com sucesso.");
                        exibirMensagem("Para acessar o sistema é preciso ser autorizado pelo administrador do sistema.");
                        telaManterUsuario.dispose();
                        new TelaLoginPresenter();
                    }
                });
            } else {
                if (opcao.equals("alterarSenha")) {
                    alterarEstado(new EdicaoState(this, usuario.getNomeUsuario()));
                    preencherDadosEditarUsuario();
                    // Botão Salvar
                    this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            estado.atualizarUsuario();
                            exibirMensagem("A senha do usuário " + usuario.getNomeUsuario() + " foi atualizada.");
                        }
                    });
                } else if (opcao.equals("editarUsuario")) {
                    alterarEstado(new EdicaoState(this, usuario.getNomeUsuario()));
                    preencherDadosAlterarUsuario();
                    // Botão Salvar
                    this.telaManterUsuario.getBtnCriar().setText("Salvar");
                    this.telaManterUsuario.getBtnCriar().removeActionListener(null); // Remove os ActionListeners anteriores
                    this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            estado.atualizarUsuario();
                            exibirMensagem("O usuário " + usuario.getNomeUsuario() + " foi editado.");
                        }
                    });
                }
            }
        }

        // Botão Cancelar
        this.telaManterUsuario.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaManterUsuario.dispose();
            }
        });
    }

    private void preencherDadosVerUsuario() {
        telaManterUsuario.dispose();
        telaManterUsuario.setVisible(true);
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputNome().setEditable(false);
        telaManterUsuario.getInputUsuario().setText(usuario.getNomeUsuario());
        telaManterUsuario.getInputUsuario().setEditable(false);
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        telaManterUsuario.getInputSenha().setEditable(false);
        this.telaManterUsuario.getBtnCriar().setEnabled(false);
    }

    private void preencherDadosEditarUsuario() {
        telaManterUsuario.dispose();
        telaManterUsuario.setVisible(true);
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputUsuario().setText(usuario.getNomeUsuario());
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        this.telaManterUsuario.getBtnCriar().setText("Salvar");
        telaManterUsuario.getBtnExcluir().setEnabled(false);
        telaManterUsuario.getBtnEditar().setEnabled(false);
    }

    private void preencherDadosAlterarUsuario() {
        telaManterUsuario.dispose();
        telaManterUsuario.setVisible(true);
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputUsuario().setText(usuario.getNomeUsuario());
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        this.telaManterUsuario.getBtnCriar().setText("Salvar");
        telaManterUsuario.getBtnExcluir().setEnabled(false);
        telaManterUsuario.getBtnEditar().setEnabled(false);
    }

    public TelaManterUsuarioView getTelaManterUsuario() {
        return telaManterUsuario;
    }

    public void alterarEstado(State estado) {
        this.estado = estado;
    }

    public void fecharTela() {
        telaManterUsuario.dispose();
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(telaManterUsuario, mensagem, "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean mensagemExclusao(String mensagem) {
        int resposta = JOptionPane.showConfirmDialog(telaManterUsuario, mensagem, "Exclusão", JOptionPane.YES_NO_OPTION);
        return resposta == JOptionPane.YES_OPTION;
    }
    
    @Override
    public void atualizar() {
        preencherDadosVerUsuario();
    }

}
