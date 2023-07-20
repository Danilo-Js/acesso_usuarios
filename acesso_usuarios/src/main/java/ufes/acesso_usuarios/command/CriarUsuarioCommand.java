package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.service.AdminService;

public class CriarUsuarioCommand implements Command {
    private AdminService adminService;
    private String nome;
    private String senha;

    public CriarUsuarioCommand(AdminService adminService, String nome, String senha) {
        this.adminService = adminService;
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public void execute() {
        //adminService.cadastrarUsuario(nome, senha);
    }
}