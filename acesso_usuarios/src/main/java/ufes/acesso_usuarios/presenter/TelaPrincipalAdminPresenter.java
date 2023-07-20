package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.state.*;
import ufes.acesso_usuarios.view.TelaPrincipalAdminView;

public class TelaPrincipalAdminPresenter {

    private static TelaPrincipalAdminPresenter instance;
    private TelaPrincipalAdminView telaPrincipalAdmin;
    private TelaLoginPresenter presenterTelaLogin;
    private TelaManterUsuarioPresenter presenterTelaManterUsuario;
    private Usuario usuario;
    private State estado;

    TelaPrincipalAdminPresenter(Usuario usuario) {
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
        telaPrincipalAdmin.getTxtNomeUsuario().setText(usuario.getNomeUsuario());
        telaPrincipalAdmin.getTxtTipoUsuario().setText(usuario.getTipo());
        telaPrincipalAdmin.getTxtQtdNotificacoes().setText(String.valueOf(usuario.getQtdNotificacoesRecebidas()));
    }

    private void listenersBotoes() {
        //OPÇÕES GERAIS
        
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
                presenterTelaManterUsuario = new TelaManterUsuarioPresenter(usuario, "alterarSenha");
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
        
        //Botão Abrir Notificações
        this.telaPrincipalAdmin.getBtnAbrirNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        //OPÇÕES ADMINISTRATIVAS
        
        //Botão Manter Usuários
        this.telaPrincipalAdmin.getBtnManterUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        //Botão Autorizar Usuário
        this.telaPrincipalAdmin.getBtnAutorizarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        //Botão Enviar Notificações
        this.telaPrincipalAdmin.getBtnEnviarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
    }

    public void alterarEstado(State estado) {
        this.estado = estado;
    }

}
