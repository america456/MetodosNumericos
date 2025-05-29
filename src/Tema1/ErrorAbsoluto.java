/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema1;

/**
 *
 * @author hamer
 */
public class ErrorAbsoluto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
     
        // Valores reales y aproximados
        double[] reales = {10.0, 25.0, 50.0, 100.0, 200.0};
        double[] aprox = {9.5, 24.8, 49.9, 99.0, 201.0};
        
        // Calcular y mostrar error absoluto
        System.out.println("Cálculo de Error Absoluto");
        System.out.println("--------------------------");
        System.out.println("Real\tAproximado\tError Absoluto");
        
        for(int i = 0; i < reales.length; i++) {
            double error = Math.abs(reales[i] - aprox[i]);
            System.out.printf("%.1f\t%.1f\t\t%.2f%n", reales[i], aprox[i], error);
        }
    }
}
        
        
        
        
        
        
        
    
    

