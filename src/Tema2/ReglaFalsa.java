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
public class ReglaFalsa {
    public static void main(String[] args) {
        // Definimos la función: x³ - 2x - 5 = 0 (tiene una raíz en ≈2.0946)
        Function<Double, Double> funcion = x -> Math.pow(x, 3) - 2 * x - 5;
        
        double a = 2.0;  // Extremo izquierdo del intervalo
        double b = 3.0;  // Extremo derecho del intervalo
        double tolerancia = 0.0001;  // Tolerancia de error
        int maxIteraciones = 100;  // Máximo de iteraciones
        
        double raiz = reglaFalsa(funcion, a, b, tolerancia, maxIteraciones);
        
        System.out.printf("\nLa raíz aproximada es: %.6f%n", raiz);
        System.out.printf("f(%.6f) = %.6f%n", raiz, funcion.apply(raiz));
    }
    
    public static double reglaFalsa(Function<Double, Double> f, double a, double b, 
                                  double tol, int maxIter) {
        // Verificar que f(a) y f(b) tengan signos opuestos
        if (f.apply(a) * f.apply(b) >= 0) {
            throw new IllegalArgumentException("La función debe cambiar de signo en [a, b].");
        }
        
        double c = 0;  // Punto de corte con el eje x
        int iteracion = 1;
        
        System.out.println("Iteración\t a\t\t b\t\t c\t\t f(c)");
        System.out.println("--------------------------------------------------------");
        
        do {
            // Fórmula de la Regla Falsa: c = (a*f(b) - b*f(a)) / (f(b) - f(a))
            c = (a * f.apply(b) - b * f.apply(a)) / (f.apply(b) - f.apply(a));
            
            System.out.printf("%5d\t\t%.6f\t%.6f\t%.6f\t%.6f%n", 
                           iteracion, a, b, c, f.apply(c));
            
            // Si f(c) es suficientemente pequeño, terminar
            if (Math.abs(f.apply(c)) < tol) {
                break;
            }
            
            // Decidir qué extremo reemplazar
            if (f.apply(c) * f.apply(a) < 0) {
                b = c;  // La raíz está en [a, c]
            } else {
                a = c;  // La raíz está en [c, b]
            }
            
            iteracion++;
            
        } while (iteracion <= maxIter);
        
        return c;
    }
}
