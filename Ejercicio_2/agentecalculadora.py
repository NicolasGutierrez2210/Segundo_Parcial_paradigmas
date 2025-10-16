from mesa import Agent, Model
from mesa.time import SimultaneousActivation
import ast

# --- Agente base ---
class OperacionAgent(Agent):
    def __init__(self, unique_id, model):
        super().__init__(unique_id, model)

    def recibir(self, msg):
        pass


# --- Agente de entrada (IO) ---
class InputAgent(OperacionAgent):
    def step(self):
        for expr in self.model.expresiones:
            print(f"\n=== Nueva expresion: {expr} ===")
            nodo = ast.parse(expr, mode='eval').body
            self.model.mensajes.append({"to": "SUM", "expr": nodo, "from": "IO"})


# --- Agente de suma/resta ---
class SumaRestaAgent(OperacionAgent):
    def recibir(self, msg):
        expr = msg["expr"]
        if isinstance(expr, ast.BinOp):
            try:
                if isinstance(expr.op, ast.Add):
                    print("[SUM] Procesando suma...")
                    izq = self.model.evaluar(expr.left)
                    der = self.model.evaluar(expr.right)
                    resultado = izq + der
                    print(f"[SUM] {izq} + {der} = {resultado}")
                    return resultado
                elif isinstance(expr.op, ast.Sub):
                    print("[SUM] Procesando resta...")
                    izq = self.model.evaluar(expr.left)
                    der = self.model.evaluar(expr.right)
                    resultado = izq - der
                    print(f"[SUM] {izq} - {der} = {resultado}")
                    return resultado
            except Exception:
                return "Error al procesar suma/resta"
        return None


# --- Agente de multiplicacion/division/potencia ---
class MulDivAgent(OperacionAgent):
    def recibir(self, msg):
        expr = msg["expr"]
        if isinstance(expr, ast.BinOp):
            try:
                if isinstance(expr.op, ast.Mult):
                    print("[MUL] Procesando multiplicacion...")
                    izq = self.model.evaluar(expr.left)
                    der = self.model.evaluar(expr.right)
                    resultado = izq * der
                    print(f"[MUL] {izq} * {der} = {resultado}")
                    return resultado
                elif isinstance(expr.op, ast.Div):
                    print("[MUL] Procesando division...")
                    izq = self.model.evaluar(expr.left)
                    der = self.model.evaluar(expr.right)
                    if der == 0:
                        return "Error: division por cero"
                    resultado = izq / der
                    print(f"[MUL] {izq} / {der} = {resultado}")
                    return resultado
                elif isinstance(expr.op, ast.Pow):
                    print("[MUL] Procesando potencia...")
                    izq = self.model.evaluar(expr.left)
                    der = self.model.evaluar(expr.right)
                    resultado = izq ** der
                    print(f"[MUL] {izq} ** {der} = {resultado}")
                    return resultado
            except Exception:
                return "Error al procesar multiplicacion/division"
        return None


# --- Modelo principal ---
class EvaluadorModelo(Model):
    def __init__(self, expresiones):
        self.schedule = SimultaneousActivation(self)
        self.expresiones = expresiones
        self.mensajes = []

        self.io_agent = InputAgent("IO", self)
        self.sum_agent = SumaRestaAgent("SUM", self)
        self.mul_agent = MulDivAgent("MUL", self)

        self.schedule.add(self.io_agent)
        self.schedule.add(self.sum_agent)
        self.schedule.add(self.mul_agent)

    def evaluar(self, expr):
        if isinstance(expr, ast.Constant):
            return expr.value
        elif isinstance(expr, ast.BinOp):
            msg = {"expr": expr}
            res = self.mul_agent.recibir(msg)
            if res is not None:
                return res
            res = self.sum_agent.recibir(msg)
            if res is not None:
                return res
        return "Error: expresion invalida"

    def step(self):
        self.mensajes.clear()
        self.schedule.step()
        for msg in self.mensajes:
            resultado = self.evaluar(msg["expr"])
            print(f"Resultado final: {resultado}")


# --- Ejecucion del modelo ---
expresiones = [
    "2 + 3 * 4 - 5",
    "2 + 3 * (4 - 5)",
    "3 + 4 * 2 / (1 - 5) ** 2"
]

modelo = EvaluadorModelo(expresiones)
modelo.step()

