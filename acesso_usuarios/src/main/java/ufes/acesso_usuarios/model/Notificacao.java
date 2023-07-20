package ufes.acesso_usuarios.model;
import java.time.LocalDate;

public class Notificacao {
    private int id;
    private String remetente;
    private String destinatario;
    private String mensagem;
    private LocalDate dataEnvio;
    private boolean lida;

    public Notificacao(String remetente, String destinatario, String texto) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = texto;
        this.dataEnvio = LocalDate.now();
        this.lida = false;
    }
    
    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
    
    @Override
    public String toString() {
        return "Notificacao{" + "remetente=" + remetente + ", destinatario=" + destinatario + ", texto=" + mensagem + ", lida=" + lida + '}';
    }

}
