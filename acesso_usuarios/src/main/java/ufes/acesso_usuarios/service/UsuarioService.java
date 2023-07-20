package ufes.acesso_usuarios.service;

import java.util.ArrayList;
import ufes.acesso_usuarios.model.Notificacao;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class UsuarioService {

    private static UsuarioService instance;
    private SistemaService sistemaService;
    private NotificacaoService notificacaoService;
    private UsuarioRepository usuarioRepository;
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;

    private UsuarioService() {
        this.sistemaService = SistemaService.getInstance();
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
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Usuário ou senha incorretos. Tente novamente.");
        }
        return false;
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioRepository.atualizarUsuario(usuario);
    }

    public void abrirNotificacoes(String nomeDestinatario) {
        this.usuario = this.usuarioRepository.buscarUsuario(nomeDestinatario);
        if (this.usuario != null) {
            ArrayList<Notificacao> notificacoes = this.usuario.getNotificacoes();
            for (Notificacao notificacao : notificacoes) {
                //
                System.out.println("Mensagem: " + notificacao.toString());
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
        return this.usuarios;
    }

    public void autorizarUsuario(String nomeUsuario) {
        //if(this.sistemaService.validarAdmin(this.admin.getNome())){
        if (this.sistemaService.validarAdmin(usuarioRepository.getUsuarios().get(0).getNomeUsuario())) {
            Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
            //Altera o estado para Visuzalização
            //usuario.setEstado(new VisualizacaoState(this));
            this.sistemaService.addUsuarioAutorizado(usuario, "comum");
        }
    }

    public void enviarNotificacao(ArrayList<String> destinatarios, String texto) {
        //notificacaoService.enviarNotificacao(admin.getUsuario(), destinatarios, texto);
    }

}
