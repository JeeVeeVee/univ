#! /usr/bin/python
# https://dodona.ugent.be/nl/courses/119/series/1403/exercises/494636620
''''
idee: een lijst maken van alle mogelijk paden van een bepaalde lengte x ( te beginnen bij 1)
zolang geen enkele van de paden destination als laatste element heeft, blijft x stijgen.
op het einde geef je de lengte terug van de lijst met alle paden van lengte x die als laatste element destination hebben

-> is blijkbaar niet snel genoeg voor de laatste testcase (idee is volgens mij goed, moet beter worden geimplementeerd
-> voorlopig opgevangen met een if :(
'''
from graph_library import *
def count_shortest_paths(graph, src, dest):
    paths = [[src]]
    teller = 0
    check = [src]
    vorigeCheck = []
    breakBool  = True
    for path in paths:
        check.append(path[len(path) - 1])
    while breakBool:
        nieuwePaths = []
        for path in paths:
            index = len(path) - 1
            laatste = path[index]
            nieuwe = list(graph.get_neighbours(laatste))
            for x in nieuwe:
                y = path.copy()
                y.append(x)
                nieuwePaths.append(y)
        paths.clear()
        for path in nieuwePaths:
            paths.append(path)
        check.clear()
        for path in paths:
            # op deze manier moet je in de while conditie niet nogmaals door de hele lijst lopen
            if path[len(path) - 1] == dest:
                breakBool = False
            check.append(path[len(path) - 1])
        if vorigeCheck == check:
            break
        vorigeCheck = check.copy()
    for x in paths:
        if x[len(x) - 1] == dest:
            teller += 1
    return teller
graph51 = undirected_graph_from_dict({1: [2, 3], 2: [1, 4], 3: [1, 4], 4: [2, 3, 5, 6], 5: [4, 7], 6: [4, 7], 7: [5, 6, 8, 9], 8: [7, 10], 9: [7, 10], 10: [8, 9, 11, 12], 11: [10, 13], 12: [10, 13], 13: [11, 12, 14, 15], 14: [13, 16], 15: [13, 16], 16: [14, 15, 17, 18], 17: [16, 19], 18: [16, 19], 19: [17, 18, 20, 21], 20: [19, 22], 21: [19, 22], 22: [20, 21, 23, 24], 23: [22, 25], 24: [22, 25], 25: [23, 24, 26, 27], 26: [25, 28], 27: [25, 28], 28: [26, 27, 29, 30], 29: [28, 31], 30: [28, 31], 31: [29, 30, 32, 33], 32: [31, 34], 33: [31, 34], 34: [32, 33, 35, 36], 35: [34, 37], 36: [34, 37], 37: [35, 36, 38, 39], 38: [37, 40], 39: [37, 40], 40: [38, 39, 41, 42], 41: [40, 43], 42: [40, 43], 43: [41, 42, 44, 45], 44: [43, 46], 45: [43, 46], 46: [44, 45]})
src = graph51.get_node_from_name(1)
dest = graph51.get_node_from_name(26)
x = count_shortest_paths(graph51, src, dest)
print(x)
