{-
_________              __           
/   _____/ ____ _____  |  | __ ____  
\_____  \ /    \\__  \ |  |/ // __ \ 
/        \   |  \/ __ \|    <\  ___/ 
/_______  /___|  (____  /__|_ \\___  >
       \/     \/     \/     \/    \/ 
--
-- Hint omzetten getallen: 
-- https://wiki.haskell.org/Converting_numbers
--
-}

--
-- In deze opdacht maken we gebruik van de grafische 
-- bibliotheek gloss. Om deze kunnen te gebruiken 
-- moeten we deze eerst importeren (keyword import)
import Graphics.Gloss.Interface.Pure.Game
import Graphics.Gloss.Data.Picture
import Graphics.Gloss.Data.Bitmap

-- Om de appel te kunnen plaatsten moeten 
-- we ook gebruik maken van een random nummer
-- generator 
import System.Random


-- We beginnen met het definiëren van enkele
-- type synoniemen. Dit wilt zeggen dat we 
-- een bepaald type een nieuwe naam geven
-- In dit geval geven we het type (Int,Int) 
-- de naam Coordinaat en Richting.
type Coordinaat = (Int,Int) 
type Richting   = (Int,Int)


-- Daarna definiëren we de data om de slang voor te stellen 
-- In deze opdracht moet je zelf nog geen data definities maken 
-- maar je moet deze wel reeds kunnen lezen.
-- 
-- De slang zelf stellen we voor als een lijst van coordinaten 
-- 

type Slang   =  [Coordinaat]

-- We moeten bijhouden of de slang levend of dood is 
-- Hiervoor maken we het Status datatype
data Status     = Levend | Dood
                 deriving (Show)

--
-- Een appel is een coordinaat samen 
-- met een random generator om de volgende
-- positie te genereren
--
type Appel = (Coordinaat,StdGen)

-- Tenslotte maken we een datatype Wereld dat 
-- alle informatie bevat van het snake spel 
-- 1) De slang
-- 2) De richting waarin de slang beweegt
-- 3) De tijd sinds de laatste update
-- 4) Is de slang levend of dood
-- 5) Plaats van de appel 
--
-- Merk op dat hier twee definities voor "Wereld" gegeven worden 
-- De definitie links geeft aan dat "Wereld" een nieuw type is 
-- De definitie rechts geeft aan dat Wereld een constructor is 
-- voor het type Wereld. 
--
data Wereld     = Wereld Slang Richting Float Status Appel 
                 deriving (Show)

{- Hieronder definiëren we een aantal constanten  -}

-- We stellen een richting voor door aan te duiden 
-- hoeveel vakjes er in de x en y richting moet 
-- bewogen worden (dx,dy).   
-- 
-- Hint: het assenstelsel van de gridwereld kan je
-- terugvinden in de opgave. 
--
-- (* Moeilijkheid 1 *)

links :: Richting
links = (-1,0)

rechts :: Richting 
rechts = (1,0)

boven :: Richting
boven = (0,-1)

onder :: Richting
onder = (0,1)

-- Constanten voor de grootte van het bord
breedte :: Int
breedte = 64
hoogte  :: Int 
hoogte  = 64
-- Geeft de schaal aan waarop elk vakje op het
-- scherm getekend zal worden 10x10
schaal  :: Int
schaal  = 10

-- Achtergrondkleur: R         G         B        A
nokia   = makeColor (119/255) (121/255) (100/255) 1  

-- Begin positie van de slang
startSlang :: Slang 
startSlang = [(breedte `div` 2,hoogte `div` 2)]

seed :: Int
seed = 42

-- Begin wereld 
-- Wereld = Wereld Slang Richting Float Status Appel 
startWereld :: Wereld 
startWereld = Wereld startSlang 
                    rechts 
                    0 
                    Levend 
                    ((breedte `div` 3,hoogte `div` 3),mkStdGen seed)


-- Het gloss venster om het spel te tekenen
--
venster :: Display
venster = InWindow "UGent Functioneel Programmeren Opdracht 1" 
                  (breedte *schaal, schaal * hoogte) 
                  (0,0)

-- inBox is een functie die een coordinaat neemt 
-- en een boolean teruggeeft die aangeeft of deze coordinaat 
-- binnen het bord valt 
-- (* Moeilijkheid 1 *)
inBox :: Coordinaat -> Bool
inBox (x,y) = x >= 0 && x <= breedte && y >= 0 && y < hoogte

-- Verleng een lijst gegeven de 
-- richting waarin de slang moet bewegen  
-- (* Moeilijkheid 1 *)
verleng :: Slang -> Richting -> Slang 
verleng s (x,y) = (fst (head s) + x, snd (head s) + y) : s

-- Beweeg de slang voorgesteld als een lijst van coordinaten 
-- in de gegeven richting
-- Maak *geen* gebruik van pattern matching  
-- (* Moeilijkheid 2 *)
beweeg :: Slang -> Richting -> Slang 
beweeg r = init . verleng r

-- Gegeven een lijst van coordinaten die de slang voorstelt 
-- en een andere coordinaat geef aan of deze coordinaant "botst" 
-- met de slang
-- (* Moeilijkheid 1 *)
botsingP :: [Coordinaat] -> Coordinaat -> Bool
botsingP = flip elem

