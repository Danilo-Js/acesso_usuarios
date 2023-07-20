package ufes.acesso_usuarios.service;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.NotificacaoRepository;

public class NotificacaoService {
    private static NotificacaoService instance;
    private Notificacao notificacao;
    private NotificacaoRepository notificacaoRepository ;
    private UsuarioService usuarioService;

    public NotificacaoService() {
        this.notificacaoRepository = NotificacaoRepository.getInstance();
        this.usuarioService = UsuarioService.getInstance();
    }

    public static NotificacaoService getInstance() {
        if (instance == null) {
            instance = new NotificacaoService();
        }
        return instance;
    }
    
    public void enviarNotificacao(String remetente, String destinatario, String mensagem) {
        notificacao = new Notificacao(remetente, destinatario, mensagem);
        Usuario usuario = usuarioService.buscarUsuario(mensagem);
        usuarioService.atualizarUsuario(usuario);
    }
    
    private Notificacao buscarNotificacao(int id){
        notificacao = notificacaoRepository.buscarNotificacao(id);
        return notificacao;
    }
    
    public void marcarComoLida(int id){
        notificacao = buscarNotificacao(id);
        notificacao.setLida(true);
        buscarNotificacao(id);
        atualizarNotificacao(notificacao);
    }
    
    private void atualizarNotificacao(Notificacao notificacaoLida){
        notificacaoRepository.atualizarNotificacao(notificacaoLida);
    }
    
}
