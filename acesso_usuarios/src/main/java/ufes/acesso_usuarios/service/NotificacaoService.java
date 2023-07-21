//package ufes.acesso_usuarios.service;
//import java.util.ArrayList;
//import ufes.acesso_usuarios.model.Notificacao;
//import ufes.acesso_usuarios.model.Usuario;
//import ufes.acesso_usuarios.repository.NotificacaoRepository;
//
//public class NotificacaoService {
//    private static NotificacaoService instance;
//    private Notificacao notificacao;
//    private final NotificacaoRepository notificacaoRepository ;
//    //private final UsuarioService usuarioService;
//
//    public NotificacaoService() {
//        this.notificacaoRepository = NotificacaoRepository.getInstance();
//        //this.usuarioService = UsuarioService.getInstance();
//    }
//  
//    public static NotificacaoService getInstance() {
//        if (instance == null) {
//            instance = new NotificacaoService();
//        }
//        return instance;
//    }
//    
//    public Usuario enviarNotificacao(Usuario remetente, Usuario destinatario, String mensagem) {
//        notificacao = new Notificacao(remetente, destinatario, mensagem);
//        destinatario.addNotificacao(notificacao);
//        return destinatario;
//    }
//    
//    private Notificacao buscarNotificacao(int id){
//        notificacao = notificacaoRepository.buscarNotificacao(id);
//        return notificacao;
//    }
//    
//    public void marcarComoLida(int id){
//        notificacao = buscarNotificacao(id);
//        notificacao.setLida(true);
//        buscarNotificacao(id);
//        atualizarNotificacao(notificacao);
//    }
//    
//    private void atualizarNotificacao(Notificacao notificacaoLida){
//        notificacaoRepository.atualizarNotificacao(notificacaoLida);
//    }
//}
