package ufes.acesso_usuarios.log;

public class LogService {
    public void registrarLog(String operacao, String nome) {
        String log = operacao + ": " + nome + ", (" + getDataAtual() + ", " + getHoraAtual() + ", " + getUsuarioAtual() + ")";
        // Lógica para registrar o log em arquivo
        System.out.println(log);
    }

    public void registrarLogFalha(String operacao, String mensagem) {
        String log = "Ocorreu a falha " + mensagem + " ao realizar a " + operacao + ", (" + getDataAtual() + ", " + getHoraAtual() + ", " + getUsuarioAtual() + ")";
        // Lógica para registrar o log de falha em arquivo
        System.out.println(log);
    }

    private String getDataAtual() {
        // Lógica para obter a data atual do sistema
        return "DD/MM/AAAA";
    }

    private String getHoraAtual() {
        // Lógica para obter a hora atual do sistema
        return "HH:MM:SS";
    }

    private String getUsuarioAtual() {
        // Lógica para obter o usuário autenticado no sistema
        return "Usuário Autenticado";
    }
}
