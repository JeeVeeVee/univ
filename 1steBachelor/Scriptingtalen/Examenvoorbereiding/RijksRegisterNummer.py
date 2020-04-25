from datetime import date

class Rijksregisternummer:
    def __init__(self, nummer):
        assert type(nummer) == type("str"), "ongeldig type"
        assert checkNummer(nummer), "ongeldig formaat (" + str(len(nummer)) + " cijfers)"
        self.nummer = nummer
        self.strippedNummer = getRaw(nummer)
        self.geboorte = self.strippedNummer[:6]
        self.dagTeller = self.strippedNummer[6:][:3]
        # True voor man, False voor vrouw
        self.geslacht = self.dagTeller % 2 == 1
        self.controle = self.strippedNummer[:2]
        self.nietControle = self.strippedNummer[9:]

    def __str__(self):
        return self.nummer

    def geboortedatum(self):
        output = date(int(self.geboorte), int(self.geboorte), int(self.geboorte))







def checkNummer(nummer):
    teller = 0
    getallen = "0123456789"
    for i in nummer:
        if i in getallen:
            teller += 1
    return teller == 11

def getRaw(nummer):
    output = ""
    getallen = "0123456798"
    for i in nummer:
        if i in getallen:
            output += i
    return output