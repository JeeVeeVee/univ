# https://dodona.ugent.be/nl/courses/119/series/1393/exercises/225388857
'''
 tabel = een tabel van (1..n+1) bij (0..G)
 for w = 0..G
  tabel[n+1, w] = 0
 for i = n..1
  for w = 1..G
   if gewicht van object i <= w then
    tabel[i,w] = max( tabel[i+1, w - gewicht object i] + waarde van object i, tabel[i+1, w] )
   else
    tabel[i,w] = tabel[i+1, w]
   fi
 return tabel[1, G]
'''

def knapzak(maxgrootte, gewichten, winsten):
    currentwinst = 0
    currentWeigths = []
    chosenWeigths = []
    for x in range(len(gewichten)):
        chosenWeigths.append(False)
    minscore = 0
    for x in range(len(gewichten)):
        if len(chosenWeigths) < maxgrootte:
            score = gewichten[x]/winsten[x]
