package ufes.acesso_usuarios.model;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String nomeUsuario;
    private String senha;
    private String tipo;
    private boolean autorizacao;
    private ArrayList<Mensagem> mensagens;
    
    public Usuario(String nome, String nomeUsuario, String senha) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.mensagens = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String usuario) {
        this.nomeUsuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    public void addMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }
    
}
