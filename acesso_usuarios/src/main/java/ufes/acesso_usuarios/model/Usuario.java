package ufes.acesso_usuarios.model;
import ufes.acesso_usuarios.state.UsuarioState;
import java.time.LocalDate;
import java.util.ArrayList;
import ufes.acesso_usuarios.service.UsuarioService;

public class Usuario {
    private String nome;
    private String usuario;
    private String senha;
    private LocalDate dataCadastro;
    private boolean autorizado;
    private ArrayList<Notificacao> notificacoes;
    private String tipo;
    //protected UsuarioState estado;
    private UsuarioService usuarioService;

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dataCadastro = LocalDate.now();
        this.autorizado = false;
        this.notificacoes = new ArrayList<>();
        //this.estado = null; // Estado inicial é nulo
    }

    public void addNotificacao(Notificacao notificacao) {
        notificacoes.add(notificacao);
        //Salva as alterações
        usuarioService.atualizarUsuario(this);
    }

    public void marcarNotificacoesComoLidas() {
        for (Notificacao notificacao : notificacoes) {
            notificacao.setLida(true);
        }
        //Salva as alterações
        usuarioService.atualizarUsuario(this);
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

    public void alterarSenha(String senha) {
        this.senha = senha;
        //Salva as alterações
        usuarioService.atualizarUsuario(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

//    public void setEstado(UsuarioState estado) {
//        this.estado = estado;
//    }
//    
//    public UsuarioState getEstado() {
//        return estado;
//    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ",usuario=" + usuario + ", senha=" + senha + ", dataCadastro=" + dataCadastro + ", autorizado=" + autorizado + ", notificacoes=" + notificacoes + ", tipo=" + tipo /*+ ", estado=" + estado*/ + ", usuarioService=" + usuarioService + '}';
    }
    
}
