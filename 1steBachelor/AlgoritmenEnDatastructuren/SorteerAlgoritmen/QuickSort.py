import random
import datetime

def quicksort(rij):
    if len(rij) <= 1:
        return rij
    else:
        rechts = []
        links = []
        spillen = []
        spil = 0
        #print(spil, rij)
        for i in range(len(rij)):
            if rij[i] < rij[spil]:
                links.append(rij[i])
            elif rij[i] > rij[spil]:
                rechts.append(rij[i])
            elif rij[i] == rij[spil]:
                spillen.append(rij[i])
        return quicksort(links) + spillen + quicksort(rechts)

def mergeSort(rij):
    if len(rij) == 1:
        return rij
    links = mergeSort(rij[len(rij) // 2:])
    links.append(1000)
    rechts = mergeSort(rij[:len(rij) // 2])
    rechts.append(1000)
    output = []
    l = 0
    r = 0
    for i in range(len(rij)):
        if (links[l] < rechts[r]):
            output.append(links[l])
            l += 1
        else:
            output.append(rechts[r])
            r += 1
    return output


rij = []
for i in range(1000000):
    rij.append(random.randint(0,100))

print(rij)

x = datetime.datetime.now()
print(mergeSort(rij))
y = datetime.datetime.now()
eersteTijd = y - x
print("merge", eersteTijd)




x = datetime.datetime.now()
print(quicksort(rij))
y = datetime.datetime.now()
eersteTijd = y - x
print("quick", eersteTijd)

x = datetime.datetime.now()
nieuw = rij.sort()
y = datetime.datetime.now()
tweedeTijd = y - x
print("intern", tweedeTijd)