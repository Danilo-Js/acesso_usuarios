package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class UsuarioService {
    private static UsuarioService instance;
    private SistemaService sistemaService;
    private UsuarioRepository usuarioRepository;
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;

    private UsuarioService() {
        this.sistemaService = SistemaService.getInstance();
        this.usuarioRepository = UsuarioRepository.getInstance();
    }

    public static UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    public void criarUsuario(Usuario usuario) {
        this.usuarios = usuarioRepository.getUsuarios();
        if(this.usuarios.size() == 0){
            usuario.setAutorizado(true);
            usuario.setTipo("admin");
        }
        else{
            usuario.setTipo("comum");
            
        }
        this.usuarioRepository.addUsuario(usuario);
    }
    
    public boolean fazerLogin(String nomeUsuario, String senha) {
        Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
        
        if (usuario != null && usuario.getSenha().equals(senha)) {
            // Usuário encontrado e senha está correta, realiza o login
            System.out.println("Login realizado com sucesso!");
            return true;
        } 
        else {
            System.out.println("Usuário ou senha incorretos. Tente novamente.");
        }
        return false;
    }
    
    public void atualizarUsuario(Usuario usuario){
        usuarioRepository.atualizarUsuario(usuario);
        System.out.println("(Service) Usuário atualizado: " + usuario.toString());
    }

    public void abrirNotificacoes(String nomeDestinatario) {
        this.usuario = this.usuarioRepository.buscarUsuario(nomeDestinatario);
        if (this.usuario != null) {
            ArrayList<Notificacao> notificacoes = this.usuario.getNotificacoes();
            for (Notificacao notificacao : notificacoes) {
                System.out.println("Mensagem: " + notificacao.toString());
            }
        }
    }

    public void marcarMensagemComoLida(Notificacao notificacao) {
        notificacao.setLida(true);
    }
    
    public Usuario buscarUsuario(String nomeUsuario){
        this.usuario = this.usuarioRepository.buscarUsuario(nomeUsuario);
        return this.usuario;
    }

}
