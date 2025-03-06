package org.example;
import java.util.Random;
public class RuletaRusa {
    private String[] jugadores;
    private int posicionActual;
    private int posicionBala;
    private Random random = new Random();

    public RuletaRusa() {
    }

    public RuletaRusa(String[] jugadores, int posicionActual, int posicionBala, Random random) {
        this.jugadores = jugadores;
        this.posicionActual = posicionActual;
        this.posicionBala = posicionBala;
        this.random = random;
    }



    public void inicializar() {
        posicionBala = random.nextInt(6);
        posicionActual = random.nextInt(6);
        System.out.println("Bala en: " + posicionBala);
        System.out.println("Recámara en: " + posicionActual);
    }

    // Dispara: si la posición actual coincide con la bala, devuelve true (el jugador pierde)
    public boolean disparar() {
        if (posicionActual == posicionBala) {
            return true;
        }
        posicionActual = (posicionActual + 1) % 6;
        return false;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public int getPosicionBala() {
        return posicionBala;
    }
}
