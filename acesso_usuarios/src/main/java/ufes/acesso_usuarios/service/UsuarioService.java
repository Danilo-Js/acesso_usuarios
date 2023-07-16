package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class UsuarioService {
    private SistemaService sistemaService;
    private UsuarioRepository usuarioRepository;
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;

    public UsuarioService() {
        this.sistemaService = SistemaService.getInstance();
        this.usuarioRepository = UsuarioRepository.getInstance();
    }

    public void criarUsuario(Usuario usuario) {
        this.usuarioRepository.addUsuario(usuario);
    }
    
    public void acessar(String nomeUsuario, String senha){
        this.usuarios = this.usuarioRepository.getUsuarios();
        if (this.usuarios.size() == 1) {
            this.usuario = this.usuarioRepository.buscar(nomeUsuario);
            this.sistemaService.addUsuarioAutorizado(usuario, "admin");
        }
        this.sistemaService.fazerLogin(nomeUsuario, senha);
    }

    public void enviarMensagem() {

    }

}
