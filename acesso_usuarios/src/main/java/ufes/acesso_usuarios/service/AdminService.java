package ufes.acesso_usuarios.service;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;
import ufes.acesso_usuarios.state.VisualizacaoState;

public class AdminService {
    private SistemaService sistemaService;
    private UsuarioRepository usuarioRepository;
    private NotificacaoService notificacaoService;
    private Usuario admin;

    public AdminService(Usuario admin) {
        this.sistemaService = SistemaService.getInstance();
        this.usuarioRepository = UsuarioRepository.getInstance();
        this.notificacaoService = new NotificacaoService();
        this.admin = admin;
    }
    
    public void autorizarUsuario(String nome){
        //if(this.sistemaService.validarAdmin(this.admin.getNome())){
        if(this.sistemaService.validarAdmin(usuarioRepository.getUsuarios().get(0).getUsuario())){
            Usuario usuario = usuarioRepository.buscar(nome);
            //Altera o estado para Visuzalização
            usuario.setEstado(new VisualizacaoState(this));
            this.sistemaService.addUsuarioAutorizado(usuario, "comum");
        }
        else{
            System.out.println("Usuário sem permissão.");
        }
    }
    
    public void enviarNotificacao(ArrayList<String> destinatarios, String texto) {
        notificacaoService.enviarNotificacao(admin.getUsuario(), destinatarios, texto);
    }
    
    //CRUD
    public void cadastrarUsuario(String nome, String usuario, String senha) {
        Usuario novoUsuario = new Usuario(nome, usuario, senha);
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
