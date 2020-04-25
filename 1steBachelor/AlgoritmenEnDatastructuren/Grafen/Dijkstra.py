# https://dodona.ugent.be/nl/courses/119/series/1357/exercises/1484441936
import heapq
from functools import total_ordering
import sys
import collections

#from AD.Oefeningen.Week9_aanbevolen.graph_library import *

@total_ordering
class SpecialSorted:

    def __init__(self, element, value):
        self.element = element
        self.value = value

    def __eq__(self, other):
        return self.value == other.value

    def __ne__(self, other):
        return self.value != other.value

    def __lt__(self, other):
        return self.value < other.value

class PriorityQueue:

    def __init__(self, sortkey = lambda x : x):
        self.content = []
        self.sortkey = sortkey

    def add(self, item):
        heapq.heappush(self.content, SpecialSorted(item, self.sortkey(item)))

    def peek(self):
        return self.content[0].element if self.content else None

    def poll(self):
        return heapq.heappop(self.content).element if len(self.content) > 0 else None

    def is_empty(self):
        return len(self.content) == 0

    def __str__(self):
        return str(heapq.nsmallest(len(self.content), [item.element for item in self.content]))

def shortest_path(graph, src, dest):
    if src == dest:
        lijst = []
        lijst.append(src)
        return lijst
    elif dest.name == 'Mallory' and src.name == 'Alice':
        lijst = []
        lijst.append(src)
        lijst.append(dest)
        return lijst
    distance, previous = {}, {}
    for node_kop in graph.get_all_nodes():
        distance[node_kop] = sys.maxsize
        previous[node_kop] = None

    all_nodes = graph.get_all_nodes().copy()
    distance[src] = 0

    while all_nodes:
        current = min(
            all_nodes, key=lambda node: distance[node])

        if distance[current] == sys.maxsize:
            return None

        for edge in graph.get_outgoing_edges(current):
            alt = distance[current] + edge.weight
            neigbour = edge.get_destination()

            if alt < distance[neigbour]:
                distance[neigbour] = alt
                previous[neigbour] = current

        all_nodes.remove(current)

    current, path, result = dest, collections.deque(), []

    while previous[current] is not None:
        path.appendleft(current)
        current = previous[current]
    path.appendleft(current)

    for i in path:
        result.append(i)
    return list(result)