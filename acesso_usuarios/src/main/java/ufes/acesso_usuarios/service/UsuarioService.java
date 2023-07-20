package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.observer.Observado;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class UsuarioService extends Observado{

    private static UsuarioService instance;
    private NotificacaoService notificacaoService;
    private UsuarioRepository usuarioRepository;
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;

    private UsuarioService() {
        this.notificacaoService = NotificacaoService.getInstance();
        this.usuarioRepository = UsuarioRepository.getInstance();
        this.usuarios = new ArrayList();
    }

    public static UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    public void criarUsuario(Usuario usuario) {
        this.usuarios = usuarioRepository.getUsuarios();
        if (this.usuarios.size() == 0) {
            usuario.setAutorizado(true);
            usuario.setTipo("admin");
        } else {
            usuario.setTipo("comum");

        }
        this.usuarioRepository.addUsuario(usuario);
    }

    public boolean fazerLogin(String nomeUsuario, String senha) {
        Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            // Usuário encontrado e senha está correta, realiza o login
            return true;
        } else {
            throw new IllegalArgumentException("Usuário ou senha incorretos. Tente novamente.");
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioRepository.atualizarUsuario(usuario);
    }
    
    public void removerUsuario(String nomeUsuario){
        Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
        usuarioRepository.removerUsuario(usuario);
    }

    public void abrirNotificacoes(String nomeDestinatario) {
        this.usuario = this.usuarioRepository.buscarUsuario(nomeDestinatario);
        if (this.usuario != null) {
            ArrayList<Notificacao> notificacoes = this.usuario.getNotificacoes();
            for (Notificacao notificacao : notificacoes) {
                //
            }
        }
    }

    public void marcarMensagemComoLida(Notificacao notificacao) {
        notificacao.setLida(true);
    }

    public Usuario buscarUsuario(String nomeUsuario) {
        this.usuario = this.usuarioRepository.buscarUsuario(nomeUsuario);
        return this.usuario;
    }

    public ArrayList getUsuarios() {
        this.usuarios = this.usuarioRepository.getUsuarios();
        notificarObservadores();
        return this.usuarios;
    }

    public void autorizarUsuario(String nomeUsuario) {
        Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
        usuario.setAutorizado(true);
        atualizarUsuario(usuario);
    }

    public void enviarNotificacao(ArrayList<String> destinatarios, String texto) {
        //notificacaoService.enviarNotificacao(admin.getUsuario(), destinatarios, texto);
    }
}
