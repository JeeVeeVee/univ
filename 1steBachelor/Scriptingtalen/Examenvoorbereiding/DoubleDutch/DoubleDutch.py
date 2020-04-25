def medeklinkers(tekstbestand):
    raw = open(tekstbestand, "r")
    output ={}
    for lijn in raw:
        koppel = lijn[:-1].split(" - ")
        assert checkKoppel(koppel), "ongeldige vertaling"
        output[koppel[0]] = koppel[1]
    return output

def vertaalWoord(woord, vertaling):
    output = []
    hoofdletters = []
    for letter in woord:
        if letter == letter.upper():
            hoofdletters.append(True)
        else:
            hoofdletters.append(False)
    woord = woord.lower()
    klinkers = "aeiou"
    for letter in woord:
        if letter in klinkers:
            if (output[len(output) - 1] == letter):
                output[len(output) - 1] = "squat" + letter + "h"
            else:
                output.append(letter)
        else:
            if (len(output) > 0 and output[len(output) - 1] == letter):
                output[len(output) - 1] = "squa" + letter
            else:
                output.append(vertaling[letter])
    for i in range(len(hoofdletters)):
        if hoofdletters[i]:
            output[i] = output[i].capitalize()
            print(output[i])
    x = ""
    for element in output:
        x += element
    return x

def checkKoppel(koppel):
    return checkMedeklinker(koppel[0]) and checkEersteLetterDeel2(koppel)

def checkMedeklinker(letter):
    klinkers = "aeiou"
    return letter not in klinkers

def checkEersteLetterDeel2(koppel):
    beginLetter = koppel[0]
    return koppel[1][0] == beginLetter

def checkBestand(bestand):
    return True

