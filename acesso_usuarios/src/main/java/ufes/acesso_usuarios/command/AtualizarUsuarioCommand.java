package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;
import ufes.acesso_usuarios.state.VisualizacaoState;

public class AtualizarUsuarioCommand extends ManterUsuarioCommand {
    //private TelaManterUsuarioPresenter telaManterUsuarioPresenter;
    
    public AtualizarUsuarioCommand(TelaManterUsuarioPresenter presenterTelaUsuarioPresenter, String nomeUsuario) {
        super(presenterTelaUsuarioPresenter);
        this.nomeUsuario = nomeUsuario;
        //this.telaManterUsuarioPresenter = new TelaManterUsuarioPresenter(usuario);
    }

    @Override
    public void execute() {
        
        Usuario usuarioEditado = usuarioService.buscarUsuario("gabriel");
        System.out.println("Editado: " + usuarioEditado);
        
        String novoNome = presenterManterUsuario.getTelaManterUsuario().getInputNome().getText();
        String novoNomeUsuario = presenterManterUsuario.getTelaManterUsuario().getInputUsuario().getText();
        String novaSenha = presenterManterUsuario.getTelaManterUsuario().getInputSenha().getText();
        System.out.println("Nova senha: " + novaSenha);
        
        usuarioEditado.setNome(novoNome);
        usuarioEditado.setUsuario(novoNomeUsuario);
        usuarioEditado.setSenha(novaSenha);
        
        usuarioService.atualizarUsuario(usuarioEditado);
        presenterManterUsuario.alterarEstado(new VisualizacaoState(presenterManterUsuario, novoNome));
    }

}
