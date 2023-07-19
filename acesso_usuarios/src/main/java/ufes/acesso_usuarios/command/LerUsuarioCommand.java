package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.service.AdminService;

public class LerUsuarioCommand implements Command {
    private AdminService adminService;
    private String nome;

    public LerUsuarioCommand(AdminService adminService, String nome) {
        this.adminService = adminService;
        this.nome = nome;
    }

    @Override
    public void execute() {
        adminService.buscarUsuario(nome);
    }
}
