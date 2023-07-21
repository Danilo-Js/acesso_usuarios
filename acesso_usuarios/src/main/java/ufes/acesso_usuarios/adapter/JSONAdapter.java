package ufes.acesso_usuarios.adapter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo-Js
 */
public class JSONAdapter implements ILog {

    private final String path = Paths.get(System.getProperty("user.dir")).toString();    
    private final String file = "/LogJSON.json";

    @Override
    public void escrever_Sucesso(String operacao, String nome, String usuario) {
        // formata o log
        String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String logEntry = criaLog_Sucesso(operacao, nome, data, hora, usuario);
        
        // escreve o log
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + file, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar log: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar log: " + e);
        }
    }
    
    // pega a string a ser inserida
    @Override
    public String criaLog_Sucesso(String operacao, String nome, String data, String hora, String usuario) {
        String resumo = operacao + ":" + nome + ",(" + data + "," + hora + "," + usuario;
        
        StringBuilder builder = new StringBuilder();
        builder.append("{")
            .append("\"RESUMO\": \"").append(resumo).append("\",")
            .append("\"OPERACAO\": \"").append(operacao).append("\",")            
            .append("\"NOME\": \"").append(nome).append("\",")
            .append("\"DATA\": \"").append(data).append("\",")
            .append("\"HORA\": \"").append(hora).append("\",")
            .append("\"USUARIO\": \"").append(usuario).append("\"")
        .append("}");
        return builder.toString();
    }
    
    @Override
    public void escrever_Falha(String mensagemFalha, String operacao, String nome, String usuario) {
        // formata o log
        String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String logEntry = criaLog_Falha(mensagemFalha, operacao, nome, data, hora, usuario);
        
        // escreve o log
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + file, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar log: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar log: " + e);
        }
    }
    
    // pega a string a ser inserida
    @Override
    public String criaLog_Falha(String mensagemFalha, String operacao, String nome, String data, String hora, String usuario) {
        String resumo = "Ocorreu a falha " + mensagemFalha + " ao realizar a operação " + operacao + " do contato " + nome + ",(" + data + "," + hora + "," + usuario;
        
        StringBuilder builder = new StringBuilder();
        builder.append("{")
            .append("\"RESUMO\": \"").append(resumo).append("\",")
            .append("\"MENSAGEM DE FALHA\": \"").append(mensagemFalha).append("\",")
            .append("\"OPERACAO\": \"").append(operacao).append("\",")
            .append("\"NOME\": \"").append(nome).append("\",")
            .append("\"DATA\": \"").append(data).append("\",")
            .append("\"HORA\": \"").append(hora).append("\",")
            .append("\"USUARIO\": \"").append(usuario).append("\"")
        .append("}");
        return builder.toString();
    }
}
