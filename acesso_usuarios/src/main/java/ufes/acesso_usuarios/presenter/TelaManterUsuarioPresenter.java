package ufes.acesso_usuarios.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.EdicaoState;
import ufes.acesso_usuarios.state.InclusaoState;
import ufes.acesso_usuarios.state.UsuarioState;
import ufes.acesso_usuarios.view.TelaManterUsuarioView;

public class TelaManterUsuarioPresenter {

    private TelaManterUsuarioView telaManterUsuario;
    private UsuarioService usuarioService;
    private Usuario usuario;
    private UsuarioState estado = null;

    public TelaManterUsuarioPresenter(Usuario usuario, String opcao) {
        this.telaManterUsuario = new TelaManterUsuarioView();
        this.usuarioService = UsuarioService.getInstance();
        this.telaManterUsuario.setVisible(true);
        this.telaManterUsuario.setLocationRelativeTo(null);
        this.usuario = usuario;
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
                }
            });
        } else {
            if (opcao.equals("alterarSenha")) {
                alterarEstado(new EdicaoState(this, usuario.getUsuario()));
                preencherDadosAlterarSenha();
                // Botão Salvar
                this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        estado.atualizarUsuario();
                    }
                });
            } if (opcao.equals("editarUsuario")) {
                alterarEstado(new EdicaoState(this, usuario.getUsuario()));
                preencherDadosAlterarUsuario();
                // Botão Salvar
                this.telaManterUsuario.getBtnCriar().setText("Salvar");
                this.telaManterUsuario.getBtnCriar().removeActionListener(null); // Remove os ActionListeners anteriores
                this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        estado.atualizarUsuario();
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
        telaManterUsuario.getInputUsuario().setText(usuario.getUsuario());
        telaManterUsuario.getInputUsuario().setEditable(false);
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        this.telaManterUsuario.getBtnCriar().setText("Salvar");
    }

    private void preencherDadosAlterarUsuario() {
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputUsuario().setText(usuario.getUsuario());
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        this.telaManterUsuario.getBtnCriar().setText("Salvar");
    }

    public TelaManterUsuarioView getTelaManterUsuario() {
        return telaManterUsuario;
    }

    public void alterarEstado(UsuarioState estado) {
        this.estado = estado;
    }

    public void fecharTela() {
        telaManterUsuario.dispose();
    }

}
