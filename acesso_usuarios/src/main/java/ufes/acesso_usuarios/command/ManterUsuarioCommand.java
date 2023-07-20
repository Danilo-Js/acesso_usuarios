package ufes.acesso_usuarios.command;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;
import ufes.acesso_usuarios.service.UsuarioService;

public abstract class ManterUsuarioCommand implements ICommand{
    
    protected UsuarioService usuarioService;
    protected TelaManterUsuarioPresenter presenterManterUsuario;
    
    protected String nome;
    protected String nomeUsuario;
    protected String senha;
    protected Usuario usuario;

    public ManterUsuarioCommand(TelaManterUsuarioPresenter presenterManterUsuario) {
        this.usuarioService = UsuarioService.getInstance();
        this.presenterManterUsuario = presenterManterUsuario;
    }
    
    @Override
    public abstract void execute();
    
}
