package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;
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

    public void acessar(String nome, String senha) {
        this.usuarios = this.usuarioRepository.getUsuarios();
        if (this.usuarios.size() == 1) {
            this.usuario = this.usuarioRepository.buscar(nome);
            this.sistemaService.addUsuarioAutorizado(usuario, "admin");
        }
        this.sistemaService.fazerLogin(nome, senha);
    }

    public void visualizarMensagem(String nomeDestinatario) {
        this.usuario = this.usuarioRepository.buscar(nomeDestinatario);
        if (this.usuario != null) {
            ArrayList<Notificacao> notificacoes = this.usuario.getNotificacoes();
            for (Notificacao notificacao : notificacoes) {
                System.out.println("Mensagem: " + notificacao.toString());
                marcarMensagemComoLida(notificacao);
            }
        }
    }

    public void marcarMensagemComoLida(Notificacao notificacao) {
        notificacao.setLida(true);
    }

}
