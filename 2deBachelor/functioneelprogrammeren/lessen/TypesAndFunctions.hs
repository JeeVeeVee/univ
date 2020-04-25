{-
this chapter will handle: 
- simple types
- composite types
- pattern matching 
- bindings 
- recursion
- higher order functions 
- folding

Type inference
you can access the type of a variable trough :t variable

Composite types 1

:t ('a', 'b')
('a', 'b') :: (Char, Char)

we read :: as "has type"

type variables
:t fst
fst :: (a, b) -> a
:t snd ::
(a, b) -> b


Type Classes
:t (==)
(==) :: Eq a => a -> a -> Bool

Eq is a class constraint 
to get the implentation of a type class, use :i

:i Eq
class Eq a where
    (==) :: a -> a -> Bool
    (/=) :: a -> a -> Bool

== and /= are operations

type classes /= classes 
type classes ~  interfaces

Ord      Type class -> types that can be ordered
Enum     Type class -> types that can be enumerated 
Bounded  Type class -> types that have an upper and a lower bound
Num      Type class -> types that can be used as numbers
Integral Type class -> types of whole number types
Show     Type class -> types of whose values can be represented by a string 
Read     Type class -> types whose values can be reconstructed from a string 



Pattern Matching
-}

lucky :: (Integral a) => a -> String
lucky 7 = "LUCKY NUMBER SEVEN!"

sayMe :: (Integral a) => a -> String 
sayMe 1 = "One!"
sayMe 2 = "Two!"
sayMe 3 = "Three!"
sayMe 4 = "Four!"
sayMe 5 = "Five!"
sayMe x = "Not between 1 and 5"


factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n - 1)

-- Wildcards _

first :: (a, b, c) -> a
first (x, _, _) = x

second :: (a, b, c) -> b
second (_, y, _) = y 

third :: (a, b, c) -> c
third (_, _, z) = z

-- case expressions (bah)

head' :: [a] -> a
head' [] = error "no head for empty list"
head' (x:_) = x

tell :: (Show a) => [a] -> String
tell [] = "this list is empty"
tell [x] = "this list has 1 element: " ++ show x
tell [x, y] = "this list has 2 elements: " ++ show x ++ " and " ++ show y
tell (x:y:_) = "this list has more then 3 elements"



-- Guards (if statements)

bmiTell :: (RealFloat a) => a -> String
bmiTell bmi 
    | bmi <= 18.5 = "ondergewicht matje"
    | bmi <= 25.0 = "norlmaal lichaam matje"
    | bmi <= 30.0 = "dikn"
    | otherwise   = "superdikn"

{-
-- Bindings 
    -- Where
    bmiTell2 :: (RealFloat a) => a -> a -> String
    bmiTell2 weight height
        | bmi <= 18.5 = "ondergewicht matje"
        | bmi <= 25.0 = "norlmaal lichaam matje"
        | bmi <= 30.0 = "dikn"
        | otherwise   = "superdikn"
        where bmi = weigth / height ^ 2

    bmiTell'' :: (Realfloat a) => a -> a -> String
    bmiTell'' weight height
        | bmi <= 18.5 = "ondergewicht matje"
        | bmi <= 25.0 = "norlmaal lichaam matje"
        | bmi <= 30.0 = "dikn"
        | otherwise   = "superdikn"
        where bmi                   = weigth / height ^ 2, 
              (skinny, normal, fat) = (18.5, 25.0, 30.0)

    -- let
    cylinder :: (Realfloat a) => a -> a -> a
    cylinder r h = 
        let sideArea = 2 * pi * r * h
            topArea = pi * r ^ 2
        in  sideArea + 2 * topArea
-}
-- recursie (ge weet da we ne keer fibonaci gaan doen)
fibonaci :: Int -> Int
fibonaci 0 = 1
fibonaci 1 = 1
fibonaci x = fibonaci (x - 1) + fibonaci (x - 2)


-- Higher Order Functions 
applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

-- common operations
mymap :: (a -> b) -> [a] -> [b]
mymap _ [] = []
mymap f (x:xs) = f x : map f xs

myfilter :: (a -> Bool) -> [a] -> [a]
myfilter _ [] = []
myfilter f (x:xs) | f x       = x : filter f xs
                  | otherwise = filter f xs




-- folding (dis shit big)
-- :t foldl
-- foldl : Foldable t => (b -> a -> b) -> b -> t a -> b

-- foldr : Foldable t => (a -> b -> b) -> b -> t a -> b

mysum :: (Num a) => [a] -> a
mysum xs = foldl (\acc x -> acc + x) 0 xs

