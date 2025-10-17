import random

class Robot:
    def __init__(self, identificador, tipo, vida):
        self.id = identificador
        self.tipo = tipo
        self.vida = vida

    def __str__(self):
        return f"ID:{self.id}, Tipo:{self.tipo}, Vida:{self.vida}%"

class ListaRobots:
    def __init__(self):
        self.robots = []

    # 1. Adicionar manteniendo orden descendente por vida
    def adicionar_robot(self, identificador, tipo, vida):
        nuevo = Robot(identificador, tipo, vida)
        self.robots.append(nuevo)
        self.robots.sort(key=lambda r: r.vida, reverse=True)

    # 2. Mostrar todos los robots
    def mostrar(self):
        for r in self.robots:
            print(r)

    # 3. Mostrar robots con vida = 60
    def mostrar_vida_60(self):
        filtrados = [r for r in self.robots if r.vida == 60]
        for r in filtrados:
            print(r)
        print("Total robots con vida=60:", len(filtrados))

    # 4. Disminuir 15% a robots con vida entre 30 y 50
    def disminuir_vida(self):
        afectados = []
        for r in self.robots:
            if 30 <= r.vida <= 50:
                r.vida = max(0, r.vida - 15)
                afectados.append(r)
        for r in afectados:
            print("Afectado:", r)
        print("Total robots modificados:", len(afectados))
        self.robots.sort(key=lambda r: r.vida, reverse=True)

    # 5. Eliminar los 3 robots con mayor vida
    def eliminar_top3(self):
        eliminados = self.robots[:3]
        self.robots = self.robots[3:]
        for r in eliminados:
            print("Eliminado:", r)
        print("Lista actualizada:")
        self.mostrar()

# ---- PRUEBA ----
tipos = ["colaborativo","asistente","servicio","exploración"]
robots = ListaRobots()
for _ in range(30):
    robots.adicionar_robot(
        random.randint(1000,9999),
        random.choice(tipos),
        random.randint(10,100)
    )

robots.mostrar()
robots.mostrar_vida_60()
robots.disminuir_vida()
robots.eliminar_top3()
