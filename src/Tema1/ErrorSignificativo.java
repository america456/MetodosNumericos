/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema1;

/**
 *
 * @author hamer
 */
public class ErrorSignificativo {
     public static void main(String[] args) {
        // Ejemplo con diferentes niveles de precisión
        double valorReal = 1.23456789;
        double[] aproximaciones = {
            1.2,       // 2 dígitos significativos
            1.23,      // 3 dígitos significativos
            1.235,     // 4 dígitos significativos
            1.2346     // 5 dígitos significativos
        };
        
        System.out.println("ANÁLISIS DE ERROR SIGNIFICATIVO");
        System.out.println("Valor real: " + valorReal);
        System.out.println("----------------------------------");
        System.out.printf("%-15s %-15s %-15s%n", "Aproximación", "Dígitos Sig.", "Error Absoluto");
        
        for(double aprox : aproximaciones) {
            int digitos = contarDigitosSignificativos(aprox);
            double error = Math.abs(valorReal - aprox);
            System.out.printf("%-15.8f %-15d %-15.8f%n", aprox, digitos, error);
        }
    }
    
    public static int contarDigitosSignificativos(double numero) {
        String str = String.format("%.10f", numero).replaceAll("0*$", "").replace(".", "");
        return str.length();
    }
    
}
