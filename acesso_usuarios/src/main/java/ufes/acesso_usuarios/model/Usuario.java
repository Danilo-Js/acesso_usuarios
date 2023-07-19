package ufes.acesso_usuarios.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private LocalDate dataCadastro;
    private boolean autorizado;
    private ArrayList<Notificacao> notificacoes;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.dataCadastro = LocalDate.now();
        this.autorizado = false;
        this.notificacoes = new ArrayList<>();
    }

    public void addNotificacao(Notificacao notificacao) {
        notificacoes.add(notificacao);
    }

    public void marcarNotificacoesComoLidas() {
        for (Notificacao notificacao : notificacoes) {
            notificacao.setLida(true);
        }
    }
    
    public int getQtdNotificacoesRecebidas() {
        return notificacoes.size();
    }

    public int getQtdNotificacoesLidas() {
        int cont = 0;
        for (Notificacao notificacao : notificacoes) {
            if (notificacao.isLida()) {
                cont++;
            }
        }
        return cont;
    }
    
    public void alterarSenha(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public ArrayList<Notificacao> getNotificacoes() {
        return notificacoes;
    }  
}
