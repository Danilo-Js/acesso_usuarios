package ufes.acesso_usuarios.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Danilo-Js
 */
public class Log {
    
    private ILog log;
    
    public Log() {
        String configuracao = this.getConfiguracao();
        setLog(configuracao);
    }
    
    // busca a configuração escolhida salva em FormatoLog.txt
    public String getConfiguracao() {
        StringBuilder conteudo = new StringBuilder();
        String caminhoArquivo = System.getProperty("user.dir") + File.separator + "formatoLog.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return conteudo.toString();
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
