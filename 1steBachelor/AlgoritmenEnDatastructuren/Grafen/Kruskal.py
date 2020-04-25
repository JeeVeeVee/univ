# https://dodona.ugent.be/nl/courses/119/series/1357/exercises/1264479914
from graph_library import *

def span(graph):
    result = UnDirectedGraph()

    if len(graph.get_all_edges()) < 1:
        result = graph
        return result


    lijst = []
    for edge in graph.get_all_edges():
        lijst.append([edge.get_nodes(), edge.weight])
    lijst = sorted(lijst, key=lambda x: x[1])

    for element in lijst:
        x = element[0][0]
        y = element[0][1]
        containsx = True if graph.contains_node(x) else False
        containsy = True if graph.contains_node(y) else False
        result.add_node(x)
        result.add_node(y)
        newedge = UndirectedEdge(x, y, weight=element[1])
        result.add_edge(newedge)

        if isCyclic(result):
            result.remove_edge(newedge)
            if not containsx:
                result.remove_node(x)
            if not containsy:
                result.remove_node(y)

    return result


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


graph = undirected_graph_from_dict({'Alice': ['Bob'], 'Bob': ['Carol'], 'Carol': ['Alice']}, weights = {('Alice', 'Bob'): 10, ('Bob', 'Carol'): 5, ('Carol', 'Alice'): 1})
sptr = span(graph)
print(sptr.get_all_nodes())
print(sptr.get_all_edges())