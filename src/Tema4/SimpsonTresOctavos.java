/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema4;

/**
 *
 * @author hamer
 */
public class SimpsonTresOctavos {

// Definir la función a integrar: f(x) = sin(x)
public static double f(double x) {
return Math.sin(x);
}
// Implementación del método de Simpson 3/8
public static double simpsonThreeEighths(double a, double b, int n) {
if (n % 3 != 0) {
throw new IllegalArgumentException("n debe ser múltiplo de 3 para el método de Simpson 3/8.");
}
double h = (b - a) / n;
double sum = f(a) + f(b);
for (int i = 1; i < n; i++) {
double x = a + i * h;
if (i % 3 == 0) {
sum += 2 * f(x);
} else {
sum += 3 * f(x);
}
}
return (3 * h / 8) * sum;
}
public static void main(String[] args) {
double a = 0;
double b = Math.PI / 2; // Límite superior π/2
int n = 6; // Número de subintervalos (debe ser múltiplo de 3)
double resultado = simpsonThreeEighths(a, b, n);
System.out.println("Resultado aproximado con Simpson 3/8: " +
resultado);
// Mostrar el valor exacto conocido para comparación
System.out.println("Valor exacto esperado: 1.0");
System.out.println("Error absoluto: " + Math.abs(1.0 - resultado));
}
}

