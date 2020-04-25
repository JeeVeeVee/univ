def inversies(rij):
    if len(rij == 0):
        return 0
    else:
        x = inversies(rij[len(rij) // 2:])
        y = inversies(rij[len(rij // 2)])
        xS = rij[len(rij) // 2].sort()
        yS = rij[len(rij)// 2].sort()
        huidige = 0
        z = 0
        while(xS and yS):
            if(xS[0] < yS[0]):
                return False

