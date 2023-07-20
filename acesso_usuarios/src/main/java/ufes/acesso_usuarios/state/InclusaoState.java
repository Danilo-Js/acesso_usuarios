package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.command.*;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;

public class InclusaoState extends UsuarioState {

    public InclusaoState(TelaManterUsuarioPresenter presenterTelaManterUsuario) {
        super(presenterTelaManterUsuario);
    }

    @Override
    public void criarUsuario() {
        ICommand command = new CriarUsuarioCommand(presenterTelaManterUsuario);
        command.execute();
    }

}

