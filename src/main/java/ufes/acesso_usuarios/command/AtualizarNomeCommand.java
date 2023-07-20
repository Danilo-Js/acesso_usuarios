package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.service.AdminService;

public class AtualizarNomeCommand implements Command {
    private AdminService adminService;
    private String nome;
    private String novoNome;

    public AtualizarNomeCommand(AdminService adminService, String nome, String novoNome) {
        this.adminService = adminService;
        this.nome = nome;
        this.novoNome = novoNome;
    }

    @Override
    public void execute() {
        adminService.atualizarNome(nome, novoNome);
    }
}