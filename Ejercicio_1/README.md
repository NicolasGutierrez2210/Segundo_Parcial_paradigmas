#  Simulacion del Perceptron


---

##  Descripcion General

Este proyecto implementa un **perceptrón simple** como un **modelo multiagente**.  
Cada agente representa un **punto (x, y)** dentro de una cuadricula, el cual tiene una **etiqueta (label)** que indica su clase.  
El perceptron aprende a clasificar los puntos mediante **ajuste iterativo de pesos (w₁, w₂)** y un **sesgo (bias)**.

Durante la simulacion, los puntos se colorean:
- 🟢 **Verde** → Clasificado correctamente.  
- 🔴 **Rojo** → Clasificado incorrectamente.
---
##  Diseño Matematico del Perceptron

El perceptron ajusta sus pesos segun el error de clasificacion de cada punto.  
La funcion de activacion es la funcion escalon:

El aprendizaje se realiza con la siguiente regla de actualizacion:

$w_i = w_i + \eta \cdot error \cdot x_i$

$b = b + \eta \cdot error$

donde:
- $\eta$ es la tasa de aprendizaje (learning rate)
- $error = (label - output)$
---

## Tecnologias y Librerias Utilizadas

- **Python 3.11+**
- **Mesa 2.1.1** (simulacion multiagente)
- **Tornado** (servidor web incluido en Mesa)
- **Random** (para generación de datos aleatorios)

---

##  Estructura del Proyecto


- percep_modelo.py 
- percep_vista.py 
- run_vista.py 
- README.md
- puntos 1 y 2(imagenes)



---

##  Funcionamiento del Modelo

### Inicializacion
- Se generan **N puntos aleatorios** en una cuadricula de 20x20.
- Cada punto tiene:
  - Una posición `(x, y)`
  - Una etiqueta `label` → 1 si `y > x`, de lo contrario 0.
- Se inicializan los **pesos w₁, w₂** y **bias** de forma aleatoria.

###  Dinamica de los agentes
Cada agente (punto) calcula la salida del perceptrón:
```python
suma = w1*x + w2*y + bias
output = 1 if suma >= 0 else 0
```
---
## Capturas de pantalla
- Encontrar en puntos 1 y 2
---
## Como ejecutar
1. Descarga todos los archivos . py y ponlos en una carpeta.
2. Abre la terminal y escribe:  python agentecalculadora.py
3. Prueba el simulador en la pagina que te abre (Los parametros los puedes cambiar en el codigo).


---
## Conclusiones

- La simulacion demuestra como el perceptron aprende de errores y ajusta sus parametros mediante retroalimentacion local.

- El uso de Mesa permite visualizar el proceso de aprendizaje de forma interactiva y didactica.

- El modelo cumple con el principio del aprendizaje supervisado, mostrando convergencia en un problema linealmente separable.
