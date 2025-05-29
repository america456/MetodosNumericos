/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema5;

/**
 *
 * @author hamer
 */
public class MetodoCorrelacion {
    

public static void main(String[] args) {
// Señal de referencia (patrón)
double[] x = {1, 2, 3, 4, 5};
// Señal desplazada con ruido (señal a comparar)
double[] y = {0, 0, 1, 2, 3, 4, 5, 0};
// Calculamos la correlación cruzada
double[] correlacion = correlacionCruzada(x, y);
// Mostramos los resultados
System.out.println("Resultados de la correlación cruzada:");
for (int k = 0; k < correlacion.length; k++) {
System.out.printf("Lag %d: %.2f%n", k - (x.length - 1),

correlacion[k]);
}
// Encontrar el lag con máxima correlación
int maxLag = encontrarMaximoLag(correlacion) - (x.length - 1);
System.out.println("\nEl desplazamiento óptimo es: Lag " + maxLag);
}
// Método para calcular la correlación cruzada
public static double[] correlacionCruzada(double[] x, double[] y) {
int n = x.length;
int m = y.length;
double[] resultado = new double[n + m - 1];
for (int k = 0; k < resultado.length; k++) {
double suma = 0.0;
for (int i = 0; i < n; i++) {
int j = k + i - (n - 1);
if (j >= 0 && j < m) {
suma += x[i] * y[j];

}
}
resultado[k] = suma;
}
return resultado;
}

// Método para encontrar el lag con máxima correlación
public static int encontrarMaximoLag(double[] correlacion) {
int maxIndex = 0;
double maxValor = correlacion[0];
for (int i = 1; i < correlacion.length; i++) {
if (correlacion[i] > maxValor) {
maxValor = correlacion[i];
maxIndex = i;
}
}
return maxIndex;
}

}
    
    
    
    
    
    
    
    
    
    
    

