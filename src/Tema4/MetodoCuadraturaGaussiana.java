/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema4;

/**
 *
 * @author hamer
 */
public class MetodoCuadraturaGaussiana {
 
public static void main(String[] args) {
// Intervalo de integración
double a = 1.0;
double b = 3.0;
// Puntos y pesos de Gauss-Legendre para n = 2
double[] xi = { -1.0 / Math.sqrt(3), 1.0 / Math.sqrt(3) };
double[] wi = { 1.0, 1.0 };
double suma = 0.0;
// Aplicamos el cambio de variable y sumamos
for (int i = 0; i < 2; i++) {
double x = ((b - a) / 2.0) * xi[i] + (a + b) / 2.0;
double fx = Math.log(x); // f(x) = ln(x)
suma += wi[i] * fx;
}
double resultado = ((b - a) / 2.0) * suma;

System.out.printf("Aproximación de la integral ∫ln(x) dx de 1 a 3 ≈ %.6f%n", resultado);
        
        } 
}

