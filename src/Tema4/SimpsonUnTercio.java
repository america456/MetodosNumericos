/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema4;

/**
 *
 * @author hamer
 */
public class SimpsonUnTercio {
    
public static double f(double x) {
return x * x;
}
public static double simpsonOneThird(double a, double b, int n) {
if (n % 2 != 0) {
throw new IllegalArgumentException("n debe ser par para Simpson 1/3.");
}
double h = (b - a) / n;
double sum = f(a) + f(b);
for (int i = 1; i < n; i++) {
double x = a + i * h;
sum += (i % 2 == 0) ? 2 * f(x) : 4 * f(x);
}
return (h / 3) * sum;
}
public static void main(String[] args) {
double a = 0;
double b = 3;
int n = 6; // Debe ser par
double result = simpsonOneThird(a, b, n);
System.out.println("Resultado usando Simpson 1/3: " + result);
}
}

