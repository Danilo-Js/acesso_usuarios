package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.view.ManterUsuarioView;

public class TelaManterUsuarioPresenter {
    private ManterUsuarioView telaManterUsuario;
    private UsuarioService usuarioService;
    private Usuario usuario;

    public TelaManterUsuarioPresenter(Usuario usuario, String opcao) {
        this.telaManterUsuario = new ManterUsuarioView();
        this.usuarioService = UsuarioService.getInstance();
        this.telaManterUsuario.setVisible(true);
        this.telaManterUsuario.setLocationRelativeTo(null);
        this.usuario = usuario;
        validaOpcao(opcao);
        listenersBotoes();
    }

    public void validaOpcao(String opcao) {
        if (opcao.equals("criarUsuario")) {
            criarUsuario();
        } else if (opcao.equals("alterarSenha")) {
            alterarSenha();
        }
    }

    private void criarUsuario() {

    }

    private void alterarSenha() {
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputNome().setEditable(false);
        telaManterUsuario.getInputUsuario().setText(usuario.getUsuario());
        telaManterUsuario.getInputUsuario().setEditable(false);
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        telaManterUsuario.getBtnCriar().setText("Salvar");
    }
    
    private void editarUsuario() {
        
    }

    private void listenersBotoes() {
        //Botão Salvar
        this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaSenha = String.valueOf(telaManterUsuario.getInputSenha());
                
                System.out.println("Senha: " + usuario.getSenha());
                
                usuarioService.alterarSenha(usuario, novaSenha);
                telaManterUsuario.dispose();
                
                System.out.println("Nova senha: " + novaSenha);
            }
        });

        //Botão Cancelar
        this.telaManterUsuario.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaManterUsuario.dispose();
                
            }
        });
    }

}
