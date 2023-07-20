package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.service.AdminService;
import ufes.acesso_usuarios.command.*;

public class EdicaoState extends UsuarioState {
    public EdicaoState(AdminService adminService) {
        super(adminService);
    }

    @Override
    public void criarUsuario(String nome, String senha) {
        // Ação não permitida no estado de edição
        System.out.println("Ação não permitida. Você já está editando um usuário.");
    }

    @Override
    public void atualizarNome(String nome, String novoNome) {
        Command command = new AtualizarNomeCommand(adminService, nome, novoNome);
        command.execute();
    }

    @Override
    public void atualizarSenha(String nome, String novaSenha) {
        Command command = new AtualizarSenhaCommand(adminService, nome, novaSenha);
        command.execute();
    }

    @Override
    public void deletarUsuario(String nome) {
        Command command = new DeletarUsuarioCommand(adminService, nome);
        command.execute();
    }
}
