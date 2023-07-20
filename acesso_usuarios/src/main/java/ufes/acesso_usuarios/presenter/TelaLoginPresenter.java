package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.State;
import ufes.acesso_usuarios.view.TelaLoginView;

public class TelaLoginPresenter {
    private UsuarioService usuarioService;
    private TelaLoginView telaLogin;
    private State estado;
    //private TelaPrincipalAdminPresenter presenterTelaPrincipalAdmin;
    //private TelaPrincipalUsuarioPresenter presenterTelaPrincipalUsuario;
    protected TelaManterUsuarioPresenter presenterTelaManterUsuario;

    public TelaLoginPresenter() {
        this.telaLogin = new TelaLoginView();
        this.telaLogin.setVisible(true);
        this.telaLogin.setLocationRelativeTo(null);
        this.telaLogin.setResizable(false);
        this.usuarioService = UsuarioService.getInstance();
        // Listeners dos Botões
        listenersBotoes();
    }

    public void fazerLogin() {
        String usuarioLogin = telaLogin.getInputUsuario().getText();
        String senhaLogin = telaLogin.getInputSenha().getText();
        if (usuarioService.fazerLogin(usuarioLogin, senhaLogin)) {
            Usuario usuario = usuarioService.buscarUsuario(usuarioLogin);
            if (usuario.getTipo().equals("admin")) {
                //presenterTelaPrincipalAdmin = TelaPrincipalAdminPresenter.getInstance(usuario);
                new TelaBuscarUsuariosPresenter(usuario);
            } else {
                new TelaPrincipalUsuarioPresenter(usuario);
            }
            this.telaLogin.dispose();
        } else {
            exibirMensagem("Não foi possível realizar o login.");
        }
    }

    private void listenersBotoes() {
        //Botão Entrar
        this.telaLogin.getBtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerLogin();
            }
        });
       
        //Botão Criar conta
        this.telaLogin.getBtnCriarConta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenterTelaManterUsuario = new TelaManterUsuarioPresenter(null, "criarUsuario");
            }
        });
    }
    
    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(telaLogin, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        telaLogin.dispose();
    }

}
