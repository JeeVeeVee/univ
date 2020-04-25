class Populatie:
    def __init__(self, m = 0, n = 0, k = 0):
        self.m = m
        self.n = n
        self.k = k
        self.ontmoetingen = 0
        self.verhoudingen = [0, m, m + n]

    def plasmiden(self):
        return (self.m , self.n , self.k)

    def __str__(self):
        output = "type I: " + str(self.m) + ", "
        output += "type II: " + str(self.n) + ", "
        output += "type III: " +str(self.k) + " "
        output += "(na " + str(self.ontmoetingen) + " ontmoetingen)"
        return output

    def __repr__(self):
        return "Populatie" + str((self.m, self.n, self.k))

    def grootte(self):
        return self.n + self.m + self.k

    def ontmoeting(self, i , j):
        typeI = 0
        while i > self.verhoudingen[typeI]:
            typeI += 1
        print(typeI)

populatie = Populatie(50, 50, 50)
populatie.ontmoeting(140, 4)