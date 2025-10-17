from mesa.visualization.modules import CanvasGrid
from mesa.visualization.ModularVisualization import ModularServer
from percep_modelo import PerceptronModel


def agent_portrayal(agent):
    """Cómo se muestra cada punto según su salida actual."""
    portrayal = {
        "Shape": "circle",
        "Filled": "true",
        "r": 0.7,
        "Layer": 0  # ✅ CAPA NECESARIA PARA MESA 2.1.1
    }

    # Verde si está bien clasificado, rojo si está mal
    if agent.output == agent.label:
        portrayal["Color"] = "green"
    else:
        portrayal["Color"] = "red"

    return portrayal


# --- Grilla visual ---
grid = CanvasGrid(agent_portrayal, 20, 20, 500, 500)

# --- Parámetros fijos (ajústalos a tu gusto) ---
fixed_params = {
    "N": 50,
    "learning_rate": 0.05,
    "iterations": 100,
}

# --- Servidor ---
server = ModularServer(
    PerceptronModel,
    [grid],
    "Simulación del Perceptrón (Versión compatible Mesa 2.1.1)",
    fixed_params
)

server.port = 8521
