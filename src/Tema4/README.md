Tema 4: Diferenciación e Integración Numérica
------------------------
Introducción
------------------------
La integración y diferenciación numérica son herramientas fundamentales en métodos numéricos cuando las soluciones analíticas son difíciles o imposibles de obtener. Este tema cubre los principales métodos para aproximar integrales definidas, esenciales en aplicaciones de ingeniería, física y ciencias computacionales donde se requiere calcular áreas bajo curvas, valores promedio o resolver ecuaciones diferenciales.
------------------------
Método del Trapecio
------------------------
Aproxima el área bajo la curva dividiéndola en trapecios. Es la regla más simple de integración numérica, exacta para polinomios de grado 1 o menor.
------------------------
Fórmula:
------------------------
`∫[a,b] f(x) dx ≈ (b-a)/2 * [f(a) + f(b)]

h = (b-a)/n
Resultado = h/2 * [f(x₀) + 2Σf(xᵢ) + f(xₙ)]`

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
------------------------
Método de Simpson 1/3
------------------------
Aproxima el área usando parábolas (polinomios de segundo grado). Exacto para polinomios hasta grado 3.
------------------------
Fórmula:
------------------------
`∫[a,b] f(x) dx ≈ (b-a)/6 * [f(a) + 4f((a+b)/2) + f(b)]


h = (b-a)/n
Resultado = h/3 * [f(x₀) + 4Σf(x_impares) + 2Σf(x_pares) + f(xₙ)]`

------------------------
Pseudocódigo:
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
Método de Simpson 3/8
------------------------
Usa polinomios cúbicos (grado 3) para aproximación. Exacto para polinomios hasta grado 3. Requiere número de segmentos múltiplo de 3.
------------------------
Fórmula (simple):

`∫[a,b] f(x) dx ≈ (b-a)/8 * [f(a) + 3f((2a+b)/3) + 3f((a+2b)/3) + f(b)]


h = (b-a)/n
Resultado = 3h/8 * [f(x₀) + 3Σ(f(x₁)+f(x₂)) + 2Σf(x₃) + ... + f(xₙ)]`

------------------------
Pseudocódigo:
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
------------------------
Cuadratura Gaussiana
------------------------

Método avanzado que selecciona puntos de evaluación óptimos (no equidistantes) y pesos para maximizar precisión. Exacto para polinomios hasta grado 2n-1 con n puntos.
------------------------
Fórmula :
------------------------
`∫[-1,1] f(x) dx ≈ f(-1/√3) + f(1/√3)


x = (b-a)/2 * t + (a+b)/2
dx = (b-a)/2 * dt`

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
Versión general (n puntos):

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
