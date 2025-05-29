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
public class NewtonRapshon {
    
    public static void main(String[] args) {
        // Definimos la función y su derivada: f(x) = x^3 - 2x - 5
        Function<Double, Double> funcion = x -> Math.pow(x, 3) - 2*x - 5;
        Function<Double, Double> derivada = x -> 3*Math.pow(x, 2) - 2;
        
        double x0 = 2.0;         // Valor inicial
        double tolerancia = 1e-6; // Tolerancia (1×10⁻⁶)
        int maxIteraciones = 100; // Límite de iteraciones
        
        double raiz = newtonRaphson(funcion, derivada, x0, tolerancia, maxIteraciones);
        
        System.out.printf("\nLa raíz aproximada es: %.8f%n", raiz);
        System.out.printf("f(%.8f) = %.12f%n", raiz, funcion.apply(raiz));
    }
    
    public static double newtonRaphson(Function<Double, Double> f, 
                                     Function<Double, Double> df, 
                                     double x0, 
                                     double tol, 
                                     int maxIter) {
        double x = x0;
        int iteracion = 1;
        
        System.out.println("Iteración\t x_n\t\t f(x_n)\t\t Error");
        System.out.println("--------------------------------------------------------");
        
        while (iteracion <= maxIter) {
            double fx = f.apply(x);
            double dfx = df.apply(x);
            
            if (Math.abs(fx) < tol) {
                System.out.printf("%5d\t\t%.8f\t%.8f\t%.8f%n", 
                               iteracion, x, fx, Math.abs(fx));
                break;
            }
            
            if (Math.abs(dfx) < 1e-15) {
                throw new ArithmeticException("Derivada cercana a cero. No se puede continuar.");
            }
            
            double xNuevo = x - fx/dfx;
            double error = Math.abs(xNuevo - x);
            
            System.out.printf("%5d\t\t%.8f\t%.8f\t%.8f%n", 
                           iteracion, x, fx, error);
            
            if (error < tol) {
                break;
            }
            
            x = xNuevo;
            iteracion++;
        }
        
        return x;
    }
}

