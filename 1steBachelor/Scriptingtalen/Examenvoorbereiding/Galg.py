class Galgje:
    def __init__(self, woord):
        self.woord = woord
        self.beurten = 6
        self.check = list((woord))
        self.geraden = []
        for i in range(len(woord)):
            self.geraden.append(False)

    def __str__(self):
        output = "Je hebt nog " + str(self.beurten)+ " beurten." + "\n"
        for i in range(len(self.geraden)):
            if (self.geraden[i]):
                output += self.woord[i]
            else:
                output += "."
        return output

    def raadLetter(self, letter):
        assert len(letter) == 1, "argument is geen letter"
        if (letter.lower() in self.woord.lower()):
            self.geraden[self.woord.inded(letter)] = True
        else:
            self.beurten -= 1
            print("Fout: letter " + letter + " komt niet voor in het woord")
            print(self)


x = Galgje("kaka")
print(x)

def getIndexen(woord, letter):
    output = []
    for i in range(len(woord)):
        if letter == woord[i]:
            output.append(i)
    return output




