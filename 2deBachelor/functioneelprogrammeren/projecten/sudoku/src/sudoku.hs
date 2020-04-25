{-|

  Een sudoku wordt voorgesteld door een tweedimensionaal rooster van getallen.
  We gebruiken geneste lijsten "row-first", zoals in onderstaande tekening.

    o---0-1-2--3-4-5--6-7-8-----> x
    |
   0| [[0,0,0|,0,0,0,|0,0,0],
   1|  [0,0,0|,0,0,0,|0,0,0],
   2|  [0,0,0|,0,0,0,|0,0,0],
    |  ------+-------+------
   3|  [0,0,0|,0,0,0,|0,0,0],
   4|  [0,0,0|,0,0,0,|0,0,0],
   5|  [0,0,0|,0,0,0,|0,0,0],
    |  ------+-------+------
   6|  [0,0,0|,0,0,0,|0,0,0],
   7|  [0,0,0|,0,0,0,|0,0,0],
   8|  [0,0,0|,0,0,0,|0,0,0]]
   |
   V
   y
-}
type Board = [[Int]]

-- Enkele type-synoniemen
type Row = [Int]   -- ^ Een rij in een sudoku.
type Col = [Int]   -- ^ Een kolom in een sudoku.
type X   = Int     -- ^ De x van een coördinaat.
type Y   = Int     -- ^ De y van een coördinaat.

-- Enkele constanten
empty, width, height :: Int
empty  =  0  -- ^ Een leeg vakje.
width  =  9  -- ^ De breedte van een sudoku.
height =  9  -- ^ De hoogte van een sudoku.

-- | Een lege rij.
emptyRow :: Row
emptyRow = replicate width empty

-- | Een leeg bord.
emptyBoard :: Board
emptyBoard = replicate height emptyRow

-- | Neem een rij uit een sudoku.
getRow :: Board -> Y -> Row
getRow = undefined

-- | Neem een kolom uit een sudoku.
getCol :: Board -> X -> Col
getCol = undefined

-- | Controleert of een gegeven getal voorkomt in een gegeven rij.
contains :: Int -> [Int] -> Bool
contains = undefined

-- | Bereken een deellijst.
getSubList :: Int  -- ^ Start-index (inclusief).
           -> Int  -- ^ Eind-index (inclusief).
           -> [a]  -- ^ Volledige lijst.
           -> [a]  -- ^ Deellijst.
getSubList = undefined

{-

  Met de volgende drie functies zullen we kijken of een vierkantje van 3 op 3
  een gegeven getal bevat. We omschrijven het vierkantje door 1 van zijn 9
  coördinaten in het volledige rooster. Gegeven bijvoorbeeld coördinaat (1,1)
  zoeken we in het vierkantjes linksboven. Coördinaat (4,1) wijst van weer op
  het vierkantje bovenaan in het midden.

-}

-- | De grenzen van het vierkantje waar gegeven getal in ligt.
index :: Int -> (Int, Int)
index = undefined

-- | De lijst van getallen die in het vierkantje van gegeven coördinaat liggen.
-- Hint: gebruik tweemaal `getSubList`.
getSubSquare :: Board -> X -> Y -> [Int]
getSubSquare = undefined

-- | Of in een rooster een getal op de gegeven coördinaten ligt.
containedInSquare :: Board -> Int -> X -> Y -> Bool
containedInSquare = undefined

-- | Of in een rooster een getal op gegeven coördinaat past. Dit is het geval
-- als de omvattende rij, kolom of vakje van die coördinaat dat getal nog niet
-- bevatten.
canPlaceNumber :: Board -> Int -> X -> Y -> Bool
canPlaceNumber = undefined

-- | Vervangt het element op gegeven coördinaat door het gegeven element.
replace :: a -> Int -> [a] -> [a]
replace = undefined

-- | Vervangt het element op gegeven coördinaat door het gegeven element.
update :: Int -> X -> Y -> Board -> Board
update = undefined

-- | De eerste (in leesvolgorde) lege coördinaat in een bord.
findFirstEmpty :: Board -> (X, Y)
findFirstEmpty = undefined

-- | Of dit bord geen lege vakjes meer bevat.
noneEmpty :: Board -> Bool
noneEmpty = undefined

-- | De lijst van getallen die past op een locatie op een bord.
options :: Board -> X -> Y -> [Int]
options = undefined

-- | De lijst van mogelijke borden die 1 vakje verder ingevuld zijn.
nextBoards :: Board -> [Board]
nextBoards = undefined

-- | Los een sudoku-puzzel op.
solve :: Board    -- ^ De focus, de huidige oplossing.
      -> [Board]  -- ^ De borden die we nog verder kunnen uitwerken.
      -> Board    -- ^ De opgeloste sudoku.
solve = undefined