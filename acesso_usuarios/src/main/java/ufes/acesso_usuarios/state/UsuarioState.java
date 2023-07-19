package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.service.AdminService;

public abstract class UsuarioState {
    protected AdminService adminService;

    public UsuarioState(AdminService adminService) {
        this.adminService = adminService;
    }

    public void visualizarUsuario(String nome) {
        adminService.buscarUsuario(nome);
    }

    public abstract void criarUsuario(String nome, String senha);
    public abstract void atualizarNome(String nome, String novoNome);
    public abstract void atualizarSenha(String nome, String novaSenha);
    public abstract void deletarUsuario(String nome);
}
