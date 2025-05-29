/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema5;

/**
 *
 * @author hamer
 */
public class MetodoDeRegresion {
    
   
public static void main(String[] args) {
double[] x = {1, 2, 3};
double[] y = {2, 3, 5};
int n = x.length;
double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
for (int i = 0; i < n; i++) {
sumX += x[i];
sumY += y[i];
sumXY += x[i] * y[i];
sumX2 += x[i] * x[i];
}
double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
double a = (sumY - b * sumX) / n;
System.out.printf("Problema 1: y = %.3f + %.3fx\n", a, b);
}
}
    
    
    
    
    
    
    
    
    

