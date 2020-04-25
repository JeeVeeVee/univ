#! /usr/bin/python
def minimumAverageEndtime(tijden):
    voorlopigetijd = 0;
    sum = 0
    x = len(tijden)
    for i in range(len(tijden)):
        voorlopigetijd += tijden[vindMin(tijden)]
        sum += voorlopigetijd
        tijden.pop(vindMin(tijden))
    output =  sum / x
    return output
def vindMin(lijst):
    min = lijst[0]
    output = 0
    for i in range(len(lijst)):
        if lijst[i] < min:
            min = lijst[i]
            output = i
    return output

print(minimumAverageEndtime([15, 8, 3, 10]))
