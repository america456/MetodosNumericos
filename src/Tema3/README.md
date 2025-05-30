Tema 3: Solución de Sistemas de Ecuaciones Lineales
-------------------------
Introducción 
-------------------------
En el ámbito de los métodos numéricos, la solución de sistemas de ecuaciones lineales es un problema fundamental con aplicaciones en ingeniería, física computacional, economía y otras disciplinas científicas. Este tema aborda técnicas tanto directas como iterativas para resolver sistemas de la forma Ax = b, donde A es una matriz de coeficientes, x el vector de incógnitas y b el vector de términos independientes.

-------------------------
Metodo de Eliminación Gaussiana
-------------------------
Transforma la matriz a forma triangular superior mediante operaciones fila.

-------------------------
Pseudocódigo:
-------------------------
```
def gaussiana(A, b):
    n = len(A)
    # Eliminación hacia adelante
    for i in range(n):
        for j in range(i+1, n):
            factor = A[j][i]/A[i][i]
            for k in range(i, n):
                A[j][k] -= factor * A[i][k]
            b[j] -= factor * b[i]
    # Sustitución hacia atrás
    x = [0]*n
    for i in range(n-1, -1, -1):
        x[i] = b[i]
        for j in range(i+1, n):
            x[i] -= A[i][j] * x[j]
        x[i] /= A[i][i]
    return x
```
------------------------
[Programa Metodo de Eliminacion Gaussiana](https://github.com/america456/MetodosNumericos/blob/bc6f02c295b0635d6b377fb8d582a2f1ccfa7a37/src/Tema3/MetodoEliminacionGaussiana.java
)  
-------------------------
Metodo de Gauss-Jordan
-------------------------
Extensión de Gaussiana que obtiene la matriz identidad.

-------------------------
Pseudocódigo:
-------------------------
```
def gauss_jordan(A, b):
    n = len(A)
    # Matriz aumentada
    M = [A[i] + [b[i]] for i in range(n)]
    # Reducción
    for i in range(n):
        # Normalizar fila i
        pivot = M[i][i]
        for j in range(i, n+1):
            M[i][j] /= pivot
        # Eliminar en otras filas
        for k in range(n):
            if k != i:
                factor = M[k][i]
                for j in range(i, n+1):
                    M[k][j] -= factor * M[i][j]
    return [row[n] for row in M]
```
-------------------------
[Programa Metodo Gauss-Jordan](https://github.com/america456/MetodosNumericos/blob/bc6f02c295b0635d6b377fb8d582a2f1ccfa7a37/src/Tema3/MetodoGaussJordan.java)
-------------------------
Metodo de Gauss-Seidel
-------------------------
Método iterativo que usa valores actualizados inmediatamente.

-------------------------
Pseudocódigo:
-------------------------
```
def gauss_seidel(A, b, tol, max_iter):
    n = len(A)
    x = [0]*n
    for _ in range(max_iter):
        x_old = x.copy()
        for i in range(n):
            sum1 = sum(A[i][j] * x[j] for j in range(i))
            sum2 = sum(A[i][j] * x_old[j] for j in range(i+1, n))
            x[i] = (b[i] - sum1 - sum2) / A[i][i]
        if all(abs(x[i]-x_old[i]) < tol for i in range(n)):
            break
    return x
```
-------------------------
[Programa Metodo de Gauss-Seidel](https://github.com/america456/MetodosNumericos/blob/bc6f02c295b0635d6b377fb8d582a2f1ccfa7a37/src/Tema3/MetodoGaussSeidel.java
)
-------------------------
Metodo Jacobi
-------------------------
Método iterativo que usa valores de la iteración anterior.

-------------------------
Pseudocódigo:
-------------------------
```
def jacobi(A, b, tol, max_iter):
    n = len(A)
    x = [0]*n
    x_new = [0]*n
    for _ in range(max_iter):
        for i in range(n):
            suma = sum(A[i][j] * x[j] for j in range(n) if j != i)
            x_new[i] = (b[i] - suma) / A[i][i]
        if all(abs(x_new[i]-x[i]) < tol for i in range(n)):
            break
        x = x_new.copy()
    return x
```
-------------------------
[Programa Metodo Jacobi](https://github.com/america456/MetodosNumericos/blob/bc6f02c295b0635d6b377fb8d582a2f1ccfa7a37/src/Tema3/MetodoJacobi.java)
-------------------------
