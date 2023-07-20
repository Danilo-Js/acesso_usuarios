package ufes.acesso_usuarios.repository;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.state.VisualizacaoState;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    private ArrayList<Usuario> usuarios;

    private UsuarioRepository() {
        this.usuarios = new ArrayList<>();
        Usuario admin = new Usuario("Gabriel", "gabriel", "123");
        admin.setAutorizado(true);
        admin.setTipo("admin");
        this.usuarios.add(admin);
        
        System.out.println(usuarios.get(0).toString());
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        System.out.println("Usuários: " + usuarios.toString());
    }

    public void removerUsuario(Usuario usuario){
        this.usuarios.remove(usuario);
    }

    public Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(usuario)) {
                usuarios.set(i, usuario);
                System.out.println("Usuário atualizado.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
