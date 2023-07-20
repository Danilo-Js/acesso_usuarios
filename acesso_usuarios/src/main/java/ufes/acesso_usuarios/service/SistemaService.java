package ufes.acesso_usuarios.service;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class SistemaService {
    private UsuarioRepository usuarioRepository;
    private static SistemaService instance;
    private Usuario admin;
    private Usuario usuario;

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
        this.admin = this.usuarioRepository.buscar(nomeUsuario);
        if (this.admin.getTipo().equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public void addUsuarioAutorizado(Usuario usuario, String tipo) {
        usuario.setTipo(tipo);
        this.usuarioRepository.atualizar(usuario);
    }

    public void fazerLogin(String nomeUsuario, String senha) {
        this.usuario = this.usuarioRepository.buscar(nomeUsuario);
        if (this.usuario == null) {
            System.out.println("O usuário não existe.");
        } 
        else if (this.usuario.isAutorizado()) {
            if(this.usuario.getSenha().equals(senha)){
                System.out.println("Usuário logado.");
            }
            else{
                System.out.println("Senha incorreta.");
            }
        }
    }
    
     
}
