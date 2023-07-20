package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.service.AdminService;
import ufes.acesso_usuarios.command.*;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;

public class EdicaoState extends UsuarioState {

    public EdicaoState(TelaManterUsuarioPresenter presenterTelaManterUsuario) {
        super(presenterTelaManterUsuario);
    }

    @Override
    public void atualizarUsuario() {
        ICommand command = new AtualizarUsuarioCommand(presenterTelaManterUsuario, nomeUsuario);
        command.execute();
    }

//    @Override
//    public void fecharTela() {
//        ICommand command = new  AtualizarUsuarioCommand(presenterTelaManterUsuario, nomeUsuario);
//        command.execute();
//    }
}
