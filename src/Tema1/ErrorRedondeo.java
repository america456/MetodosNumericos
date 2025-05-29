/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema1;

/**
 *
 * @author hamer
 */
public class ErrorRedondeo {
   
    public static void main(String[] args) {
        // Ejemplo con diferentes niveles de redondeo
        double valorExacto = 1.23456789;
        int[] decimales = {1, 2, 3, 4};
        
        System.out.println("ANÁLISIS DE ERROR POR REDONDEO");
        System.out.println("Valor exacto: " + valorExacto);
        System.out.println("----------------------------------");
        System.out.printf("%-15s %-15s %-15s%n", "Decimales", "Valor Redondeado", "Error");
        
        for(int dec : decimales) {
            double redondeado = redondear(valorExacto, dec);
            double error = Math.abs(valorExacto - redondeado);
            System.out.printf("%-15d %-15.8f %-15.8f%n", dec, redondeado, error);
        }
        
        // Caso especial: redondeo en operaciones financieras
        System.out.println("\nEjemplo financiero:");
        double monto = 1234.5678;
        double redondeoFinanciero = redondear(monto, 2);
        System.out.printf("Monto original: %.4f%n", monto);
        System.out.printf("Redondeo a 2 decimales: %.2f%n", redondeoFinanciero);
        System.out.printf("Error: %.4f%n", Math.abs(monto - redondeoFinanciero));
    }
    
    public static double redondear(double valor, int decimales) {
        double factor = Math.pow(10, decimales);
        return Math.round(valor * factor) / factor;
    }
}
