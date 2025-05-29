/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema4;

import java.util.Scanner;

/**
 *
 * @author hamer
 */
public class MetodoTrapecio {
    

public static double f(double x) {
return Math.log(x);
}
public static double metodoTrapecio(double a, double b, int n) {
double h = (b - a) / n;
double suma = f(a) + f(b);
for (int i = 1; i < n; i++) {
double xi = a + i * h;
suma += 2 * f(xi);
}
return (h / 2) * suma;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Método del Trapecio - Integración Numérica");
System.out.print("Ingresa el límite inferior a: ");
double a = scanner.nextDouble();
System.out.print("Ingresa el límite superior b: ");
double b = scanner.nextDouble();
System.out.print("Ingresa el número de subintervalos n: ");
int n = scanner.nextInt();
double resultado = metodoTrapecio(a, b, n);
System.out.printf("La aproximación de la integral es: %.4f%n",
resultado);
}
}
    
    
    

