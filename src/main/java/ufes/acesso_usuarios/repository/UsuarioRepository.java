package ufes.acesso_usuarios.repository;
import java.util.ArrayList;
import ufes.acesso_usuarios.dao.UserDAO;
import ufes.acesso_usuarios.model.Usuario;

public class UsuarioRepository {
    UserDAO userDAO;
    private static UsuarioRepository instance;
    private ArrayList<Usuario> usuarios;
    
    private UsuarioRepository() {
        this.userDAO = new UserDAO();
        this.usuarios = userDAO.getUsers();
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);       
        this.userDAO.addUser(usuario.getNome(), usuario.getSenha(), usuario.getDataCadastro(), usuario.isAutorizado(), usuario.getTipo());
    }

    public void removerUsuario(Usuario usuario){
        this.usuarios.remove(usuario);
        int id = usuarios.indexOf(usuario) + 1;
        this.userDAO.deleteUser(id);
    }

    public Usuario buscar(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
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
