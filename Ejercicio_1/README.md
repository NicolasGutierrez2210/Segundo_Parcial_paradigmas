#  Simulación del Perceptrón — Modelo Multiagente con Mesa


---

## 📘 Descripción General

Este proyecto implementa un **perceptrón simple** como un **modelo multiagente**.  
Cada agente representa un **punto (x, y)** dentro de una cuadricula, el cual tiene una **etiqueta (label)** que indica su clase.  
El perceptron aprende a clasificar los puntos mediante **ajuste iterativo de pesos (w₁, w₂)** y un **sesgo (bias)**.

Durante la simulación, los puntos se colorean:
- 🟢 **Verde** → Clasificado correctamente.  
- 🔴 **Rojo** → Clasificado incorrectamente.

El modelo muestra visualmente cómo el perceptron **ajusta su frontera de decisión** con el tiempo, intentando separar correctamente ambas clases.

---

## ⚙️ Tecnologías y Librerías Utilizadas

- **Python 3.11+**
- **Mesa 2.1.1** (simulación multiagente)
- **Tornado** (servidor web incluido en Mesa)
- **Random** (para generación de datos aleatorios)

---

##  Estructura del Proyecto

PerceptronAgentes/
│
├── percep_modelo.py # Lógica del modelo del perceptrón
├── percep_vista.py # Configuración visual con Mesa
├── run_vista.py # Archivo de ejecución principal
└── README.md # Informe / documentación del proyecto



---

##  Funcionamiento del Modelo

### Inicialización
- Se generan **N puntos aleatorios** en una cuadrícula de 20x20.
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
