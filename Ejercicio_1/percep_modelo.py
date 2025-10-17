from mesa import Agent, Model
from mesa.time import RandomActivation
from mesa.space import MultiGrid
import random

class Punto(Agent):
    """Agente que representa un punto con etiqueta y coordenadas."""
    def __init__(self, unique_id, model, x, y, label):
        super().__init__(unique_id, model)
        self.pos = (x, y)
        self.label = label
        self.output = 0  # salida del perceptrón

    def step(self):
        x1, x2 = self.pos
        suma = (self.model.w1 * x1) + (self.model.w2 * x2) + self.model.bias
        self.output = 1 if suma >= 0 else 0

        error = self.label - self.output
        if error != 0:
            self.model.w1 += self.model.lr * error * x1
            self.model.w2 += self.model.lr * error * x2
            self.model.bias += self.model.lr * error


class PerceptronModel(Model):
    def __init__(self, N=40, learning_rate=0.05, iterations=50):
        self.num_agents = N
        self.grid = MultiGrid(20, 20, True)
        self.schedule = RandomActivation(self)
        self.lr = learning_rate
        self.iterations = iterations

        self.w1 = random.uniform(-1, 1)
        self.w2 = random.uniform(-1, 1)
        self.bias = random.uniform(-1, 1)

        for i in range(self.num_agents):
            x = random.randint(0, 19)
            y = random.randint(0, 19)
            label = 1 if y > x else 0
            punto = Punto(i, self, x, y, label)
            self.schedule.add(punto)
            self.grid.place_agent(punto, (x, y))

        self.running = True
        self.step_count = 0

    def step(self):
        if self.step_count < self.iterations:
            self.schedule.step()
            self.step_count += 1
        else:
            self.running = False
