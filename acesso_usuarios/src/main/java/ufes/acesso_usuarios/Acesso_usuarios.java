package ufes.acesso_usuarios;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.service.AdminService;
import ufes.acesso_usuarios.service.UsuarioService;

public class Acesso_usuarios {

    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        
        Usuario admin = new Usuario("Gabriel", "gabriel.n.nascimento", "123");
        usuarioService.criarUsuario(admin);
        
        usuarioService.acessar(admin.getNomeUsuario(), admin.getSenha());
        System.out.println("Tipo: " + admin.getTipo());
        
        AdminService adminService = new AdminService(admin);
        
        Usuario usuario = new Usuario("Joyce", "joyce.f.furtunato", "123");
        usuarioService.criarUsuario(usuario);
        
        usuarioService.acessar(usuario.getNomeUsuario(), usuario.getSenha());
        
        adminService.autorizarUsuario(usuario);
        
        usuarioService.acessar(usuario.getNomeUsuario(), usuario.getSenha());
        System.out.println("Tipo: " + usuario.getTipo());
    }
}
