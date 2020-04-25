# https://dodona.ugent.be/nl/courses/119/series/1355/exercises/1651129225
#from graph_library import *

def bepaal_topologische_ordening(graph):
    assert isCyclic(graph), "de graaf bevat een cykel"
    graaf = DirectedGraph(graph)
    output = []
    length = len(graaf.get_all_nodes())
    while len(output) < length:
        x = bepaalMinAantalEdges(graaf)
        while x != []:
            graaf.remove_node(x[0])
            output.append(x[len(x) - 1])
            x.remove(x[len(x)- 1])
        #print(output)
    return output



def bepaalMinAantalEdges(graaf):
    max = 100
    output = []
    for node in graaf.get_all_nodes():
        aantal = len(graaf.get_incoming_edges(node))
        #print(node, aantal)
        if aantal < max:
            max = aantal
            output = [node]
    return output

def isCyclicUtil(graaf, v, visited, parent):

    visited[v] = True
    for node in graaf.get_neighbours(v):
        if not visited[node]:
            if isCyclicUtil(graaf, node, visited, v):
                return True
        elif parent != node:
            return True

    return False

def isCyclic(graaf):
    visited = {node: False for node in graaf.get_all_nodes()}

    for node in graaf.get_all_nodes():
        if not visited[node]:
            if isCyclicUtil(graaf, node, visited, -1):
                return True
    return False

