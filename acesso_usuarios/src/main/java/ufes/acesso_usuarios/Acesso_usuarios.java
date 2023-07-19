package ufes.acesso_usuarios;
import java.util.ArrayList;
import ufes.acesso_usuarios.model.Administrador;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.UsuarioService;

public class Acesso_usuarios {

    public static void main(String[] args) {
        // Criação dos serviços
        UsuarioService usuarioService = new UsuarioService();

        // Criação do administrador
        Administrador admin = new Administrador("gabriel.n.nascimento", "123");
        usuarioService.criarUsuario(admin);

        // Acesso do administrador
        usuarioService.acessarSistema(admin.getNome(), admin.getSenha());
        System.out.println("Tipo: " + admin.getTipo());

        // Criação do usuário
        Usuario usuario = new Usuario("joyce.f.furtunato", "123");
        usuarioService.criarUsuario(usuario);

        // Acesso do usuário
        usuarioService.acessarSistema(usuario.getNome(), usuario.getSenha());

        // Autorização do usuário pelo administrador
        admin.autorizarAcesso(usuario.getNome());

        // Acesso do usuário após a autorização
        usuarioService.acessarSistema(usuario.getNome(), usuario.getSenha());
        System.out.println("Tipo: " + usuario.getTipo());
        
        admin.atualizarNome("joyce.f.furtunato", "joyceBarbosa");
        System.out.println(usuario.toString());
        
        
        

        // Envio de notificação pelo administrador
        ArrayList<String> destinatarios = new ArrayList<>();
        destinatarios.add(usuario.getNome());
        admin.enviarNotificacao(destinatarios, "Te amo <3.");
        
        // Visualização da notificação pelo usuário
        usuarioService.visualizarNotificacao(usuario.getNome());
        usuarioService.visualizarNotificacao(usuario.getNome());
    }
}
