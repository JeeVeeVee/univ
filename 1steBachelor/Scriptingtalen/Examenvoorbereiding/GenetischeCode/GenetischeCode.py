class GenetischeCode:
    def __init__(self, tekstbestand):
        self.tabel = {}
        x = open(tekstbestand, "r")
        for lijn in x:
            koppel = lijn[:-1].split(" ")
            self.tabel[koppel[0]] = koppel[1]
    def aminozuur(self, code):
        OGCode = code
        code = code.replace("U", "T")
        assert len(code) == 3, OGCode + " is geen geldig codon."
        assert code.upper() in self.tabel.keys(), OGCode +  " is geen geldig codon."
        return self.tabel[code.upper()]

code = GenetischeCode('standaard_code.txt')

print(code.aminozuur('UCU'))