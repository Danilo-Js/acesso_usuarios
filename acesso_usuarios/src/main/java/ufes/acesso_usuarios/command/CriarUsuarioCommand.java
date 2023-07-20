package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;

public class CriarUsuarioCommand extends ManterUsuarioCommand {
    
    public CriarUsuarioCommand(TelaManterUsuarioPresenter presenterTelaUsuarioPresenter) {
        super(presenterTelaUsuarioPresenter);
    }

    @Override
    public void execute() {
        nome = presenterManterUsuario.getTelaManterUsuario().getInputNome().getText();
        nomeUsuario = presenterManterUsuario.getTelaManterUsuario().getInputUsuario().getText();
        senha = presenterManterUsuario.getTelaManterUsuario().getInputSenha().getText();
        usuario = new Usuario(nome, nomeUsuario, senha);
        System.out.println("Alou...");
        usuarioService.criarUsuario(usuario);
    }
    
}