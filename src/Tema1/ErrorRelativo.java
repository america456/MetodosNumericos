/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema1;

/**
 *
 * @author hamer
 */
public class ErrorRelativo {
    public static void main(String[] args) {
        double[] reales = {10.0, 25.0, 50.0, 100.0, 200.0};
        double[] aprox = {9.5, 24.8, 49.9, 99.0, 201.0};
        
        System.out.println("ERROR RELATIVO");
        System.out.println("Real\tAprox\tError Relativo");
        for(int i = 0; i < reales.length; i++) {
            double error = Math.abs((reales[i] - aprox[i]) / reales[i]);
            System.out.printf("%.1f\t%.1f\t%.6f%n", reales[i], aprox[i], error);
        }
    }
}
