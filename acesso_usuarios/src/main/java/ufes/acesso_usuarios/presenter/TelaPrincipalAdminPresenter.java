package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.view.TelaPrincipalAdminView;

public class TelaPrincipalAdminPresenter {
    private static TelaPrincipalAdminPresenter instance;
    private TelaPrincipalAdminView telaPrincipalAdmin;
    private TelaLoginPresenter presenterTelaLogin;
    private TelaManterUsuarioPresenter telaManterUsuarioPresenter;
    private Usuario usuario;

    private TelaPrincipalAdminPresenter(Usuario usuario) {
        this.telaPrincipalAdmin = new TelaPrincipalAdminView();
        this.telaPrincipalAdmin.setVisible(true);
        this.telaPrincipalAdmin.setLocationRelativeTo(null);
        this.usuario = usuario;
        preencherRodape();
        //Listeners dos Botões
        listenersBotoes();
    }

    public static TelaPrincipalAdminPresenter getInstance(Usuario usuario) {
        if (instance == null) {
            instance = new TelaPrincipalAdminPresenter(usuario);
        }
        return instance;
    }

    public void preencherRodape() {
        telaPrincipalAdmin.getTxtNomeUsuario().setText(usuario.getUsuario());
        telaPrincipalAdmin.getTxtTipoUsuario().setText(usuario.getTipo());
        telaPrincipalAdmin.getTxtQtdNotificacoes().setText(String.valueOf(usuario.getQtdNotificacoesRecebidas()));
    }

    private void listenersBotoes() {
        //Botão Configurar
        this.telaPrincipalAdmin.getOpcaoConfigurar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        //Botão Alterar Senha
        this.telaPrincipalAdmin.getOpcaoAlterarSenha().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Alterar senha");
                telaManterUsuarioPresenter = new TelaManterUsuarioPresenter(usuario, "alterarSenha");
            }
        });

        //Botão Sair
        this.telaPrincipalAdmin.getOpcaoSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipalAdmin.dispose();
                presenterTelaLogin = new TelaLoginPresenter();
            }
        });
        
        
    }

}
