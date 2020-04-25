{-
in Haskell, everything is a algebraic type:


data Bool       = False   | True
data List a     = Nill    | Cons a (List a)
data Nat        = Zero    | Succ Nat
data Maybe a    = Nothing | Just a
data Eithe a b  = Left a  | Right 
data Pair  a b  = Pair a b

data Exp  = Lit Int | Add Exp Exp Mul Exp Exp
data Tree = Empty | Leaf a | Branch (Tree a) (Tree a)
data Season = Winter | Spring  | Summer | Fall
data Shape = Circle Float | Rectangle Float Float

-- Booleans 

data Bool = False | True 

not :: Bool -> Bool
not False = True
not True  = False

(&&) :: Bool -> Bool -> Bool
False && _ = False
True && q =  q
-}

-- showing booleans 

eqBool :: Bool -> Bool -> Bool 
eqBool True q = q
eqBool False q = not q
eqBool q True = q
eqBool q False = not q


-- Seasons 

data Season = Winter | Spring | Summer | Fall

next :: Season -> Season
next Winter = Spring 
next Spring = Summer
next Summer = Fall
next Fall   = Winter


eqSeason :: Season -> Season -> Bool
eqSeason Winter Winter = True
eqSeason Spring Spring = True
eqSeason Summer Summer = True 
eqSeason Fall   Fall   = True 
eqSeason x      y      = False

toInt :: Season -> Int 
toInt Winter = 0
toInt Spring = 1
toInt Summer = 2 
toInt Fall   = 2

-- u can implement esSeason and next with toInt and a function fromInt aswell 
--Shapes 


type Radius = Float 
type Width  = Float
type Heigth = Float

data Shape = Circle Radius | Rect Width Heigth

area Shape -> Float
area (Circle r) = pi * r ^2
area (Rect w h) = w * h 

-- shape eq and show 

eqShape :: Shape -> Shape -> Bool 
eqShape  (Circle r) (Circle r')  = (r == r')
eqSeason (Rect w h) (Rect w' h') = (w == w') && (h == h')
eqShape  x          y            = False

showShape :: Shape -> String 
showShape (Cirle r) = "Circle " ++ showF r
showShape (Rect w h) = "Rectangle " ++ showF w ++ " " ++ showF h 

showF :: Float -> String 
showF x | x >= 0 = show x
        | otherwise = "(" ++ show x ++ ")"


--Natural numbers

data Nat = Zero | Succ Nat

power :: Float -> Nat -> Float 
power x Zero     = 1.0
power x (Succ n) = x * power x n

add :: Nat -> Nat -> Nat
add m Zero     = m 
add m (Succ n) = Succ (add m n)

mul :: Nat -> Nat -> Nat 
mul m Zero     = Zero 
mul m (Succ n) =  add (mul n m) m 


--Lists 
data List a = Nil | Cons a (List a)

append :: List a -> List a -> List a 
append Nil         ys = ys
append (Cons x xs) ys = Cons x (append xs ys)

toList :: [a] -> List a
toList []     = Nill 
toList (x:xs) = Cons x  (toList xs)

-- Maybe

data Maybe a = Nothing | Just a

divide :: Int -> Int -> Maybe Int 
divide n 0 = Nothing
divide n m = Just (n `div` m)

power :: Maybe Int -> Int - Int 
power Nothing  n = 2 ^ n 
power (Just m) n = m ^ n 


-- Record Syntax 

data Person Person String String String Int Float String
String deriving (Show)

firstName :: Person -> String 
firstName (Person firstname _ _ _ _ _) = firstname

lastName :: Person -> String 
lastName (Person _ lastname _ _ _ _) = lastname

age :: Person -> Int 
age (Person _ _ age _ _ _) = age 

data Person {
    firstName   :: String, 
    lastName    :: String, 
    age         :: Int, 
    height      :: Float, 
    phoneNumber :: String 
    flavor      :: String 
} deriving (Show)

--TypeClasses 

class Eq a where 
    (==) :: a -> a -> Bool
    (/=) :: a -> a -> Bool 
    x == y = not (x /= y)
    x /= y = not (x == y)



data TrafficLight = Red | Yellow | Green 

instance Eq TrafficLight where 
    Red    == Red    = True
    Green  == Green  = True 
    Yellow == Yellow = True 
    _      == _      = False

instance Show TrafficLight where 
    show Red    = "Red light"
    show Green  = "Green light"
    show Yellow = "Yellow light"


--Functor 

class Functor f where 
    fmap :: (a -> b) -> f a -> f b 

--List functor

instance Functor [] where 
    fmap = map

-- Maybe functor 
instance Functor Maybe where 
    fmap f (Just x) = Just (f x)
    fmap f Nothing  = Nothing
    
-- Expression Trees

data Exp = Lit Int
         | Add Exp Exp 
         | Mul Exp Exp 

evalExp :: Exp -> Int 
eval (Lit n) = n
eval (Add e f) = evalExp e + evalExp f
eval (Mul e f) = evalExp e * evalExp f 

par :: String -> String 
par s = "(" ++ s ++ ")"


--Expression Trees Infix 

data Exp = Lit Int 
         | Exp ´Add´ Exp 
         | Exp ´Mul´ Exp 

evalExp :: Exp -> Int 
evalExp (Lit n)     = n
evalExp (e `Àdd` f) = evalExp a + evalExp f
evalExp (e `Mul` f) = evalExp e * evalExp f

showExp :: Exp -> String 
showExp (Lit n)     = show n
showExp (e `Add` f) = par (showExp e ++ "+" ++ showExp f)
showExp (e `Mul` f) = par (showExp e ++ "*" ++ showExp f)

par :: String -> String 
par s = "(" ++ s ++ ")"

--or

data Exp = Lit Int
         | Exp ´:+:´ Exp 
         | Exp ´:*:´ Exp

evalExp :: Exp -> Int 
evalExp (Lit n) = n
evalExp (e `:+:` f) = evalExp a + evalExp f
evalExp (e `:*:` f) = evalExp e * evalExp f

showExp :: Exp -> String
showExp (Lit n)     = show n
showExp (e `:+:` f) = par (showExp e ++ "+" ++ showExp f)
showExp (e `:*:` f) = par (showExp e ++ "*" ++ showExp f)





-- Propositions 
type Name = String 

data Prp = Var Name
         | F
         | T
         | Not Prp
         | Prp :|: Prp 
         | Prp :&: Prp 

showPrp :: Prp -> String 
showPrp (Var x)   = x
showPrp (F)       = "F"
showPrp (T)       = "P"
showPrp (Not p)   = par ("~" ++ showPrp p)
showPrp (p :|: q) = par (showPrp p ++ "|" ++ showPrp q)
showPrp (p :&: q) = par (showPrp p ++ "&" ++ showPrp q)


--looking up a variable 
lookUp :: Eq => a -> [(a, b)] -> a -> b
lookUp xys x = the [y | (x' , y) <- xys, x == x']
    where 
        the [x] = x 

-- Satisfiable
