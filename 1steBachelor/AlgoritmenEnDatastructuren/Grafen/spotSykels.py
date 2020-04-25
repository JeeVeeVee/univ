from graph_library import *
def canReachItself(graph, node):
    graaf = DirectedGraph(graph)
    nodes = list(graaf.get_all_nodes())
    beginNode = nodes[0]
    buren = [beginNode]
    for i in range(1, len(nodes)):
        node = nodes[i]
        volgendeBuren = graaf.get_neighbours(node)
        for x in volgendeBuren:
            buren.append(x)
    return len(list(set(buren))) == len(buren)


graph01 = directed_graph_from_dict({3: [7], 7: [5], 2: [7, 5], 5: []})
graph02 = directed_graph_from_dict({1: [2], 2: [3], 3: [1], 5: []})
graph42 = directed_graph_from_dict({3: [12, 5, 13, 6], 2: [13], 8: [4, 11, 7, 5, 14], 7: [13, 11, 6, 9, 12, 14, 1, 10, 5], 11: [5, 13, 14, 9], 5: [1, 14, 6, 4, 9, 13, 12], 10: [4, 13, 14, 9], 12: [1, 14], 13: [9, 4, 1, 6, 14], 14: [], 9: [7], 4: [], 1: [], 6: []})
