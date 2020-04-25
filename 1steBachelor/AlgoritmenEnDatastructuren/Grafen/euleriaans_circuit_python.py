# https://dodona.ugent.be/nl/courses/119/series/1354/exercises/2029702206
from graph_library import *

def euler(lijst: dict):
    graaf = directed_graph_from_dict(lijst)
    startNode = graaf.get_all_nodes()[0]
    euler = [startNode];
    nodes = {startNode}