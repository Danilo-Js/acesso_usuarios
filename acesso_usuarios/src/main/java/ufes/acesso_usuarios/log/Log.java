package ufes.acesso_usuarios.log;

/**
 *
 * @author Danilo-Js
 */
public class Log {
    
    private ILog log;
    
    public Log(String configuracao) {
        setLog(configuracao);
    }

    public ILog getLog() {
        return log;
    }
    
    public void setLog(String configuracao) {
        if (configuracao.equals("CSV")) {
            this.log = new CSVAdapter();
        } else {
            this.log = new JSONAdapter();
        }
    }
}