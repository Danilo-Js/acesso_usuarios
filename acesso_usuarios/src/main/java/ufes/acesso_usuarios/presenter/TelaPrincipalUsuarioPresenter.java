package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.state.UsuarioState;
import ufes.acesso_usuarios.view.TelaPrincipalUsuarioView;

public class TelaPrincipalUsuarioPresenter {
    private static TelaPrincipalUsuarioPresenter instance; 
    private TelaPrincipalUsuarioView telaPrincipalUsuario;
    private TelaLoginPresenter presenterTelaLogin;
    private TelaManterUsuarioPresenter presenterTelaManterUsuario;
    private Usuario usuario;
    private UsuarioState estado;
    
    private TelaPrincipalUsuarioPresenter(Usuario usuario) {
        this.telaPrincipalUsuario = new TelaPrincipalUsuarioView();
        this.telaPrincipalUsuario.setVisible(true);
        this.telaPrincipalUsuario.setLocationRelativeTo(null);
        this.usuario = usuario;
        preencherRodape();
        //Listeners dos Botões
        listenersBotoes();
    }
    
    public static TelaPrincipalUsuarioPresenter getInstance(Usuario usuario) {
        if (instance == null) {
            instance = new TelaPrincipalUsuarioPresenter(usuario);
        }
        return instance;
    }
    
    public void preencherRodape(){
        telaPrincipalUsuario.getTxtNomeUsuario().setText(usuario.getUsuario());
        telaPrincipalUsuario.getTxtTipoUsuario().setText(usuario.getTipo());
        telaPrincipalUsuario.getTxtQtdNotificacoes().setText(String.valueOf(usuario.getQtdNotificacoesRecebidas()));
    }
    
    private void listenersBotoes() {
        //OPÇÕES GERAIS
        
        //Botão Configurar
        this.telaPrincipalUsuario.getOpcaoConfigurar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Botão Alterar Senha
        this.telaPrincipalUsuario.getOpcaoAlterarSenha().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Alterar senha");
                presenterTelaManterUsuario = new TelaManterUsuarioPresenter(usuario, "alterarSenha");
            }
        });

        //Botão Sair
        this.telaPrincipalUsuario.getOpcaoSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipalUsuario.dispose();
                presenterTelaLogin = new TelaLoginPresenter();
            }
        });
        
        //Botão Abrir Notificações
        this.telaPrincipalUsuario.getBtnAbrirNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    public void alterarEstado(UsuarioState estado){
        this.estado = estado;
    }

}
