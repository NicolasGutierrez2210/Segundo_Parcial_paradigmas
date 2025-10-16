#  Calculadora Basada en el Paradigma de Agentes 

## 1. Descripcion del proyecto
Este ejercicio implementa una **calculadora distribuida basada en agentes** utilizando el framework **Mesa ** en Python.  
Cada agente es responsable de una operacion aritmetica especifica (suma, resta, multiplicacion, division o potencia), y los agentes se comunican entre si para resolver expresiones matematicas complejas respetando la precedencia de operadores.

---

## 2. Arquitectura del sistema

El sistema se compone de tres tipos principales de agentes:

- **Agente IO (Entrada/Salida):**  
  Recibe las expresiones escritas por el usuario y las distribuye al resto de agentes. Presenta los resultados finales al finalizar cada evaluacion.

- **Agente SumaResta:**  
  Se encarga de procesar operaciones de **suma y resta**.  
  Cuando recibe una expresion, solicita los operandos, los evalua (posiblemente comunicandose con otros agentes) y calcula el resultado parcial.

- **Agente MulDiv:**  
  Gestiona las operaciones de **multiplicacion, division y potencia**.  
  Tambien maneja errores como division por cero.

El modelo principal (`EvaluadorModelo`) coordina la ejecucion de los agentes y maneja el flujo de mensajes entre ellos.

---

## 3. Mecanismo de comunicacion

Los agentes se comunican enviando **mensajes** con la estructura:
```python
{"expr": <nodo_ast>, "from": "IO", "to": "SUM" or "MUL"}
****
```

