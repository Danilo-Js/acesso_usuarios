package ufes.acesso_usuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.management.Notification;
import ufes.acesso_usuarios.model.Notificacao;

/**
 *
 * @author Danilo-Js
 */
public class NotificationDAO {
    private Connection connection;

    public NotificationDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            initialize();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS notifications (id INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER, remetente TEXT, destinatario TEXT, mensagem TEXT NOT NULL, lida INTEGER, FOREIGN KEY (userId) REFERENCES users(id))");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private int getUserId(String nome, String senha) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM users WHERE nome=? AND senha=?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    private int getUserId(String nome) {
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM users WHERE nome=?");
        preparedStatement.setString(1, nome);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
}
    
    private int getNotificationId(Notificacao notification) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM notifications WHERE remetente=? AND destinatario=? AND mensagem=?");
            preparedStatement.setString(1, notification.getRemetente());
            preparedStatement.setString(2, notification.getDestinatario());
            preparedStatement.setString(2, notification.getMensagem());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void addNotification(Notificacao notification) {
        try {
            int userId = getUserId(notification.getDestinatario());
            if (userId != -1) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO notifications (userId, remetente, destinatario, mensagem, lida) VALUES (?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, notification.getRemetente());
                preparedStatement.setString(3, notification.getDestinatario());
                preparedStatement.setString(4, notification.getMensagem());
                preparedStatement.setInt(5, notification.isLida() ? 1 : 0);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNotification(Notificacao notification) {
        try {
            int notificationId = getNotificationId(notification);
            if (notificationId != -1) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM notifications WHERE id=?");
                preparedStatement.setInt(2, notificationId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNotification(Notificacao notification) {
        try {
            int userId = getUserId(notification.getDestinatario());
            int notificationId = getNotificationId(notification);
            if (userId != -1 && notificationId != -1) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE notifications SET remetente=?, destinatario=?, mensagem=?, lida=? WHERE id=? AND userId=?");
                preparedStatement.setString(1, notification.getRemetente());
                preparedStatement.setString(2, notification.getDestinatario());
                preparedStatement.setString(3, notification.getMensagem());
                preparedStatement.setInt(4, notification.isLida() ? 1 : 0);
                preparedStatement.setInt(5, notificationId);
                preparedStatement.setInt(6, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Notificacao> getNotificationsByUser(String nome, String senha) {
        ArrayList<Notificacao> notifications = new ArrayList<>();
        try {
            int userId = getUserId(nome, senha);
            if (userId != -1) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM notifications WHERE userId=?");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Notificacao notification = new Notificacao(resultSet.getString("remetente"), resultSet.getString("destinatario"), resultSet.getString("mensagem"));
                    notification.setLida(resultSet.getInt("lida") == 1);
                    notifications.add(notification);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
