package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class SistemaService {
    private UsuarioRepository usuarioRepository;
    private static SistemaService instance;
    private Usuario admin;
    private ArrayList<Usuario> usuarios;

    public SistemaService() {
        this.usuarioRepository = UsuarioRepository.getInstance();
    }

    public static SistemaService getInstance() {
        if (instance == null) {
            instance = new SistemaService();
        }
        return instance;
    }

    // --LOGIN--
    public boolean validarAdmin(String nomeUsuario) {
        this.admin = this.usuarioRepository.buscarUsuario(nomeUsuario);
        if (this.admin.getTipo().equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public void addUsuarioAutorizado(Usuario usuario, String tipo) {
        usuario.setTipo(tipo);
        this.usuarioRepository.atualizarUsuario(usuario);
    }

    public Usuario getAdmin() {
        return admin;
    }
     
}
