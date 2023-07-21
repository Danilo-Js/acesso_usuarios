//package ufes.acesso_usuarios.repository;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import ufes.acesso_usuarios.dao.NotificationDAO;
//import ufes.acesso_usuarios.adapter.Log;
//import ufes.acesso_usuarios.model.Notificacao;
//import ufes.acesso_usuarios.model.Usuario;
//
//public class NotificacaoRepository {
//    private static NotificacaoRepository instance;
//    private ArrayList<Notificacao> notificacoes;
//    private Notificacao notificacao;
//    
//    NotificationDAO notificationDAO;
//    Log log;
//    
//    private NotificacaoRepository() {
//        this.notificationDAO = new NotificationDAO();
//        this.notificacoes = this.notificationDAO.getNotifications();
//        this.log = new Log();
//    }
//    
//    public static NotificacaoRepository getInstance() {
//        if(instance == null) {
//            instance = new NotificacaoRepository();
//        }
//        return instance;
//    }
//
//    public void addNotificacao(Usuario remetente, Usuario destinatario, String mensagem) {
//        notificacao = new Notificacao(remetente, destinatario, mensagem);
//        this.notificationDAO.addNotification(new Notificacao(remetente,destinatario,mensagem));
//        this.notificacoes.add(notificacao);
//        log.getLog().criaLog_Sucesso("Envio de notificação", remetente.getNomeUsuario(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), destinatario.getNomeUsuario());
//    }
//
//    public ArrayList<Notificacao> getNotificacoes() {
//        return this.notificacoes;
//    }
//
//    public void atualizarNotificacao(Notificacao notificacaoLida) {
//        for (int i = 0; i < notificacoes.size(); i++) {
//            Notificacao notificacao = notificacoes.get(i);
//            if (notificacao.getId() == notificacaoLida.getId()) {
//                notificacoes.set(i, notificacaoLida);
//                this.notificationDAO.updateNotification(notificacao);
//                log.getLog().criaLog_Sucesso("Leitura de notificação", notificacaoLida.getRemetente(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), notificacaoLida.getDestinatario());
//                return;
//            }
//        }
//        this.log.getLog().criaLog_Falha("Notificação não encontrada", "Leitura de notificação", notificacaoLida.getRemetente(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), notificacaoLida.getDestinatario());
//    }
//
//    public Notificacao buscarNotificacao(int id) {
//        for (Notificacao notificacao : notificacoes) {
//            if (notificacao.getId() == id) {
//                return notificacao;
//            }
//        }
//        return null;
//    }
//}
