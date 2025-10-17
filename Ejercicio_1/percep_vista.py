from mesa.visualization.modules import CanvasGrid
from mesa.visualization.ModularVisualization import ModularServer
from percep_modelo import PerceptronModel


def agent_portrayal(agent):
    """Como se muestra cada punto segun su salida actual."""
    portrayal = {
        "Shape": "circle",
        "Filled": "true",
        "r": 0.7,
        "Layer": 0  
    }

   
    if agent.output == agent.label:
        portrayal["Color"] = "green"
    else:
        portrayal["Color"] = "red"

    return portrayal


# --- Grilla visual ---
grid = CanvasGrid(agent_portrayal, 20, 20, 500, 500)

# --- Parametros fijos (Se ajustan al gusto de la persona) ---
fixed_params = {
    "N": 50,
    "learning_rate": 0.05,  # ejemplosss
    "iterations": 100,
}

# --- Servidor ---
server = ModularServer(
    PerceptronModel,
    [grid],
    "Simulacion del Perceptron",
    fixed_params
)

server.port = 8521


