# Calculadora cientifica orientada a objetos en kotlin

## descripcion general
La aplicacion implementa una **calculadora cientifica** disenada con los principios de **Programacion Orientada a Objetos (POO)** en Kotlin.  
Permite realizar operaciones aritmeticas basicas y avanzadas (trigonometria, logaritmos, potencias, raices, exponenciales, y conversion entre grados y radianes), manejando errores comunes y ofreciendo una interfaz de consola amigable para el usuario.

---

## principios de programacion orientada a objetos aplicados

### Encapsulamiento
Cada operacion y variable interna se encuentra **protegida dentro de su clase**.  
La clase `Calculadora` contiene los metodos basicos (`sumar`, `restar`, `multiplicar`, `dividir`) y maneja excepciones como la **division por cero**.  
El atributo `memoria` es privado y solo puede modificarse mediante los metodos publicos `M+`, `M-`, `MR` y `MC`.

Esto asegura que el usuario no acceda directamente a los datos internos de la calculadora.

---

### Herencia
La clase `CalculadoraCientifica` **hereda** de `Calculadora` y amplia sus funcionalidades con metodos especializados:
- Funciones trigonometricas (`sin`, `cos`, `tan`, `sinDeg`, `cosDeg`, `tanDeg`)
- Potencias y raices (`potencia`, `raiz`)
- Logaritmos (`log10`, `ln`)
- Funciones exponenciales (`exp`)
- Conversion de unidades (`gradosARadianes`, `radianesAGrados`)

Esto demuestra la **reutilizacion de codigo** y la **extension de clases base**, uno de los pilares de la herencia en POO.

---

### Polimorfismo
El programa utiliza **sobrecarga de metodos** (por ejemplo, para operaciones con distintos tipos de datos `Int` y `Double`) y un metodo `evaluarExpresion()` que **interpreta dinamicamente** los diferentes tipos de funciones y operadores segun el texto ingresado por el usuario.

Esto permite que una misma funcion (por ejemplo, `sumar`) pueda operar sobre diferentes tipos de datos sin necesidad de escribir multiples versiones.

---

## manejo de excepciones
El sistema captura y maneja errores comunes:
- Division por cero (`ArithmeticException`)
- Entrada no valida o mal formada (`IllegalArgumentException`)
- Errores matematicos (por ejemplo, raiz de numero negativo o logaritmo de numero no positivo)

Cada excepcion se comunica al usuario con mensajes claros, sin interrumpir la ejecucion del programa.

---

## interaccion con el usuario
El programa ofrece una **interfaz de consola interactiva**, donde el usuario puede escribir operaciones directamente:

---
## Conclusiones
- Este proyecto demuestra como el paradigma orientado a objetos permite construir una aplicacion modular, escalable y facil de mantener. 
- El encapsulamiento protege los datos, la herencia facilita la extension de funcionalidades y el polimorfismo aporta flexibilidad en el manejo de distintos tipos de datos.  
- La aplicacion final ofrece una interfaz amigable, robusta y precisa, cumpliendo con los requisitos de una calculadora cientifica moderna.
