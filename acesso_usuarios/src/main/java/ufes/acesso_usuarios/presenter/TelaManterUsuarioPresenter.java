package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.EdicaoState;
import ufes.acesso_usuarios.state.InclusaoState;
import ufes.acesso_usuarios.state.State;
import ufes.acesso_usuarios.state.VisualizacaoState;
import ufes.acesso_usuarios.view.TelaManterUsuarioView;

public class TelaManterUsuarioPresenter {

    private TelaManterUsuarioView telaManterUsuario;
    private UsuarioService usuarioService;
    private Usuario usuario;
    private State estado = null;

    public TelaManterUsuarioPresenter(Usuario usuario, String opcao) {
        this.telaManterUsuario = new TelaManterUsuarioView();
        this.usuarioService = UsuarioService.getInstance();
        this.telaManterUsuario.setVisible(true);
        this.telaManterUsuario.setLocationRelativeTo(null);
        this.telaManterUsuario.setResizable(false);
        this.usuario = usuario;
        this.estado = new VisualizacaoState(this, usuario.getNomeUsuario());
        validarOpcao(opcao);
    }

    public void validarOpcao(String opcao) {
        if (opcao.equals("criarUsuario")) {
            alterarEstado(new InclusaoState(this));
            // Botão Salvar
            this.telaManterUsuario.getBtnCriar().setText("Criar");
            this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    estado.criarUsuario();
                    exibirMensagem("Usuário " + telaManterUsuario.getInputUsuario().getText() + " criado com sucesso.");
                    exibirMensagem("Para acessar o sistema é precisa ser autorizado pelo administrador do sistema.");;
                    telaManterUsuario.dispose();
                    new TelaLoginPresenter();
                }
            });
        } else {
            if (opcao.equals("alterarSenha")) {
                alterarEstado(new EdicaoState(this, usuario.getNomeUsuario()));
                preencherDadosAlterarSenha();
                // Botão Salvar
                this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        estado.atualizarUsuario();
                        exibirMensagem("A senha do usuário " + usuario.getNomeUsuario() + " foi atualizada.");
                    }
                });
            } if (opcao.equals("editarUsuario")) {
                alterarEstado(new EdicaoState(this, usuario.getNomeUsuario()));
                preencherDadosAlterarUsuario();
                // Botão Salvar
                this.telaManterUsuario.getBtnCriar().setText("Salvar");
                this.telaManterUsuario.getBtnCriar().removeActionListener(null); // Remove os ActionListeners anteriores
                this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        estado.atualizarUsuario();
                        exibirMensagem("O usuário + " + usuario.getNomeUsuario() + " foi editado.");
                    }
                });
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

    private void preencherDadosAlterarSenha() {
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputNome().setEditable(false);
        telaManterUsuario.getInputUsuario().setText(usuario.getNomeUsuario());
        telaManterUsuario.getInputUsuario().setEditable(false);
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        this.telaManterUsuario.getBtnCriar().setText("Salvar");
    }

    private void preencherDadosAlterarUsuario() {
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputUsuario().setText(usuario.getNomeUsuario());
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        this.telaManterUsuario.getBtnCriar().setText("Salvar");
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
        telaManterUsuario.dispose();
    }

}
