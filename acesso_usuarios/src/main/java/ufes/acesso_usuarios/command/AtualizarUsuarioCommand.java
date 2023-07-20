package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;
import ufes.acesso_usuarios.state.VisualizacaoState;

public class AtualizarUsuarioCommand extends ManterUsuarioCommand {

    public AtualizarUsuarioCommand(TelaManterUsuarioPresenter presenterTelaUsuarioPresenter, String nomeUsuario) {
        super(presenterTelaUsuarioPresenter);
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public void execute() {
        //Preencher dados do usuário na view
        presenterManterUsuario.validarOpcao("editarUsuario");
        
        Usuario usuarioEditado = adminService.buscarUsuario(nomeUsuario);
        
        String novoNome = presenterManterUsuario.getTelaManterUsuario().getInputNome().getText();
        String novoNomeUsuario = presenterManterUsuario.getTelaManterUsuario().getInputUsuario().getText();
        String novaSenha = presenterManterUsuario.getTelaManterUsuario().getInputSenha().getText();
        
        usuarioEditado.setNome(novoNome);
        usuarioEditado.setUsuario(novoNomeUsuario);
        usuarioEditado.setSenha(novaSenha);
        
        adminService.atualizarUsuario(usuarioEditado);
        presenterManterUsuario.alterarEstado(new VisualizacaoState(presenterManterUsuario, novoNome));
    }

}
