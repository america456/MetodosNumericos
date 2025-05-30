Tema 4: Diferenciación e Integración Numérica
------------------------
Introducción:
------------------------

La integración y diferenciación numérica son herramientas fundamentales en métodos numéricos cuando las soluciones analíticas son difíciles o imposibles de obtener. Este tema cubre los principales métodos para aproximar integrales definidas, esenciales en aplicaciones de ingeniería, física y ciencias computacionales donde se requiere calcular áreas bajo curvas, valores promedio o resolver ecuaciones diferenciales.

------------------------
Método del Trapecio
------------------------

Aproxima el área bajo la curva dividiéndola en trapecios. Es la regla más simple de integración numérica, exacta para polinomios de grado 1 o menor.

------------------------
Fórmula:
------------------------

`∫[a,b] f(x) dx ≈ (b-a)/2 * [f(a) + f(b)]`

------------------------
Pseudocódigo:
------------------------
```
def trapecio(f, a, b, n):
    h = (b - a) / n
    suma = 0.5 * (f(a) + f(b))
    for i in range(1, n):
        suma += f(a + i * h)
    return h * suma
```
-----------------------
[Programa Metodo del Trapecio](https://github.com/america456/MetodosNumericos/blob/cd8219cfe03643af72466ce63ead757cfe3fb0b0/src/Tema4/MetodoTrapecio.java)
------------------------
Método de Simpson 1/3
------------------------

Aproxima el área usando parábolas (polinomios de segundo grado). Exacto para polinomios hasta grado 3.

------------------------
Fórmula:
------------------------
`∫[a,b] f(x) dx ≈ (b-a)/6 * [f(a) + 4f((a+b)/2) + f(b)]`

------------------------
Pseudocódigo:
-----------------------
```
def simpson_13(f, a, b, n):
    if n % 2 != 0:
        n += 1  # Asegurar n par
    h = (b - a) / n
    suma = f(a) + f(b)
    for i in range(1, n):
        if i % 2 == 1:
            suma += 4 * f(a + i * h)
        else:
            suma += 2 * f(a + i * h)
    return (h / 3) * suma
```
------------------------
[Programa de Metodo Simpson Un Tercio](https://github.com/america456/MetodosNumericos/blob/cd8219cfe03643af72466ce63ead757cfe3fb0b0/src/Tema4/SimpsonUnTercio.java)
------------------------
Método de Simpson 3/8
------------------------

Usa polinomios cúbicos (grado 3) para aproximación. Exacto para polinomios hasta grado 3. Requiere número de segmentos múltiplo de 3.

------------------------
Fórmula:
--------------------------
`∫[a,b] f(x) dx ≈ (b-a)/8 * [f(a) + 3f((2a+b)/3) + 3f((a+2b)/3) + f(b)]`

------------------------
Pseudocódigo:
-----------------------
```
def simpson_38(f, a, b, n):
    if n % 3 != 0:
        n += 3 - (n % 3)  # Ajustar a múltiplo de 3
    h = (b - a) / n
    suma = f(a) + f(b)
    for i in range(1, n):
        if i % 3 == 0:
            suma += 2 * f(a + i * h)
        else:
            suma += 3 * f(a + i * h)
    return (3 * h / 8) * suma
```
-----------------------
[Programa Metodo Simpson tres octavos](https://github.com/america456/MetodosNumericos/blob/cd8219cfe03643af72466ce63ead757cfe3fb0b0/src/Tema4/SimpsonTresOctavos.java)
------------------------
Cuadratura Gaussiana
------------------------

Método avanzado que selecciona puntos de evaluación óptimos (no equidistantes) y pesos para maximizar precisión. Exacto para polinomios hasta grado 2n-1 con n puntos.

------------------------
Fórmula :
------------------------
`∫[-1,1] f(x) dx ≈ f(-1/√3) + f(1/√3)`

------------------------
Pseudocódigo :
------------------------
```
def gauss_quad2(f, a, b):
    t1 = -1/(3**0.5)
    t2 = 1/(3**0.5)
    x1 = (b-a)/2 * t1 + (a+b)/2
    x2 = (b-a)/2 * t2 + (a+b)/2
    return (b-a)/2 * (f(x1) + f(x2))
# Usar pesos y nodos precalculados para n puntos
def gauss_quad(f, a, b, n):
    # Tabla de pesos y nodos para n=2,3,4,5...
    nodos, pesos = obtener_nodos_pesos(n)
    suma = 0
    for i in range(n):
        x = (b-a)/2 * nodos[i] + (a+b)/2
        suma += pesos[i] * f(x)
    return (b-a)/2 * suma
```
------------------------
[Programa Cuadratura Gaussiana](https://github.com/america456/MetodosNumericos/blob/cd8219cfe03643af72466ce63ead757cfe3fb0b0/src/Tema4/MetodoCuadraturaGaussiana.java)
------------------------
