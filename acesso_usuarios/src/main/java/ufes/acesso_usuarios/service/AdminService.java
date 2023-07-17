package ufes.acesso_usuarios.service;
import ufes.acesso_usuarios.model.Usuario;

public class AdminService {
    private SistemaService sistemaService;
    private Usuario admin;

    public AdminService(Usuario admin) {
        this.sistemaService = SistemaService.getInstance();
        this.admin = admin;
    }
    
    public void autorizarUsuario(Usuario usuario){
        if(this.sistemaService.validarAdmin(this.admin.getNomeUsuario())){
            this.sistemaService.addUsuarioAutorizado(usuario, "comum");
        }
        else{
            System.out.println("Usuário sem permissão.");
        }
    }
    
    public void enviarMensagem(String nomeDestinatario, String mensagem) {
        this.sistemaService.enviarMensagem(this.admin.getNome(), nomeDestinatario, mensagem);
    }

}
