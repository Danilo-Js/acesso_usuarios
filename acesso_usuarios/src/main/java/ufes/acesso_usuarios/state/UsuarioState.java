package ufes.acesso_usuarios.state;
import ufes.acesso_usuarios.presenter.TelaManterUsuarioPresenter;


public abstract class UsuarioState {
    protected TelaManterUsuarioPresenter presenterTelaManterUsuario;
    protected String nomeUsuario;
    
    public UsuarioState(TelaManterUsuarioPresenter presenterTelaManterUsuario) {
        this.presenterTelaManterUsuario = presenterTelaManterUsuario;
    }

//    public void visualizarUsuario(String nome) {
//        Command command = new VisualizarUsuarioCommand(adminService, nome);
//        command.execute();
//    }

    public void criarUsuario(){
        throw new RuntimeException("Opção não disponível.");
    }
    
    public void atualizarUsuario(){
        throw new RuntimeException("Opção não disponível.");
    }

    public void deletarUsuario(){
        throw new RuntimeException("Opção não disponível.");
    }
    
//    public void fecharTela(){
//        this.presenterTelaManterUsuario.fecharTela();
//    }
}
