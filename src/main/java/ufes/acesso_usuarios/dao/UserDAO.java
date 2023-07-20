package ufes.acesso_usuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;

/**
 *
 * @author Danilo-Js
 */
public class UserDAO {
    private Connection connection;
    private NotificationDAO notificationDAO;
    
    public UserDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            notificationDAO = new NotificationDAO();
            initialize();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void initialize() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, senha TEXT, dataCadastro TEXT, autorizado INTEGER, tipo TEXT)");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String nome, String senha, LocalDate dataCadastro, boolean autorizado, String tipo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (nome, senha, dataCadastro, autorizado, tipo) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            preparedStatement.setString(3, dataCadastro.toString());
            preparedStatement.setInt(4, autorizado ? 1 : 0);
            preparedStatement.setString(5, tipo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int id, String nome, String senha, LocalDate dataCadastro, boolean autorizado, String tipo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET nome=?, senha=?, dataCadastro=?, autorizado=?, tipo=? WHERE id=?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            preparedStatement.setString(3, dataCadastro.toString());
            preparedStatement.setInt(4, autorizado ? 1 : 0);
            preparedStatement.setString(5, tipo);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Usuario> getUsers() {
        ArrayList<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario user = new Usuario(resultSet.getString("nome"), resultSet.getString("senha"));
                user.setDataCadastro(LocalDate.parse(resultSet.getString("dataCadastro")));
                user.setAutorizado(resultSet.getInt("autorizado") == 1);
                user.setTipo(resultSet.getString("tipo"));
                user.setNotificacoes(notificationDAO.getNotificationsByUser(resultSet.getString("nome"), resultSet.getString("senha")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void listUsers() {
        ArrayList<Usuario> users = this.getUsers();
        for(Usuario user : users) {
            System.out.println(user.toString());
        }
    }
}
