package ufes.acesso_usuarios.model;
import java.util.ArrayList;
import ufes.acesso_usuarios.repository.UsuarioRepository;
import ufes.acesso_usuarios.service.AdminService;

public class Administrador extends Usuario{
    private ArrayList<Usuario> usuariosCadastrados;
    private UsuarioRepository usuarioRepository;
    private AdminService adminService;

    public Administrador(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
        this.usuarioRepository = UsuarioRepository.getInstance();
        this.adminService = new AdminService(this);
    }
     
    //CRUD
    //public void cadastrarUsuario(String nome, String senha) {;
    //    estado.criarUsuario(nome, senha);
    //}
    
    public void buscarUsuario(String nome){
        //estado.visualizarUsuario(nome);
        Usuario usuario = usuarioRepository.buscarUsuario(nome);
    }
    
    public void atualizarNome(String nome, String novoNome){
        //estado.atualizarNome(nome, novoNome);
        Usuario usuario = usuarioRepository.buscarUsuario(nome);
    }
    
    public void atualizarSenha(String nome, String novaSenha){
        //estado.atualizarSenha(nome, novaSenha);
        Usuario usuario = usuarioRepository.buscarUsuario(nome);
    }
    
    public void removerUsuario(String nome){
        //estado.deletarUsuario(nome);
        Usuario usuario = usuarioRepository.buscarUsuario(nome);
    }

    //UCs
    public void autorizarAcesso(String nome) {
        adminService.autorizarUsuario(nome);
    }

    public void enviarNotificacao(ArrayList<String> destinatarios, String texto) {
        adminService.enviarNotificacao(destinatarios, texto);
    }

    public ArrayList<Usuario> getUsuariosCadastrados() {
        return usuarioRepository.getUsuarios();
    }

    public void listarUsuarios() {
        usuariosCadastrados = usuarioRepository.getUsuarios();
        for (Usuario usuario : usuariosCadastrados) {
            System.out.println("Nome: " + usuario.getUsuario());
            System.out.println("Data de Cadastro: " + usuario.getDataCadastro());
            System.out.println("Número de Notificações Enviadas: " + usuario.getQtdNotificacoesRecebidas());
            System.out.println("Número de Notificações Lidas: " + usuario.getQtdNotificacoesLidas());
            System.out.println("-------------------------------------------");
        }
    }
}
