class Doolhof:
    def __init__(self, bestand):
        self.waarden = maakwaarden(bestand)
        self.route = []
    def __repr__(self):
        output = ""
        for row in self.waarden:
            for element in row:
                if element == -1:
                    output += "##### "
                else:
                    output += str("%.3f" % round(element, 3)) + " "
            output = output[:len(output) - 1] + "\n"
        return output[:len(output) - 1]

    def volgende_niveau(self, coordinaten, debiet):
        i = coordinaten[0]
        j = coordinaten[1]
        if(self.waarden[i][j] == 1):
            return 1.0
        elif(self.waarden[i][j] == -1.0):
            return -1.0

        # op deze manier worden de muren allemaal uitgeblokt

        (onder, boven, rechts, links, x) = (self.waarden[i][j], self.waarden[i][j], self.waarden[i][j], self.waarden[i][j], self.waarden[i][j])
        if self.waarden[i - 1][j] >= 0:
            boven = self.waarden[i - 1][j]

        if self.waarden[i][j + 1] >= 0:
            rechts = self.waarden[i][j + 1]

        if self.waarden[i + 1][j] >= 0:
            onder = self.waarden[i + 1][j]

        if self.waarden[i][j - 1] >= 0:
            links = self.waarden[i][j - 1]
        nieuweWaarde = x + debiet * ((boven - x) + (rechts - x) + (onder - x) + (links - x))
        return nieuweWaarde

    def simuleer_niveau(self, debiet, stappen = 1):
        nieuweWaarden = []
        nieuweRoute = []
        for i in range(len(self.waarden)):
            aanhangsel = []
            for j in range(len(self.waarden[i])):
                nieuweWaarde = self.volgende_niveau([i, j], debiet)
                if nieuweWaarde != self.waarden[i][j]:
                    self.route.append((i, j))
                aanhangsel.append(nieuweWaarde)
            nieuweWaarden.append(aanhangsel)
        self.waarden = nieuweWaarden

    def route(self):
            return self.route



def maakwaarden(bestand):
    output  = []
    file = open(bestand, "r")
    for line in file:
        aanhangsel = []
        for char in line:
            if char == "#":
                aanhangsel.append(-1.0)
            elif char == " ":
                aanhangsel.append(0.0)
            elif char == "+":
                aanhangsel.append(1.0)
            elif char == "-":
                aanhangsel.append(0.0)
        output.append(aanhangsel)
    return output

doolhof = Doolhof('doolhof.txt')


