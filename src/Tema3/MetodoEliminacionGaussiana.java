/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema3;

/**
 *
 * @author hamer
 */
public class MetodoEliminacionGaussiana {

public static int N = 3;
static void gaussianElimination(double mat[][]) {
int singular_flag = forwardElim(mat);
if (singular_flag != -1) {
System.out.println("Matriz singular. Puede tener infinitas soluciones o ser inconsistente.");

return;
}
backSub(mat);
}
static void swap_row(double mat[][], int i, int j) {
for (int k = 0; k <= N; k++) {
double temp = mat[i][k];
mat[i][k] = mat[j][k];
mat[j][k] = temp;
}
}
static void print(double mat[][]) {
for (int i = 0; i < N; i++, System.out.println())
for (int j = 0; j <= N; j++)
System.out.print(mat[i][j] + " ");

System.out.println();


}
static int forwardElim(double mat[][]) {
for (int k = 0; k < N; k++) {
int i_max = k;
double v_max = mat[i_max][k];
for (int i = k + 1; i < N; i++)
if (Math.abs(mat[i][k]) > v_max) {
v_max = Math.abs(mat[i][k]);
i_max = i;
}
if (mat[k][i_max] == 0)
return k;
if (i_max != k)
swap_row(mat, k, i_max);
for (int i = k + 1; i < N; i++) {
double f = mat[i][k] / mat[k][k];

for (int j = k + 1; j <= N; j++)
mat[i][j] -= mat[k][j] * f;
mat[i][k] = 0;
}
}
return -1;
}
static void backSub(double mat[][]) {
double x[] = new double[N];
for (int i = N - 1; i >= 0; i--) {
x[i] = mat[i][N];
for (int j = i + 1; j < N; j++) {
x[i] -= mat[i][j] * x[j];
}
x[i] = x[i] / mat[i][i];
}
System.out.println();
System.out.println("Solucion del sistema:");
for (int i = 0; i < N; i++) {
// Cambiado a 3 decimales:
System.out.format("x[%d] = %.3f\n", i, x[i]);
}
}
public static void main(String[] args) {
double mat[][] = {
{ 2.0, 3.0, -1.0, 5.0 }, // 2x + 3y - z = 5
{ 4.0, 2.0, 3.0, 12.0 }, // 4x + 2y + 3z = 12
{ 3.0, -1.0, 2.0, 6.0 } // 3x - y + 2z = 6
};
gaussianElimination(mat);
}
}
    

