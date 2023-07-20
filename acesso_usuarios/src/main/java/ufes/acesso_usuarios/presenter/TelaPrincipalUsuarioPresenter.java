package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.observer.Observer;
import ufes.acesso_usuarios.service.UsuarioService;
import ufes.acesso_usuarios.state.State;
import ufes.acesso_usuarios.state.VisualizacaoState;
import ufes.acesso_usuarios.view.TelaPrincipalUsuarioView;

public class TelaPrincipalUsuarioPresenter implements Observer{
    private TelaPrincipalUsuarioView telaPrincipalUsuario;
    private TelaLoginPresenter presenterTelaLogin;
    private TelaManterUsuarioPresenter presenterTelaManterUsuario;
    private Usuario usuario;
    private State estado;
    
    public TelaPrincipalUsuarioPresenter(Usuario usuario) {
        this.telaPrincipalUsuario = new TelaPrincipalUsuarioView();
        this.telaPrincipalUsuario.setVisible(true);
        this.telaPrincipalUsuario.setLocationRelativeTo(null);
        this.telaPrincipalUsuario.setResizable(false);
        this.usuario = usuario;
        UsuarioService.getInstance().adicionarObservador(this);
        preencherRodape();
        //Listeners dos Botões
        listenersBotoes();
        this.estado = new VisualizacaoState(new TelaManterUsuarioPresenter(usuario, null), usuario.getNomeUsuario());
    }
    
    public void preencherRodape(){
        telaPrincipalUsuario.getTxtNomeUsuario().setText(usuario.getNomeUsuario());
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
    
    public void alterarEstado(State estado){
        this.estado = estado;
    }

    @Override
    public void atualizar() {
        listenersBotoes();
    }

}
