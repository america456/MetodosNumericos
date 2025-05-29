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
public class MetodoBiseccion {
   


    public static void main(String[] args) {
        // Definimos la función: x^3 - 2x - 5 = 0
        Function<Double, Double> funcion = x -> Math.pow(x, 3) - 2*x - 5;
        
        double a = 2.0;  // Extremo inferior del intervalo
        double b = 3.0;  // Extremo superior del intervalo
        double tolerancia = 0.0001;  // Tolerancia para el error
        int maxIteraciones = 100;  // Número máximo de iteraciones
        
        double raiz = biseccion(funcion, a, b, tolerancia, maxIteraciones);
        
        System.out.printf("\nLa raíz aproximada es: %.6f%n", raiz);
        System.out.printf("f(%.6f) = %.6f%n", raiz, funcion.apply(raiz));
    }
    
    public static double biseccion(Function<Double, Double> f, double a, double b, 
                                  double tol, int maxIter) {
        // Verificación del teorema de Bolzano
        if (f.apply(a) * f.apply(b) >= 0) {
            throw new IllegalArgumentException("La función debe cambiar de signo en el intervalo [a,b]");
        }
        
        double c = a;
        int iteracion = 1;
        
        System.out.println("Iteración\t a\t\t b\t\t c\t\t f(c)");
        System.out.println("--------------------------------------------------------");
        
        while ((b - a) >= tol && iteracion <= maxIter) {
            // Punto medio
            c = (a + b) / 2;
            
            System.out.printf("%5d\t\t%.6f\t%.6f\t%.6f\t%.6f%n", 
                             iteracion, a, b, c, f.apply(c));
            
            // Comprobar si c es la raíz
            if (f.apply(c) == 0.0) {
                break;
            }
            
            // Decidir el subintervalo para la siguiente iteración
            if (f.apply(c) * f.apply(a) < 0) {
                b = c;
            } else {
                a = c;
            }
            
            iteracion++;
        }
        
        return c;
    }
}

