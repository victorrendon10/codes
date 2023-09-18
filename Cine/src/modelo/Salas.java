package modelo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Salas {

    private int filas;
    private int columnas;
    private static int total;

    public Salas() {
    }

    public Salas(int filas, int columnas) {
        this.filas = 5;
        this.columnas = 5;
        this.total = 0;
    }

    public void reservarPuesto(int filas, int columnas, int[][] salaDeCine, Scanner scanner) {
        while (true) {
            System.out.println("Estado actual de la sala de cine:");
            mostrarSalaDeCine(salaDeCine);
            // Solicitar al usuario que seleccione una acción
            System.out.println("Seleccione una acción:");
            System.out.println("1. Reservar un asiento");
            System.out.println("2. Salir de la aplicación");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                // Reservar un asiento
                System.out.println("Ingrese la fila y columna del asiento que desea reservar (ejemplo: 2,3):");
                int fila = scanner.nextInt();
                int columna = scanner.nextInt();

                if (fila >= 1 && fila <= filas && columna >= 1 && columna <= columnas) {
                    if (salaDeCine[fila - 1][columna - 1] == 0) {
                        salaDeCine[fila - 1][columna - 1] = 1;
                        JOptionPane.showMessageDialog(null, "Puesto reservado con exito!", "Exito",
                                JOptionPane.INFORMATION_MESSAGE);

                        total += 10000;
                        System.out.println("____________________________");
                        System.out.println("| ganancias totales: $" + total);
                        System.out.println("____________________________");

                    } else {
                        JOptionPane.showMessageDialog(null, "Asiento ya reservado",
                                "No se puede reservar", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Asiento no válido. Por favor, seleccione una fila y columna válida.");
                }
            } else if (opcion == 2) {
                // Salir de la aplicación
                System.out.println("Gracias por usar la aplicación de cine. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }
    }

    // Método para mostrar el estado actual de la sala de cine
    public void mostrarSalaDeCine(int[][] salaDeCine) {
        for (int i = 0; i < salaDeCine.length; i++) {
            for (int j = 0; j < salaDeCine[i].length; j++) {
                if (salaDeCine[i][j] == 0) {
                    System.out.print("O "); // O representa un asiento vacío
                } else {
                    System.out.print("X "); // X representa un asiento ocupado
                }
            }
            System.out.println(); // Nueva línea para la siguiente fila
        }
    }

    // Inicializar la sala de cine con valores 0 (asientos vacíos)
    public void inicializarSala(int filas, int columnas, int[][] salaDeCine) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                salaDeCine[i][j] = 0;
            }
        }
    }
}
