package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;

public class NotificacaoService {

    public void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String texto) {
        for (String destinatario : destinatarios) {
            Notificacao notificacao = new Notificacao(remetente, destinatario, texto);
            // Lógica para enviar a notificação para o destinatário
        }
    }
}
