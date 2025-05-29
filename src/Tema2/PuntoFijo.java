/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema2;

import java.util.function.Function;

/**
 *
 * @author hamer
 */
public class PuntoFijo {
   
    public static void main(String[] args) {
        // Definimos la función g(x) tal que x = g(x)
        // Para la ecuación original: x² - 5x + 6 = 0
        // Podemos reordenar como: x = (x² + 6)/5
        Function<Double, Double> g = x -> (Math.pow(x, 2) + 6) / 5;
        
        double x0 = 1.5;       // Valor inicial
        double tolerancia = 0.0001;  // Tolerancia
        int maxIteraciones = 100;    // Iteraciones máximas
        
        double raiz = puntoFijo(g, x0, tolerancia, maxIteraciones);
        
        System.out.printf("\nLa raíz aproximada es: %.6f%n", raiz);
        System.out.printf("g(%.6f) = %.6f%n", raiz, g.apply(raiz));
    }
    
    public static double puntoFijo(Function<Double, Double> g, double x0, 
                                 double tol, int maxIter) {
        double x1;
        int iteracion = 1;
        
        System.out.println("Iteración\t x_actual\t x_siguiente\t Diferencia");
        System.out.println("--------------------------------------------------------");
        
        do {
            x1 = g.apply(x0);
            
            System.out.printf("%5d\t\t%.6f\t%.6f\t%.6f%n", 
                           iteracion, x0, x1, Math.abs(x1 - x0));
            
            if (Math.abs(x1 - x0) < tol) {
                break;
            }
            
            x0 = x1;
            iteracion++;
            
        } while (iteracion <= maxIter);
        
        return x1;
    }
}
