package org.example;
import java.util.Random;

public class RuletaRusa {
    private int posicionActual;
    private int posicionBala;
    private Random random = new Random();

    public RuletaRusa() {
    }

    public void inicializar() {
        posicionBala = random.nextInt(6);
        posicionActual = random.nextInt(6);
        System.out.println("Bala en: " + posicionBala);
        System.out.println("Recámara en: " + posicionActual);
    }

    public boolean disparar() {
        if (posicionActual == posicionBala) {
            return true;
        }
        posicionActual = random.nextInt(6);
        return false;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public int getPosicionBala() {
        return posicionBala;
    }
}
