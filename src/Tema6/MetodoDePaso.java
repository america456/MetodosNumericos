/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema6;

import java.text.DecimalFormat;

/**
 *
 * @author hamer
 */
public class MetodoDePaso {
    
// Función f(x, y) que representa la derivada dy/dx
public static double f(double x, double y) {
return x + y; // Ejemplo: dy/dx = x + y
}
public static void metodoEuler(double x0, double y0, double h, int n) {
double x = x0;
double y = y0;
DecimalFormat df = new DecimalFormat("#.##");
System.out.println("x\t\ty");
for (int i = 0; i <= n; i++) {
System.out.println(df.format(x) + "\t\t" + df.format(y));
y = y + h * f(x, y);
x = x + h;
}
}
public static void main(String[] args) {
double x0 = 0;
double y0 = 1;
double h = 0.1;
int n = 10;
metodoEuler(x0, y0, h, n);
}
}
    

