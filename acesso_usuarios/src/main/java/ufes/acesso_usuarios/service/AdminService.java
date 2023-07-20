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
    
    public void autorizarUsuario(String nomeUsuario){
        //if(this.sistemaService.validarAdmin(this.admin.getNome())){
        if(this.sistemaService.validarAdmin(usuarioRepository.getUsuarios().get(0).getNomeUsuario())){
            Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
            //Altera o estado para Visuzalização
            //usuario.setEstado(new VisualizacaoState(this));
            this.sistemaService.addUsuarioAutorizado(usuario, "comum");
        }
        else{
            System.out.println("Usuário sem permissão.");
        }
    }
    
    public void enviarNotificacao(ArrayList<String> destinatarios, String texto) {
        //notificacaoService.enviarNotificacao(admin.getUsuario(), destinatarios, texto);
    }
    
    //CRUD
    public void cadastrarUsuario(String nomeUsuario, String usuario, String senha) {
        Usuario novoUsuario = new Usuario(nomeUsuario, usuario, senha);
        usuarioRepository.addUsuario(novoUsuario);
    }
    
    public Usuario buscarUsuario(String nomeUsuario){
        return usuarioRepository.buscarUsuario(nomeUsuario);
    }
    
    
    
    public void atualizarUsuario(Usuario usuarioEditado){
        usuarioRepository.atualizarUsuario(usuarioEditado);
    }
    
    public void atualizarSenha(String nomeUsuario, String novaSenha){
        Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
        usuario.setSenha(novaSenha);
    }
    
    public void removerUsuario(String nomeUsuario){
        Usuario usuario = usuarioRepository.buscarUsuario(nomeUsuario);
        usuarioRepository.removerUsuario(usuario);
    }

}
