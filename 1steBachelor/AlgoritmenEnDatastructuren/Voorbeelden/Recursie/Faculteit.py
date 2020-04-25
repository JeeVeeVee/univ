import datetime



def faculteit1(n):
    output = 1
    for i in range(1, n + 1):
        output *= i
    return output

def faculteit2(n):
    if (n == 1):
        return n
    else:
        return n * faculteit2(n-1)

teller1 = 0
teller2 = 0
for i in range(1, 100):
    x = datetime.datetime.now()
    print(faculteit1(i))
    y = datetime.datetime.now()
    eersteTijd = y - x
    x = datetime.datetime.now()
    print(faculteit2(i))
    y = datetime.datetime.now()
    tweedeTijd = y - x
    if(tweedeTijd < eersteTijd):
        teller2 += 1
        #print("tweede: " + str(tweedeTijd))
        #print("verschil is: " +  str(eersteTijd - tweedeTijd))
    else:
        #print("eerste: "+ str(eersteTijd))
        #print("verschil is: " +str(tweedeTijd - eersteTijd))
        teller1 += 1
print(teller1, teller2)