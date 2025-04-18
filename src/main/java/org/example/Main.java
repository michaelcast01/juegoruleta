package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de la Ruleta Rusa!");
        System.out.println("Ingrese el número de jugadores (2-6):");

        int cantJugadores = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                cantJugadores = scanner.nextInt();
                if (cantJugadores >= 2 && cantJugadores <= 6) {
                    break;
                } else {
                    System.out.println("El número de jugadores debe estar entre 2 y 6. Inténtelo nuevamente:");
                }
            } else {
                System.out.println("Ingrese un número válido:");
            }
            scanner.nextLine();
        }
        scanner.nextLine();

        String[] nombresJugadores = new String[cantJugadores];
        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ":");
            nombresJugadores[i] = scanner.nextLine();
        }

        RuletaRusa ruleta = new RuletaRusa();
        ruleta.inicializar();

        int turnoActual = 0;
        while (true) {
            System.out.println("\nTurno de " + nombresJugadores[turnoActual]);
            System.out.println("Presiona ENTER para disparar...");
            scanner.nextLine();

            System.out.println("La bala se encuentra en la posición: " + ruleta.getPosicionBala());
            System.out.println("La recámara se encuentra en la posición: " + ruleta.getPosicionActual());

            if (ruleta.disparar()) {
                System.out.println("¡BANG! " + nombresJugadores[turnoActual] + " Ha muerto.");
                break;
            } else {
                System.out.println("Click. " + nombresJugadores[turnoActual] + " sobrevive.");
                System.out.println("La recámara se mueve a: " + ruleta.getPosicionActual());
                turnoActual = (turnoActual + 1) % cantJugadores;
            }
        }
        System.out.println("\nFinished.");
        scanner.close();
    }
}
