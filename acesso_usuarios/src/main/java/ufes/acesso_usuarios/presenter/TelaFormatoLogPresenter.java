package ufes.acesso_usuarios.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import ufes.acesso_usuarios.view.TelaFormatoLogView;

public class TelaFormatoLogPresenter {

    private TelaFormatoLogView telaConfiguracoesLogView;

    public TelaFormatoLogPresenter() {
        this.telaConfiguracoesLogView = new TelaFormatoLogView();
        this.telaConfiguracoesLogView.setVisible(true);
        this.telaConfiguracoesLogView.setLocationRelativeTo(null);
        this.telaConfiguracoesLogView.setResizable(false);
        listenerOpcaoFormatoLog();
    }

    public void listenerOpcaoFormatoLog() {
        //Botão Configuração de Log
        this.telaConfiguracoesLogView.getSelectFormatoLog().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String formatoLog = (String) telaConfiguracoesLogView.getSelectFormatoLog().getSelectedItem();
                // Salvar o texto em um arquivo .txt na raiz do projeto
                String caminhoArquivo = System.getProperty("user.dir") + File.separator + "formatoLog.txt";
                try (FileWriter writer = new FileWriter(caminhoArquivo)) {
                    writer.write(formatoLog);
                    exibirMensagem("Formato de LOG salvo com sucesso.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(telaConfiguracoesLogView, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        telaConfiguracoesLogView.dispose();
    }

}
