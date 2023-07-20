package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.repository.NotificacaoRepository;

/**
 *
 * @author Danilo-Js
 */
public class NotificacaoService {
    
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoService() {
        this.notificacaoRepository = NotificacaoRepository.getInstance();
    }

    public void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String mensagem) {
        for (String destinatario : destinatarios) {
            Notificacao notificacao = new Notificacao(remetente, destinatario, mensagem);
            this.notificacaoRepository.addNotificacao(notificacao);
            // Lógica para enviar a notificação para o destinatário
        }
    }
}
