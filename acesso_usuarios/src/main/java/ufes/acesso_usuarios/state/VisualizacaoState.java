package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.command.*;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;

public class VisualizacaoState extends UsuarioState {
    
    public VisualizacaoState(TelaManterUsuarioPresenter presenterTelaUsuarioPresenter, String nomeUsuario) {
        super(presenterTelaUsuarioPresenter);
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public void atualizarUsuario() {
        ICommand command = new DeletarUsuarioCommand(presenterTelaManterUsuario, nomeUsuario);
        command.execute();
    }

    @Override
    public void deletarUsuario() {
        ICommand command = new DeletarUsuarioCommand(presenterTelaManterUsuario, nomeUsuario);
        command.execute();
    }
}
