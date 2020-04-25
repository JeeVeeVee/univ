def getallenrij(n, k=0, aantal=-1):
    stijgings = bepaalGetallen(n)
    if aantal == -1:
        aantal = n
    output = []
    huidige = k
    # print(aantal)
    for i in range(aantal):
        output.append(huidige)
        if huidige >= n:
            break
        huidige += stijgings[i % len(str(n))]
    return output


def isbelgisch(n, k=0):
    rij = getallenrij(n, k)
    return n == rij[len(rij) - 1]


def beginwaarden(n):
    output = []
    for i in range(n + 1):
        if (isbelgisch(n, i)):
            output.append(i)
    return output


def bepaalGetallen(getal):
    output = []
    StringGetal = str(getal)
    for cijfer in StringGetal:
        output.append(int(cijfer))
    return output

