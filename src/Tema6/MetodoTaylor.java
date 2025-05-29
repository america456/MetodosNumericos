/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema6;

/**
 *
 * @author hamer
 */
public class MetodoTaylor {
    

// Método que calcula la n-ésima derivada de la función en el punto a
public static double derivative(int n, double a) {
// Aquí debes definir las derivadas de la función que deseas aproximar
// Por ejemplo, si f(x) = e^x, las derivadas son siempre e^a
return Math.exp(a); // Ejemplo para f(x) = e^x
}

// Método que calcula la aproximación de Taylor
public static double taylorSeries(double a, double x, int n) {
double resultado = 0;
double factorial = 1;
double potencia = 1;

for (int i = 0; i <= n; i++) {
if (i > 0) {
factorial *= i; // Calcula i!
potencia *= (x - a); // Calcula (x - a)^i
}
resultado += (derivative(i, a) * potencia) / factorial;
}

return resultado;
}

public static void main(String[] args) {
double a = 0; // Punto alrededor del cual se expande
double x = 1; // Valor en el que se evalúa la función
int n = 10; // Número de términos en la serie

double resultado = taylorSeries(a, x, n);
System.out.println("Aproximación de Taylor: " + resultado);
}
}
    
    
    
    
    
    
    
    
    

