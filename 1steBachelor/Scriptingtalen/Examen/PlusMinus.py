def uitdrukking(cijfers, operatoren):
    assert len(cijfers) == len(operatoren) + 1, "ongeldige uitdrukking"
    toegestaan = "+|-"
    output = ""
    for i in range(len(cijfers) - 1):
        assert int(cijfers[i]) > 0, "ongeldige uitdrukking"
        assert operatoren[i] in toegestaan, "ongeldige uitdrukking"
        if (operatoren[i] == "|"):
            output += str(cijfers[i])
        else:
            output += str(cijfers[i]) + " " + str(operatoren[i]) + " "
    return output + str(cijfers[len(cijfers) - 1])

def uitkomst(getallen, operatoren):
    return eval(uitdrukking(getallen, operatoren))

def plusMinus(doel, getallen = (0,1,2,3,4,5,6,7,8,9)):
    output = []
    mogelijkheden = getallen



getallen = (1, 2, 3, 4, 5, 6, 7, 8, 9)
print(uitkomst(getallen, '++-+++|+'))