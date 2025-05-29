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
public class MetodoSecante {
    
    public static void main(String[] args) {
        // Definimos la función: x² - 5x + 6 = 0 (raíces en x=2 y x=3)
        Function<Double, Double> funcion = x -> Math.pow(x, 2) - 5 * x + 6;
        
        double x0 = 1.5;  // Primer valor inicial
        double x1 = 2.5;  // Segundo valor inicial
        double tolerancia = 0.0001;  // Tolerancia de error
        int maxIteraciones = 100;  // Máximo de iteraciones
        
        double raiz = secante(funcion, x0, x1, tolerancia, maxIteraciones);
        
        System.out.printf("\nLa raíz aproximada es: %.6f%n", raiz);
        System.out.printf("f(%.6f) = %.6f%n", raiz, funcion.apply(raiz));
    }
    
    public static double secante(Function<Double, Double> f, double x0, double x1, 
                                double tol, int maxIter) {
        double x2;
        int iteracion = 1;
        
        System.out.println("Iteración\t x0\t\t x1\t\t x2\t\t f(x2)");
        System.out.println("--------------------------------------------------------");
        
        do {
            // Fórmula de la secante: x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0))
            x2 = x1 - (f.apply(x1) * (x1 - x0)) / (f.apply(x1) - f.apply(x0));
            
            System.out.printf("%5d\t\t%.6f\t%.6f\t%.6f\t%.6f%n", 
                           iteracion, x0, x1, x2, f.apply(x2));
            
            // Verificar convergencia
            if (Math.abs(x2 - x1) < tol) {
                break;
            }
            
            // Actualizar valores para la siguiente iteración
            x0 = x1;
            x1 = x2;
            iteracion++;
            
        } while (iteracion <= maxIter);
        
        return x2;
    }
}
    

