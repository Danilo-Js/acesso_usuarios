package ufes.acesso_usuarios.model;

public class Mensagem {
    private String nomeRemetente;
    private String nomeDestinatario;
    private String mensagem;
    private boolean lida;

    public Mensagem(String nomeRemetente, String nomeDestinatario, String mensagem) {
        this.nomeRemetente = nomeRemetente;
        this.nomeDestinatario = nomeDestinatario;
        this.mensagem = mensagem;
    }

    public String getRemetente() {
        return nomeRemetente;
    }

    public String getDestinatario() {
        return nomeDestinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "nomeRemetente=" + nomeRemetente + ", mensagem=" + mensagem + ", lida=" + lida + '}';
    }
    
}
