package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.repository.NotificacaoRepository;

public class NotificacaoService {
    private static NotificacaoService instance;
    private Notificacao notificacao;
    private NotificacaoRepository notificacaoRepository ;

    public NotificacaoService() {
        notificacaoRepository = NotificacaoRepository.getInstance();
    }

    public static NotificacaoService getInstance() {
        if (instance == null) {
            instance = new NotificacaoService();
        }
        return instance;
    }
    
    private void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String mensagem) {
        for (String destinatario : destinatarios) {
            Notificacao notificacao = new Notificacao(remetente, destinatario, mensagem);
        }
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
