####### bepalen van het aantal stappen waarbij de kans voor het verder zijn #######
####### dan 4 meter van het beginpunt groter is dan 95%                     #######
plinks <- 0.5
prechts <- 0.5

iseven<-function(x){
  return (x/2 == (floor(x/2)))
}

calcDistance<-function(i, n){
  if(iseven(n)){
    if(i < n / 2){
      return ((n/2) - i > 4) 
    } else{
      return (i - (n/2) + 1 > 4)
    }
  }
  else{
    mid = floor(n/2)
    return (abs(mid - i) > 4)
  }
}

calcChance<-function(n)
{
  i = 0
  som = 0
  test = 0
  while (i < n){
    if (calcDistance(i, n + 1) == TRUE){
      som = som + dbinom(i,n,plinks)
    } else {
      #print(i)
     #print(dbinom(i,n,plinks))
    }
    i = i + 1
  }
  print(som)
}

####### simulations ########

simulate<-function(n){
  i = 0
  goed = 0
  slecht = 0
  while (i < 1000){
    positie = 0
    j = 0
    while(j < n){
      random = runif(1)
      if(random > 0.5){
        positie = positie + 1
      } else {
        positie = positie - 1
        
      }
      j = j + 1
    }
    if (abs(positie) > 4){
      goed = goed + 1
    } else {
      slecht = slecht + 1
    }
    print(goed/(goed + slecht))
    i = i + 1
  }
}

x = 0
while(calcChance(x) < 0.95){
  print(calcChance(x))
  x = x +1
}

