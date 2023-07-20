package ufes.acesso_usuarios.command;

import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;

public class DeletarUsuarioCommand extends ManterUsuarioCommand {

    public DeletarUsuarioCommand(TelaManterUsuarioPresenter presenterTelaUsuarioPresenter, String nomeUsuario) {
        super(presenterTelaUsuarioPresenter);
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public void execute() {
        usuarioService.removerUsuario(nomeUsuario);
    }
}

