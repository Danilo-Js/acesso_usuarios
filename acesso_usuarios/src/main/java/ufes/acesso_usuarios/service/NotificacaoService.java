package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;

public class NotificacaoService {
    private static NotificacaoService instance;
    
    private void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String mensagem) {
        for (String destinatario : destinatarios) {
            Notificacao notificacao = new Notificacao(remetente, destinatario, mensagem);
            // Lógica para enviar a notificação para o destinatário
        }
    }
    
    public static NotificacaoService getInstance() {
        if (instance == null) {
            instance = new NotificacaoService();
        }
        return instance;
    }
}
