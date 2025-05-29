/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema1;

/**
 *
 * @author hamer
 */
public class ErrorTruncamiento {
    
    public static void main(String[] args) {
        double valorReal = Math.PI;
        double valorTruncado = 3.1415;
        double error = Math.abs(valorReal - valorTruncado);
        
        System.out.println("ERROR DE TRUNCAMIENTO");
        System.out.printf("Valor real (π): %.10f%n", valorReal);
        System.out.printf("Valor truncado: %.4f%n", valorTruncado);
        System.out.printf("Error: %.10f%n", error);
    }
}

