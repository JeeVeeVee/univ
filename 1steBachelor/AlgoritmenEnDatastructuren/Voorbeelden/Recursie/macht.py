import datetime

def macht(x, n):
    if n == 0:
        return 1
    elif n % 2 == 0:
        return macht(x * x, n // 2)
    elif n % 2 == 1:
        return macht(x * x, n // 2) * x

def macht2(x, n):
    output = 1
    for i in range(n):
        output *= x
    return output

x = datetime.datetime.now()
print(macht(2, 1000000))
y = datetime.datetime.now()
print(y -x)
x = datetime.datetime.now()
print(macht2(2, 1000000))
y = datetime.datetime.now()
print(y -x)