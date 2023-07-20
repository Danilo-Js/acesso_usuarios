package ufes.acesso_usuarios.observer;
import java.util.ArrayList;

public abstract class Observado {
    private ArrayList<Observer> observadores;

    public Observado() {
        this.observadores = new ArrayList();
    }
    
    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observer observador : observadores) {
            observador.atualizar();
        }
    }
}
