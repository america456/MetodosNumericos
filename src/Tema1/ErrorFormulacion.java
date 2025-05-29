/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema1;

/**
 *
 * @author hamer
 */
public class ErrorFormulacion {
    
    // Modelo exacto (realidad)
    public static double modeloReal(double x) {
        return Math.exp(x); // Función exponencial exacta
    }
    
    // Modelo aproximado (formulación con error)
    public static double modeloAproximado(double x) {
        // Aproximación por serie de Taylor truncada (introduce error de formulación)
        return 1 + x + (x*x)/2; // Solo 3 términos de la serie
    }
    
    public static void main(String[] args) {
        double x = 0.5; // Valor para evaluar
        
        System.out.println("ERROR DE FORMULACIÓN");
        System.out.println("---------------------");
        System.out.printf("Valor real de e^%.2f: %.8f%n", x, modeloReal(x));
        System.out.printf("Valor aproximado: %.8f%n", modeloAproximado(x));
        
        double error = Math.abs(modeloReal(x) - modeloAproximado(x));
        System.out.printf("Error de formulación: %.8f%n", error);
        System.out.printf("Error relativo: %.4f%%%n", (error/modeloReal(x))*100);
        
        // Comparación para diferentes valores de x
        System.out.println("\nComparación para diferentes valores:");
        System.out.printf("%-8s %-12s %-12s %-15s%n", "x", "Real", "Aproximado", "Error");
        
        for(double xi = 0; xi <= 1.0; xi += 0.1) {
            double real = modeloReal(xi);
            double aprox = modeloAproximado(xi);
            double err = Math.abs(real - aprox);
            System.out.printf("%-8.2f %-12.8f %-12.8f %-15.8f%n", xi, real, aprox, err);
        }
    }
    }

