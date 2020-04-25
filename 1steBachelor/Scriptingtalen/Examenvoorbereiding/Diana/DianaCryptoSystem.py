class Diana:
    def __init__(self, bestand):
        self.pad = ""
        file = open(bestand, "r")
        alfabet = "AZERTYUIOPQSDFGHJKJKKLMWXCVNB"
        for line in file:
            for char in line:
                if char in alfabet:
                    self.pad += char

    def index(self, string):
        searchstring = ""
        for char in string:
            if char in "ABCDEFGHIJKMNOPQRSTUVWXYZ":
                searchstring += char
        assert self.pad.find(searchstring) >= 0, "ongeldige prefix"
        return self.pad.find(searchstring) + len(searchstring)

    def trigraph(self, a, b):
        a = a.upper()
        b = b.upper()
        alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        waardeA = alfabet.find(a)
        waardeB = alfabet.find(b)
        return alfabet[(25 - waardeA - waardeB) % 26]

    def codeer(self, woord, n = 10):
        onePad = ""
        i = 0
        while woord[i] in "ABCDEFGHIJKLMNOPQRSTUVWXYZ ":
            onePad += woord[i]
        input = woord[len(onePad)]

diana = Diana('otp.txt')
print(diana.index('ABCDE FGHIJ'))