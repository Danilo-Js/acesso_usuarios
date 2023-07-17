package ufes.acesso_usuarios.service;

import java.util.ArrayList;
import ufes.acesso_usuarios.model.Mensagem;
import ufes.acesso_usuarios.model.Usuario;
import ufes.acesso_usuarios.repository.UsuarioRepository;

public class UsuarioService {

    private SistemaService sistemaService;
    private UsuarioRepository usuarioRepository;
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;

    public UsuarioService() {
        this.sistemaService = SistemaService.getInstance();
        this.usuarioRepository = UsuarioRepository.getInstance();
    }

    public void criarUsuario(Usuario usuario) {
        this.usuarioRepository.addUsuario(usuario);
    }

    public void acessar(String nomeUsuario, String senha) {
        this.usuarios = this.usuarioRepository.getUsuarios();
        if (this.usuarios.size() == 1) {
            this.usuario = this.usuarioRepository.buscar(nomeUsuario);
            this.sistemaService.addUsuarioAutorizado(usuario, "admin");
        }
        this.sistemaService.fazerLogin(nomeUsuario, senha);
    }

    public void visualizarMensagem(String nomeDestinatario) {
        this.usuario = this.usuarioRepository.buscar(nomeDestinatario);
        if (this.usuario != null) {
            ArrayList<Mensagem> mensagens = this.usuario.getMensagens();
            for (Mensagem mensagem : mensagens) {
                System.out.println("Mensagem: " + mensagem.toString());
                marcarMensagemComoLida(mensagem);
            }
        }
    }

    public void marcarMensagemComoLida(Mensagem mensagem) {
        mensagem.setLida(true);
    }

}
