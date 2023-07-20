package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.UsuarioState;
import ufes.acesso_usuarios.view.TelaManterUsuarioView;

public class TelaManterUsuarioPresenter {
    private TelaManterUsuarioView telaManterUsuario;
    private UsuarioService usuarioService;
    private UsuarioState usuarioEstado;
    private Usuario usuario;

    public TelaManterUsuarioPresenter(Usuario usuario, String opcao) {
        this.telaManterUsuario = new TelaManterUsuarioView();
        this.usuarioService = UsuarioService.getInstance();
        this.telaManterUsuario.setVisible(true);
        this.telaManterUsuario.setLocationRelativeTo(null);
        this.usuario = usuario; 
        listenersBotoes();
        validarOpcao(opcao);
    }

    public void validarOpcao(String opcao) {
//        if (opcao.equals("criarUsuario")) {
//            criarUsuario();
//        } 
        if (opcao.equals("alterarSenha")) {
            alterarSenha();
        }
        else if(opcao.equals("editarUsuario")) {
            editarUsuario();
        }
    }

    private void criarUsuario() {
        String nome = telaManterUsuario.getInputNome().getText();
        String nomeUsuario = telaManterUsuario.getInputUsuario().getText();
        String senha = telaManterUsuario.getInputSenha().getText();
        Usuario usuario = new Usuario(nome, nomeUsuario, senha);
        usuarioService.criarUsuario(usuario);
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
        telaManterUsuario.getInputNome().setText(usuario.getNome());
        telaManterUsuario.getInputUsuario().setText(usuario.getUsuario());
        telaManterUsuario.getInputSenha().setText(usuario.getSenha());
        telaManterUsuario.getBtnCriar().setText("Salvar");
    }

    private void listenersBotoes() {
        //Botão Salvar
        this.telaManterUsuario.getBtnCriar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarUsuario();
//                String novaSenha = telaManterUsuario.getInputSenha().getText();
//                
//                System.out.println("Senha: " + usuario.getSenha());
//                
//                //usuarioService.alterarSenha(usuario, novaSenha);
//                usuarioService.atualizarUsuario(usuario);
//                telaManterUsuario.dispose();
//                
//                System.out.println("Nova senha: " + novaSenha);
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

    public TelaManterUsuarioView getTelaManterUsuario() {
        return telaManterUsuario;
    }

    public void alterarEstado(UsuarioState estado){
        usuarioEstado = estado;
    }
    
    public void fecharTela(){
        telaManterUsuario.dispose();
    }

}
