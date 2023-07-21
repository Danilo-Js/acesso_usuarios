package ufes.acesso_usuarios.repository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ufes.acesso_usuarios.adapter.Log;
import java.util.ArrayList;
import ufes.acesso_usuarios.dao.UserDAO;
import ufes.acesso_usuarios.model.Usuario;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    private ArrayList<Usuario> usuarios;

    UserDAO userDAO;
    Log log;
    
    private UsuarioRepository() {
        this.usuarios = new ArrayList<>();
        this.userDAO = new UserDAO();
        this.log = new Log();
        Usuario admin = new Usuario("Administrador", "admin", "123");
        admin.setAutorizado(true);
        admin.setTipo("admin");
        this.usuarios.add(admin);
        Usuario usuario = new Usuario("Usuário", "user", "123");
        usuario.setAutorizado(true);
        usuario.setTipo("comum");
        this.usuarios.add(usuario);
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
        log.getLog().criaLog_Sucesso("Inclusão de usuário", usuario.getNome(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), usuario.getNomeUsuario());
    }

    public void removerUsuario(Usuario usuario){
        this.usuarios.remove(usuario);
        int id = usuarios.indexOf(usuario);
        this.userDAO.deleteUser(id);
        log.getLog().criaLog_Sucesso("Remoção de usuário", usuario.getNome(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), usuario.getNomeUsuario());
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
                log.getLog().criaLog_Sucesso("Alteração de usuário", usuario.getNome(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), usuario.getNomeUsuario());
                return;
            }
        }
        this.log.getLog().criaLog_Falha("Usuário não encontrado", "Alteração de usuário", usuario.getNome(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), usuario.getNomeUsuario());
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
