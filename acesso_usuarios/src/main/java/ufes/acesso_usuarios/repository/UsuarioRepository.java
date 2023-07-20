package ufes.acesso_usuarios.repository;
import java.util.ArrayList;
import ufes.acesso_usuarios.dao.UserDAO;
import ufes.acesso_usuarios.log.*;
import ufes.acesso_usuarios.model.Usuario;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    private ArrayList<Usuario> usuarios;

    UserDAO userDAO;
    Log log;
    
    private UsuarioRepository() {
        this.usuarios = new ArrayList<>();
        Usuario admin = new Usuario("Gabriel", "gabriel", "123");
        admin.setAutorizado(true);
        admin.setTipo("admin");
        this.usuarios.add(admin);
        this.userDAO = new UserDAO();
        this.log = new Log("CSV");
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        this.userDAO.addUser(usuario.getNome(), usuario.getNomeUsuario(), usuario.getSenha(), usuario.getDataCadastro(), usuario.isAutorizado(), usuario.getTipo());
        System.out.println("Usuários: " + usuarios.toString());
    }

    public void removerUsuario(Usuario usuario){
        this.usuarios.remove(usuario);
        int id = usuarios.indexOf(usuario);
        this.userDAO.deleteUser(id);
    }

    public Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(usuario)) {
                usuarios.set(i, usuario);
                this.userDAO.updateUser(i, usuario.getNome(), usuario.getNomeUsuario(), usuario.getSenha(), usuario.getDataCadastro(), usuario.isAutorizado(), usuario.getTipo());
                System.out.println("(Presenter) Usuário atualizado.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
