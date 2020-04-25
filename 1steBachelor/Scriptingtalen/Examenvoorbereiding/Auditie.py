class Collectie:
    def __init__(self, lijst):
        self.nummers = []
        for element in lijst:
            if str(type(element)) == "<class 'int'>":
                self.nummers.append(element)
            elif str(type(element)) == "<class 'list'>":
                assert len(element) == 2, "ongeldige collectie"
                for i in range(element[0], element[1] - 1):
                    self.nummers.append(i)
            else:
                print(type(element))
            self.nummers.sort()

    def getallen(self):
        return set(self.nummers)


A = Collectie([33, [27, 30], 32, 25, [20, 24], 31, 19])
print(A.getallen())
