Tema 5: Interpolación y Ajuste de Funciones
----------------
Introducción
----------------
La interpolación y el ajuste de funciones son técnicas fundamentales en métodos numéricos para estimar valores intermedios entre datos conocidos y modelar relaciones entre variables. Este tema cubre métodos para construir funciones que pasen exactamente por puntos dados (interpolación) o que aproximen conjuntos de datos con posible ruido experimental (ajuste).
----------------
Métodos de Interpolación Lineal
----------------

Conecta dos puntos adyacentes con una línea recta. Es el método más simple de interpolación.
----------------
Fórmula:
----------------
f(x) ≈ y₀ + (y₁ - y₀)/(x₁ - x₀) * (x - x₀)
donde (x₀,y₀) y (x₁,y₁) son los puntos conocidos adyacentes a x.
----------------
Pseudocódigo:
----------------
```
def interpolacion_lineal(x, x0, y0, x1, y1):
    return y0 + (y1 - y0)/(x1 - x0) * (x - x0)
    ```
Interpolación Polinómica 
----------------

Encuentra un polinomio único de grado n-1 que pasa exactamente por n puntos.
----------------
Fórmula 
----------------
P(x) = Σ [yᵢ * Lᵢ(x)]
donde Lᵢ(x) = Π (x - xⱼ)/(xᵢ - xⱼ) para j ≠ i
----------------
Pseudocódigo:
```
def lagrange(x, puntos):
    n = len(puntos)
    resultado = 0.0
    for i in range(n):
        xi, yi = puntos[i]
        term = yi
        for j in range(n):
            if j != i:
                xj = puntos[j][0]
                term *= (x - xj)/(xi - xj)
        resultado += term
    return resultado
    
    ```
----------------
Método de Correlación
----------------
Mide la fuerza y dirección de la relación lineal entre dos variables mediante el coeficiente de correlación de Pearson.
----------------
Fórmula :
----------------
r = Σ[(xᵢ - x̄)(yᵢ - ȳ)] / [√Σ(xᵢ - x̄)² * √Σ(yᵢ - ȳ)²]
----------------
Pseudocódigo:
```
def correlacion(x, y):
    n = len(x)
    media_x = sum(x)/n
    media_y = sum(y)/n
    
    numerador = sum((xi - media_x)*(yi - media_y) for xi, yi in zip(x,y))
    denominador_x = sum((xi - media_x)**2 for xi in x)
    denominador_y = sum((yi - media_y)**2 for yi in y)
    
    return numerador / (denominador_x * denominador_y)**0.5
    ```
----------------
Método de Regresión Lineal
----------------
Encuentra la línea recta que mejor ajusta un conjunto de puntos minimizando la suma de los cuadrados de los residuos.
----------------
Fórmulas (Recta y = a + bx):
----------------
b = [nΣ(xy) - ΣxΣy] / [nΣx² - (Σx)²]
a = ȳ - b*x̄
----------------
Pseudocódigo:
```
def regresion_lineal(x, y):
    n = len(x)
    sum_x = sum(x)
    sum_y = sum(y)
    sum_xy = sum(xi*yi for xi,yi in zip(x,y))
    sum_x2 = sum(xi**2 for xi in x)
    
    b = (n*sum_xy - sum_x*sum_y) / (n*sum_x2 - sum_x**2)
    a = (sum_y - b*sum_x)/n
    
    return a, b  # Devuelve los coeficientes a y b
```
----------------
  Método de Mínimos Cuadrados 
----------------

Ajusta cualquier modelo lineal en sus parámetros minimizando la suma de los cuadrados de las diferencias entre los datos observados y los predichos.
----------------
Formulación Matricial:

Si y ≈ Xβ, entonces β = (XᵀX)⁻¹Xᵀy
donde X es la matriz de diseño y β el vector de parámetros.
----------------
Pseudocódigo:
----------------
```
import numpy as np

def minimos_cuadrados(x, y, grado):
    # Construir matriz de Vandermonde
    X = np.vander(x, grado+1)
    
    # Resolver sistema normal XᵀXβ = Xᵀy
    XT = X.T
    beta = np.linalg.solve(XT @ X, XT @ y)
    
    return beta[::-1]  # Coeficientes de mayor a menor grado

```
----------------
