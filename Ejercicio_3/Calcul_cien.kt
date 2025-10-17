import kotlin.math.*

open class Calculadora {
    fun sumar(a: Double, b: Double): Double = a + b
    fun restar(a: Double, b: Double): Double = a - b
    fun multiplicar(a: Double, b: Double): Double = a * b
    fun dividir(a: Double, b: Double): Double {
        if (b == 0.0) throw ArithmeticException("Error: división por cero")
        return a / b
    }
}

class CalculadoraCientifica : Calculadora() {
    private var memoria = 0.0

    // --- Funciones científicas ---
    fun sin(rad: Double): Double = kotlin.math.sin(rad)
    fun cos(rad: Double): Double = kotlin.math.cos(rad)
    fun tan(rad: Double): Double = kotlin.math.tan(rad)
    fun sinDeg(grados: Double): Double = sin(Math.toRadians(grados))
    fun cosDeg(grados: Double): Double = cos(Math.toRadians(grados))
    fun tanDeg(grados: Double): Double = tan(Math.toRadians(grados))
    fun potencia(base: Double, exponente: Double): Double = base.pow(exponente)
    fun raiz(base: Double, indice: Double): Double = base.pow(1.0 / indice)
    fun log10(num: Double): Double = kotlin.math.log10(num)
    fun ln(num: Double): Double = kotlin.math.ln(num)
    fun exp(num: Double): Double = kotlin.math.exp(num)

    // --- Funciones de memoria ---
    fun mMas(valor: Double) { memoria += valor }
    fun mMenos(valor: Double) { memoria -= valor }
    fun mr(): Double = memoria
    fun mc() { memoria = 0.0 }
}

fun main() {
    val calc = CalculadoraCientifica()
    println("=== CALCULADORA CIENTÍFICA ===")
    println("Operaciones disponibles:")
    println("+, -, *, /, sin(x), cos(x), tan(x), sinDeg(x), cosDeg(x), tanDeg(x),")
    println("potencia(a,b), raiz(a,b), log10(x), ln(x), exp(x)")
    println("Funciones de memoria: M+, M-, MR, MC")
    println("Escriba 'salir' para terminar.\n")

    while (true) {
        print("Ingrese una operación: ")
        val entrada = readLine() ?: break
        if (entrada.lowercase() == "salir") break

        try {
            when {
                entrada.startsWith("M+") -> {
                    val valor = entrada.substring(2).trim().toDouble()
                    calc.mMas(valor)
                    println("Valor agregado a memoria.")
                }
                entrada.startsWith("M-") -> {
                    val valor = entrada.substring(2).trim().toDouble()
                    calc.mMenos(valor)
                    println("Valor restado de memoria.")
                }
                entrada.equals("MR", true) -> println("Memoria actual: ${calc.mr()}")
                entrada.equals("MC", true) -> {
                    calc.mc()
                    println("Memoria borrada.")
                }
                entrada.contains("sin(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.sin(valor)}")
                }
                entrada.contains("sinDeg(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.sinDeg(valor)}")
                }
                entrada.contains("cosDeg(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.cosDeg(valor)}")
                }
                entrada.contains("tanDeg(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.tanDeg(valor)}")
                }
                entrada.contains("cos(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.cos(valor)}")
                }
                entrada.contains("tan(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.tan(valor)}")
                }
                entrada.contains("potencia(") -> {
                    val params = entrada.substringAfter("(").substringBefore(")").split(",")
                    val a = params[0].toDouble()
                    val b = params[1].toDouble()
                    println("Resultado: ${calc.potencia(a, b)}")
                }
                entrada.contains("raiz(") -> {
                    val params = entrada.substringAfter("(").substringBefore(")").split(",")
                    val a = params[0].toDouble()
                    val b = params[1].toDouble()
                    println("Resultado: ${calc.raiz(a, b)}")
                }
                entrada.contains("log10(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.log10(valor)}")
                }
                entrada.contains("ln(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.ln(valor)}")
                }
                entrada.contains("exp(") -> {
                    val valor = entrada.substringAfter("(").substringBefore(")").toDouble()
                    println("Resultado: ${calc.exp(valor)}")
                }
                else -> {
                    val operadores = Regex("([+\\-*/])")
                    val partes = entrada.split(operadores).map { it.trim() }
                    if (partes.size == 2) {
                        val a = partes[0].toDouble()
                        val b = partes[1].toDouble()
                        val op = operadores.find(entrada)?.value
                        val resultado = when (op) {
                            "+" -> calc.sumar(a, b)
                            "-" -> calc.restar(a, b)
                            "*" -> calc.multiplicar(a, b)
                            "/" -> calc.dividir(a, b)
                            else -> throw Exception("Operador desconocido")
                        }
                        println("Resultado: $resultado")
                    } else {
                        println("Formato no reconocido. Ejemplo: 2 + 3")
                    }
                }
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
        println()
    }

    println("Gracias por usar la calculadora científica.")
}