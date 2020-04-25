#! /usr/bin/python
def vindStopplaatsen(max, stopplaatsen):
    laaststeTank = stopplaatsen[0]
    output = []
    stopTeller = 0;
    for i in range(len(stopplaatsen)):

        if stopplaatsen[i] - laaststeTank > max:
            output.append(stopplaatsen[i - 1])
            stopTeller += 1
            laaststeTank = stopplaatsen[i - 1]
    return (stopTeller, output)
