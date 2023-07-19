package ufes.acesso_usuarios.model;
import java.util.ArrayList;
import ufes.acesso_usuarios.log.LogService;
import ufes.acesso_usuarios.repository.UsuarioRepository;
import ufes.acesso_usuarios.service.NotificacaoService;

public class Administrador extends Usuario{
    private ArrayList<Usuario> usuariosCadastrados;
    private UsuarioRepository usuarioRepository;
    private LogService logService;
    private NotificacaoService notificacaoService;

     public Administrador(String nome, String senha) {
        super(nome, senha);
        this.usuariosCadastrados = new ArrayList<>();
        this.usuarioRepository.getInstance();
        this.logService = new LogService();
        this.notificacaoService = new NotificacaoService();
    }

    public void cadastrarUsuario(String nome, String senha) {
        Usuario novoUsuario = new Usuario(nome, senha);
        usuarioRepository.addUsuario(novoUsuario);
        logService.registrarLog("Inclusão de usuário", nome);
    }
    
    public void editarUsuario(String nome, String novoNome, String novaSenha){
        Usuario usuario = usuarioRepository.buscar(nome);
        usuario.setNome(novoNome);
        usuario.setSenha(novaSenha);
    }
    
    public void removerUsuario(String nome){
        Usuario usuario = usuarioRepository.buscar(nome);
        usuarioRepository.removerUsuario(usuario);
    }

    public void autorizarAcesso(String nome) {
        Usuario usuario = usuarioRepository.buscar(nome);
        if (usuario != null) {
            usuario.setAutorizado(true);
            logService.registrarLog("Autorização de usuário", nome);
        } else {
            logService.registrarLogFalha("Autorização de usuário", "Usuário não encontrado: " + nome);
        }
    }

    public void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String texto) {
        notificacaoService.enviarNotificacao(remetente, destinatarios, texto);
        logService.registrarLog("Envio no envio da notificação", "Remetente: " + remetente + ", Destinatários: " + destinatarios);
    }

    public ArrayList<Usuario> getUsuariosCadastrados() {
        return usuarioRepository.getUsuarios();
    }

    public void listarUsuarios() {
        usuariosCadastrados = usuarioRepository.getUsuarios();
        for (Usuario usuario : usuariosCadastrados) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Data de Cadastro: " + usuario.getDataCadastro());
            System.out.println("Número de Notificações Enviadas: " + usuario.getQtdNotificacoesRecebidas());
            System.out.println("Número de Notificações Lidas: " + usuario.getQtdNotificacoesLidas());
            System.out.println("-------------------------------------------");
        }
    }
}
