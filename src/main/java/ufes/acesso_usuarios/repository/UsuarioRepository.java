package ufes.acesso_usuarios.repository;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    private ArrayList<Usuario> usuarios;

    private UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario){
        this.usuarios.remove(usuario);
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