--
-- Een Picture die een enkel vakje op het scherm 
-- voorstelt 
--
-- Maak gebruik van rectangleSolid om een 
-- vierkant van 10x10 te maken. 
-- 
-- Herinnering: Geen hard gecodeerde constanten. 
-- (* Moeilijkheid 2*)
vakje :: Picture 
vakje  = rectangleSolid x x
               where x = fromIntegral schaal

-- Elk vakje op het bord stellen we voor door een coordinaat
-- Deze functie coordNaarFiguur zet een coordinaat om naar een 
-- "Picture". Pictures zijn de datatypes die door de gloss 
-- bibliotheek getekend kunnen worden.  
--
-- Om deze functie te schrijven moet je eerst de documentatie 
-- van gloss lezen. Meer informatie over gloss kan je ook vragen 
-- tijdens het werkcollege.  
-- http://hackage.haskell.org/package/gloss
--
-- Hint: Maak gebruik van "vakje" en "translate" 
--       Zie ook opgave voor uitleg van het assenstelsel
-- 
-- (* moeilijkheid 3 *)
coordNaarFiguur :: Coordinaat -> Picture
coordNaarFiguur (a,b) = translate x (-y) vakje 
                       where x = fromIntegral ((a * schaal) - div (schaal * breedte) 2 + div schaal 2)
                             y = fromIntegral ((b * schaal) - div (schaal * breedte) 2 + div schaal 2)

-- coordsNaarFiguur zet een lijst van coordinaten om 
-- naar een lijst van figuren ("Pictures") 
--
-- (* Moeilijkheid 2 *)
-- Hint: dit kan je makkelijk op één lijn 
--
coordsNaarFiguur :: [Coordinaat] -> [Picture] 
coordsNaarFiguur l = [ coordNaarFiguur c | c <- l]   	

-- Nokia snake achtergrond  
box =  Color nokia (rectangleSolid schaalb schaalh)
      where schaalb = fromIntegral (schaal * breedte)
            schaalh = fromIntegral (schaal * hoogte)

-- Zet een wereld om naar een figuur
--data Wereld     = Wereld Slang Richting Float Status Appel 
maakFiguren :: Wereld -> Picture
maakFiguren (Wereld s _ _ _ a) = Pictures([box] ++ coordsNaarFiguur s ++ [coordNaarFiguur (fst a)])

-- Botsing zet een wereld om naar een nieuwe wereld 
-- maar kijk na of de slang niet met zichzelf botst 
-- en binnen het speelveld blijft. 
-- (* Moeilijkhed 2 *) 
-- Hint: Maak gebruik van guards
botsing :: Wereld -> Wereld
botsing w@(Wereld (x:xs) r f st a) 
                       | fst x == 0 || fst x == breedte || snd x == 0 || snd x == hoogte || x `elem` xs = Wereld (x:xs) r f Dood a
                       | otherwise = w

-- Genereer de volgende appel
--
-- (* Moeilijkheid 3 *)
-- type Appel = (Coordinaat,StdGen)
volgendeAppel :: Appel -> Appel
volgendeAppel ((c1,c2), gen) = ((x,y), g)
                       where (x, g1) = randomR (1,breedte) gen
                             (y, g) = randomR(1,hoogte) g1
--
-- Kijk na of de slang en de appel botsen met elkaar  
-- als ze botsen genereer de volgende appel 
--
-- (* Moeilijkheid 2 *)
botsAppel :: Slang -> Appel -> Appel 
botsAppel (x:xs) a 
                       | x == fst a = volgendeAppel a
                       | otherwise = a
-- 
-- Neem 1 stap 
-- Beweeg de slang bij elke oproep 
-- en verleng de slang na 1 seconde. 
-- (* Moeilijkheid 3 *)

stap ::  Float -> Wereld -> Wereld
stap time w@(Wereld s r f Dood a) = w
stap time w@(Wereld s r f st a) 
                       | f + time >= 1 = botsing $ Wereld (verleng (beweeg s r) r) r 0 st (botsAppel s a)
                       | otherwise = botsing $ Wereld (beweeg s r) r (f + time) st (botsAppel s a)


--
-- Hulpfunctie die nagaat of een Event 
-- een bepaalde key down event is 
-- Bijvoorbeeld:
-- isKey KeyUP (EventKey (SpecialKey KeyUp) Down  _ _ )  = True 
--
isKey k1 (EventKey (SpecialKey k2)    Down  _ _ )  = k1 == k2 
isKey _  _  = False

-- Vervolledig verwerk invoer zodat:
-- 1) de slang beweegt door op de pijltjes toetsen in te drukken
-- 2) dat het spel herbegint indien de speler dood is en op enter duwt.  
-- Hint: Maak gebruik van guards en isKey 
--
-- (* Moeilijkheidsgraad 2 *)
--
verwerkInvoer :: Event -> Wereld -> Wereld 
verwerkInvoer e w@(Wereld s r f Dood a) 
                       | isKey KeyEnter e = startWereld
                       | otherwise = w
verwerkInvoer e w@(Wereld s r f st a) 
                       | isKey KeyUp e = Wereld s boven f st a
                       | isKey KeyDown e = Wereld s onder f st a
                       | isKey KeyLeft e = Wereld s links f st a
                       | isKey KeyRight e = Wereld s rechts f st a
                       | otherwise = w

-- 
-- Start van het spel  
--
main :: IO ()
main =  play venster      white 
            10           startWereld
            maakFiguren  verwerkInvoer
            stap