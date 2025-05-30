--------------------------
Tema 6: Solución de Ecuaciones Diferenciales
--------------------------
Introducción
--------------------------

La solución numérica de ecuaciones diferenciales es fundamental en la modelización de sistemas físicos, biológicos y de ingeniería. Este tema cubre métodos para aproximar soluciones de ecuaciones diferenciales ordinarias (EDOs) cuando no se pueden obtener soluciones analíticas exactas. Los métodos se dividen en métodos de un paso (como Euler y Runge-Kutta) y métodos multipaso.

--------------------------
Método de Euler
--------------------------

El método más simple para resolver EDOs, aproxima la solución mediante una serie de segmentos lineales usando la pendiente en el punto actual.

--------------------------
Fórmula:
--------------------------

`y_{n+1} = y_n + h*f(t_n, y_n)
donde h es el tamaño de paso y f(t,y) es la EDO dy/dt = f(t,y).`

---------------------------
Pseudocódigo:
---------------------------
```
def euler(f, t0, y0, h, n_steps):
    t = t0
    y = y0
    solution = [(t, y)]
    for _ in range(n_steps):
        y += h * f(t, y)
        t += h
        solution.append((t, y))
    return solution
```
--------------------------
Método de Taylor
-------------------------

Extensión del método de Euler que usa términos de orden superior en la expansión de Taylor para mayor precisión.

-------------------------
Fórmula:
------------------------

`y_{n+1} = y_n + h*f(t_n, y_n) + (h²/2)*f'(t_n, y_n)`

------------------------
Pseudocódigo :
-----------------------
```
def taylor_orden2(f, df, t0, y0, h, n_steps):
    t = t0
    y = y0
    solution = [(t, y)]
    for _ in range(n_steps):
        y += h * f(t, y) + (h**2)/2 * df(t, y)
        t += h
        solution.append((t, y))
    return solution
```
-----------------------
Métodos de Runge-Kutta
----------------------

Familia de métodos que evalúan la función en varios puntos dentro del intervalo para obtener mayor precisión sin necesidad de derivadas.

-----------------------
Fórmula :
-----------------------

`k1 = h*f(t_n, y_n)
k2 = h*f(t_n + h/2, y_n + k1/2)
k3 = h*f(t_n + h/2, y_n + k2/2)
k4 = h*f(t_n + h, y_n + k3)
y_{n+1} = y_n + (k1 + 2k2 + 2k3 + k4)/6`

-----------------------
Pseudocódigo (RK4):
---------------------
```
def runge_kutta4(f, t0, y0, h, n_steps):
    t = t0
    y = y0
    solution = [(t, y)]
    for _ in range(n_steps):
        k1 = h * f(t, y)
        k2 = h * f(t + h/2, y + k1/2)
        k3 = h * f(t + h/2, y + k2/2)
        k4 = h * f(t + h, y + k3)
        y += (k1 + 2*k2 + 2*k3 + k4) / 6
        t += h
        solution.append((t, y))
    return solution
```
--------------------
Métodos Multipaso
--------------------

Usan información de varios pasos anteriores para calcular la solución actual, mejorando la eficiencia pero requiriendo valores iniciales.

-------------------
Fórmula :
--------------------

`y_{n+1} = y_n + h/2 * [3f(t_n, y_n) - f(t_{n-1}, y_{n-1})]`

----------------------
Pseudocódigo:
```
def adams_bashforth2(f, t0, t1, y0, y1, h, n_steps):
    t = [t0, t1]
    y = [y0, y1]
    solution = list(zip(t, y))
    for _ in range(2, n_steps+2):
        next_y = y[-1] + h/2 * (3*f(t[-1], y[-1]) - f(t[-2], y[-2]))
        next_t = t[-1] + h
        y.append(next_y)
        t.append(next_t)
        solution.append((next_t, next_y))
    return solution
```
----------------------
Método de Pasos Múltiples 
----------------------

Combina un método explícito (predictor) con uno implícito (corrector) para mejorar la precisión.

-----------------------
Fórmula:
-----------------------

`Predictor: y_{n+1}^0 = y_n + h*f(t_n, y_n)
Corrector: y_{n+1}^{k+1} = y_n + h/2 * [f(t_n, y_n) + f(t_{n+1}, y_{n+1}^k)]`

----------------------
Pseudocódigo:
```
def predictor_corrector(f, t0, y0, h, n_steps, max_iter=10, tol=1e-6):
    t = t0
    y = y0
    solution = [(t, y)]
    for _ in range(n_steps):
        # Paso predictor (Euler)
        y_pred = y + h * f(t, y)
        t_new = t + h
        
        # Paso corrector (Trapecio)
        for __ in range(max_iter):
            y_corr = y + h/2 * (f(t, y) + f(t_new, y_pred))
            if abs(y_corr - y_pred) < tol:
                break
            y_pred = y_corr
        
        y = y_corr
        t = t_new
        solution.append((t, y))
    return solution
```
-----------------------
