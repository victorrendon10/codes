package vista;

import java.util.Scanner;

import modelo.Salas;

public class Cine {
    public static void main(String[] args) {
        // Definir el número de filas y columnas para la sala de cine
        int filas = 5;
        int columnas = 5;
        Scanner scanner = new Scanner(System.in);
        Salas sala1 = new Salas();
        int[][] salaDeCine = new int[filas][columnas];
        
        sala1.inicializarSala(filas, columnas, salaDeCine);
        sala1.reservarPuesto(filas, columnas, salaDeCine, scanner);
        scanner.close();

    }
}
