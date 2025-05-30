Tema 2: Solución de Ecuaciones
-------------------------
Introducción General
-------------------------
Los métodos iterativos permiten encontrar raíces de ecuaciones no lineales mediante aproximaciones sucesivas. Cada método tiene diferentes características de convergencia y aplicabilidad.

-------------------------
Método de Bisección
-------------------------
Divide repetidamente el intervalo a la mitad hasta encontrar la raíz.

-------------------------
Fórmula:
-------------------------
`c = (a + b)/2`
-----------------------
Pseudocódigo:
-------------------------
```
def biseccion(f, a, b, tol):
    while (b-a) > tol:
        c = (a+b)/2
        if f(c) == 0: return c
        if f(a)*f(c) < 0: b = c
        else: a = c
    return (a+b)/2
```  
------------------------
[Programa Método de Bisección](https://github.com/america456/MetodosNumericos/blob/2517d7c55c90960bf4d1d731f10cd401af28713b/src/Tema2/MetodoBiseccion.java)
-------------------------
Método de Newton-Raphson
-------------------------

Usa derivadas para converger rápidamente a la raíz.

-------------------------
Fórmula :
-------------------------
`x_{n+1} = x_n - f(x_n)/f'(x_n)`
------------------------
Pseudocódigo:
-------------------------
```
def newton(f, df, x0, tol):
    while abs(f(x0)) > tol:
        x0 = x0 - f(x0)/df(x0)
    return x0
    
```
-------------------------
[Programa Metodo Newton-Raphson](https://github.com/america456/MetodosNumericos/blob/2517d7c55c90960bf4d1d731f10cd401af28713b/src/Tema2/NewtonRapshon.java)
-------------------------
Método de la Secante
-------------------------
Aproxima la derivada usando diferencias finitas.

-------------------------
Fórmula :
-------------------------
`x_{n+1} = x_n - f(x_n)[(x_n - x_{n-1})/(f(x_n) - f(x_{n-1}))]`
------------------------
Pseudocódigo:
-------------------------
```
def secante(f, x0, x1, tol):
    while abs(f(x1)) > tol:
        x2 = x1 - f(x1)*(x1-x0)/(f(x1)-f(x0))
        x0, x1 = x1, x2
    return x1
```
-------------------------
[Programa Método de la Secante](https://github.com/america456/MetodosNumericos/blob/2517d7c55c90960bf4d1d731f10cd401af28713b/src/Tema2/MetodoSecante.java)
-------------------------
Método de Punto Fijo
-------------------------
Transforma f(x)=0 en x=g(x) para iteraciones.

-------------------------
Fórmula:
------------------------
`x_{n+1} = g(x_n)`

-------------------------
Pseudocódigo:
-------------------------
```
def punto_fijo(g, x0, tol):
    while True:
        x1 = g(x0)
        if abs(x1-x0) < tol: return x1
        x0 = x1
```
-------------------------
[Programa Metodo de Punto Fijo](https://github.com/america456/MetodosNumericos/blob/2517d7c55c90960bf4d1d731f10cd401af28713b/src/Tema2/PuntoFijo.java)
-------------------------
Regla Falsa
-------------------------
Versión mejorada de bisección que usa interpolación lineal.

-------------------------
Fórmula:
------------------------
`c = [a·f(b) - b·f(a)] / [f(b) - f(a)]`
-------------------------
Pseudocódigo:
-------------------------
```
def regla_falsa(f, a, b, tol):
    while abs(b-a) > tol:
        c = (a*f(b)-b*f(a))/(f(b)-f(a))
        if f(c) == 0: return c
        if f(a)*f(c) < 0: b = c
        else: a = c
    return c
```
-------------------------
[Programa Regla Falsa](https://github.com/america456/MetodosNumericos/blob/2517d7c55c90960bf4d1d731f10cd401af28713b/src/Tema2/ReglaFalsa.java)
-------------------------
