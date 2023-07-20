package ufes.acesso_usuarios.log;

/**
 *
 * @author Danilo-Js
 */
public interface ILog {
    // log caso a operação tenha sido feita com sucesso
    public void escrever_Sucesso(String operacao, String nome, String usuario);
    
    public String criaLog_Sucesso(String operacao, String nome, String data, String hora, String usuario);

    // log caso houve um erro na operação
    public void escrever_Falha(String mensagemFalha, String operacao, String nome, String usuario);
    
    public String criaLog_Falha(String mensagemFalha, String operacao, String nome, String data, String hora, String usuario);
}
