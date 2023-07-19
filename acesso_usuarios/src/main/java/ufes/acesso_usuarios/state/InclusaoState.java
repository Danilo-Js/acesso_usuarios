package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.service.AdminService;
import ufes.acesso_usuarios.command.*;

public class InclusaoState extends UsuarioState {
    public InclusaoState(AdminService adminService) {
        super(adminService);
    }

    @Override
    public void criarUsuario(String nome, String senha) {
        Command command = new CriarUsuarioCommand(adminService, nome, senha);
        command.execute();
    }

    @Override
    public void atualizarNome(String nome, String novoNome) {
        // Ação não permitida no estado de inclusão
        System.out.println("Ação não permitida. O usuário ainda não foi criado.");
    }

    @Override
    public void atualizarSenha(String nome, String novaSenha) {
        // Ação não permitida no estado de inclusão
        System.out.println("Ação não permitida. O usuário ainda não foi criado.");
    }

    @Override
    public void deletarUsuario(String nome) {
        // Ação não permitida no estado de inclusão
        System.out.println("Ação não permitida. O usuário ainda não foi criado.");
    }
}

