package ufes.acesso_usuarios.model;
import java.util.ArrayList;
import ufes.acesso_usuarios.repository.UsuarioRepository;
import ufes.acesso_usuarios.service.AdminService;
import ufes.acesso_usuarios.service.NotificacaoService;
import ufes.acesso_usuarios.state.UsuarioState;

public class Administrador extends Usuario{
    private ArrayList<Usuario> usuariosCadastrados;
    private UsuarioRepository usuarioRepository;
    private AdminService adminService;
    private UsuarioState estado;
    private NotificacaoService notificacaoService;

    public Administrador(ArrayList<Usuario> usuariosCadastrados, UsuarioRepository usuarioRepository, AdminService adminService, UsuarioState estado, NotificacaoService notificacaoService, String nome, String senha) {
        super(nome, senha);
        this.usuariosCadastrados = usuariosCadastrados;
        this.usuarioRepository.getInstance();
        this.adminService = adminService;
        this.estado = estado;
        this.notificacaoService = notificacaoService;
    }
     
    public void cadastrarUsuario(String nome, String senha) {
        estado.criarUsuario(nome, senha);
    }
    
    public void buscarUsuario(String nome){
        estado.visualizarUsuario(nome);
    }
    
    public void atualizarNome(String nome, String novoNome){
        estado.atualizarNome(nome, novoNome);
    }
    
    public void atualizarSenha(String nome, String novaSenha){
        estado.atualizarSenha(nome, novaSenha);
    }
    
    public void removerUsuario(String nome){
        estado.deletarUsuario(nome);
    }

    public void autorizarAcesso(String nome) {
        adminService.autorizarUsuario(nome);
    }

    public void enviarNotificacao(String remetente, ArrayList<String> destinatarios, String texto) {
        adminService.enviarNotificacao(remetente, destinatarios, texto);
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
