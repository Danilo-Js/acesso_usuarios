package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.service.AdminService;

public class AtualizarSenhaCommand implements Command {
    private AdminService adminService;
    private String nome;
    private String novaSenha;

    public AtualizarSenhaCommand(AdminService adminService, String nome, String novaSenha) {
        this.adminService = adminService;
        this.nome = nome;
        this.novaSenha = novaSenha;
    }

    @Override
    public void execute() {
        adminService.atualizarSenha(nome, novaSenha);
    }
}
