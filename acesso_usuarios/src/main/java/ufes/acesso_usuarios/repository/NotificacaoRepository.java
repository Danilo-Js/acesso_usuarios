package ufes.acesso_usuarios.repository;
import java.util.ArrayList;
import ufes.acesso_usuarios.dao.NotificationDAO;
import ufes.acesso_usuarios.log.Log;
import ufes.acesso_usuarios.model.Notificacao;

public class NotificacaoRepository {
    private static NotificacaoRepository instance;
    private ArrayList<Notificacao> notificacoes;
    private Notificacao notificacao;
    
    NotificationDAO notificationDAO;
    Log log;
    
    private NotificacaoRepository() {
        this.notificationDAO = new NotificationDAO();
        this.notificacoes = this.notificationDAO.getNotifications();
        this.log = new Log("CSV");
    }
    
    public static NotificacaoRepository getInstance() {
        if(instance == null) {
            instance = new NotificacaoRepository();
        }
        return instance;
    }

    public void addNotificacao(String remetente, String destinatario, String mensagem) {
        notificacao = new Notificacao(remetente, destinatario, mensagem);
        this.notificationDAO.addNotification(new Notificacao(remetente,destinatario,mensagem));
        this.notificacoes.add(notificacao);
    }

    public ArrayList<Notificacao> getNotificacoes() {
        return this.notificacoes;
    }

    public void atualizarNotificacao(Notificacao notificacaoLida) {
        for (int i = 0; i < notificacoes.size(); i++) {
            Notificacao notificacao = notificacoes.get(i);
            if (notificacao.getId() == notificacaoLida.getId()) {
                notificacoes.set(i, notificacaoLida);
                this.notificationDAO.updateNotification(notificacao);
                return;
            }
        }
        System.out.println("Notificação não encontrada.");
    }

    public Notificacao buscarNotificacao(int id) {
        for (Notificacao notificacao : notificacoes) {
            if (notificacao.getId() == id) {
                return notificacao;
            }
        }
        return null;
    }
}
