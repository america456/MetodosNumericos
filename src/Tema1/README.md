------------------------------
Tema 1: Análisis de Errores
------------------------------
------------------------------
Introducción General
------------------------------

En el análisis numérico, los errores son inherentes a los procesos de cálculo y aproximación. Comprender los diferentes tipos de errores es fundamental para evaluar la precisión y confiabilidad de los resultados obtenidos mediante métodos numéricos. Este documento presenta los principales tipos de errores que afectan los cálculos numéricos, sus características fundamentales y cómo cuantificarlos.

------------------------------
Tipos de Errores Numéricos
------------------------------
------------------------------
Error Absoluto
------------------------------
Representa la diferencia directa entre el valor real (Vr) y el valor aproximado (Va).

------------------------------
Fórmula: 
------------------------------
`E_abs = |Vr - Va|`

------------------------------
Pseudocódigo:
------------------------------
```
def error_absoluto(Vr, Va):
    return abs(Vr - Va)
```
------------------------------
Error Relativo
------------------------------
Expresa el error absoluto en relación con la magnitud del valor real.

------------------------------
Fórmula:
------------------------------
`E_rel = |Vr - Va| / |Vr|`

------------------------------
Pseudocódigo:
------------------------------
```
def error_relativo(Vr, Va):
    if Vr == 0:
        return 0  # Evita división por cero
    return abs(Vr - Va) / abs(Vr)
```
------------------------------
 Error de Redondeo
------------------------------

Ocurre al representar números con una cantidad limitada de dígitos significativos.

------------------------------
Fórmula:
------------------------------
`E_redondeo = |Valor exacto - Valor redondeado|`

------------------------------
Pseudocódigo:
------------------------------
```
def error_redondeo(exacto, decimales):
    redondeado = round(exacto, decimales)
    return abs(exacto - redondeado)
```
------------------------------
Error de Truncamiento
------------------------------

Resultado de aproximar un procedimiento matemático infinito por uno finito.

------------------------------
Fórmula:
------------------------------
`E_trunc = |Valor exacto - Valor truncado|`

------------------------------

Pseudocódigo:
------------------------------
```
def error_truncamiento(exacto, terminos):
    aproximado = sumar_serie(exacto, terminos)  # Función hipotética
    return abs(exacto - aproximado)
```
------------------------------
Error de Formulación
------------------------------
Concepto:
Surge al simplificar un modelo matemático del problema real.
------------------------------
Fórmula:
------------------------------
`E_modelo = |Valor real - Valor del modelo|`

------------------------------

Pseudocódigo:
------------------------------
```
def error_modelo(real, modelo):
    return abs(real - modelo)
```
------------------------------
Error Significativo
------------------------------

Pérdida de precisión debido al uso de un número insuficiente de dígitos significativos.

------------------------------

Pseudocódigo:
------------------------------
```
def digitos_significativos(num):
    cadena = str(num).replace('.','').lstrip('0')
    return len(cadena) if cadena else 0
```
------------------------------
