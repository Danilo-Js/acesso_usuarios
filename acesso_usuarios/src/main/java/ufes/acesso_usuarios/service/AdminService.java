package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class AdminService {
    private SistemaService sistemaService;
    private UsuarioRepository usuarioRepository;
    private NotificacaoService notificacaoService;
    private Usuario admin;

    public AdminService(Usuario admin) {
        this.sistemaService = SistemaService.getInstance();
        this.usuarioRepository.getInstance();
        this.notificacaoService = new NotificacaoService();
        this.admin = admin;
    }
    
    public void autorizarUsuario(String nome){
        if(this.sistemaService.validarAdmin(this.admin.getNome())){
            Usuario usuario = usuarioRepository.buscar(nome);
            this.sistemaService.addUsuarioAutorizado(usuario, "comum");
        }
        else{
            System.out.println("Usuário sem permissão.");
        }
    }
    
    public void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String texto) {
        notificacaoService.enviarNotificacao(remetente, destinatarios, texto);
    }
    
    //CRUD
    public void cadastrarUsuario(String nome, String senha) {
        Usuario novoUsuario = new Usuario(nome, senha);
        usuarioRepository.addUsuario(novoUsuario);
    }
    
    public void buscarUsuario(String nome){
        usuarioRepository.buscar(nome);
    }
    
    public void atualizarNome(String nome, String novoNome){
        Usuario usuario = usuarioRepository.buscar(nome);
        usuario.setNome(novoNome);
    }
    
    public void atualizarSenha(String nome, String novaSenha){
        Usuario usuario = usuarioRepository.buscar(nome);
        usuario.setSenha(novaSenha);
    }
    
    public void removerUsuario(String nome){
        Usuario usuario = usuarioRepository.buscar(nome);
        usuarioRepository.removerUsuario(usuario);
    }

}
