package ufes.acesso_usuarios.repository;
import java.util.ArrayList;
import ufes.acesso_usuarios.dao.NotificationDAO;
import ufes.acesso_usuarios.dao.UserDAO;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.model.Usuario;

/**
 *
 * @author Danilo-Js
 */
public class NotificacaoRepository {
    NotificationDAO notificacaoDAO;
    private static NotificacaoRepository instance;
    
    private NotificacaoRepository() {
        this.notificacaoDAO = new NotificationDAO();
    }

    public static NotificacaoRepository getInstance() {
        if (instance == null) {
            instance = new NotificacaoRepository();
        }
        return instance;
    }

    public void addNotificacao(Notificacao notification) {
        this.notificacaoDAO.addNotification(notification);
    }

    public void removerNotificacao(Notificacao notification){
        this.notificacaoDAO.deleteNotification(notification);
    }

    public void atualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(usuario)) {
                usuarios.set(i, usuario);
                this.userDAO.updateUser(i + 1, usuario.getNome(), usuario.getSenha(), usuario.getDataCadastro(), usuario.isAutorizado(), usuario.getTipo());
                this.userDAO.listUsers();
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
