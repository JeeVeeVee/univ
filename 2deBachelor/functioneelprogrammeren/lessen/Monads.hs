---- MONADS ----
{-
cloning sheep
sheep is a an algebraic datatype (what does dis mean tho)
-}

data Sheep = Sheep{
    name   :: String, 
    mother :: Maybe Sheep, 
    father :: Maybe Sheep
}

maternalGrandfather :: Sheep -> Maybe Sheep
maternalGrandfather s = case (mother s) of
                            Nothing -> Nothing
                            Just m -> father m

mothersPaternalGrandfather :: Sheep -> Maybe Sheep
mothersPaternalGrandfather s = case (mother s) of 
                                Nothing -> Nothing
                                Just m -> case (father m) of 
                                    Nothing -> Nothing
                                    Just gf -> father gf


{-
The comuter science way
comb is a combinator for sequencing operations that return Maybe
-}

comb :: Maybe a -> (a -> Maybe b) -> Maybe b
comb Nothing  _ = Nothing 
comb (Just x) f = f x


{-
previous functions but with a comb
-}

maternalGrandfather' :: Sheep -> Maybe Sheep
maternalGrandfather' s = (Just s) `comb` mother `comb` father

fathersMaternalGrandmother :: Sheep -> Maybe Sheep
fathersMaternalGrandmother s = (Just s) `comb` father `comb` mother `comb` mother

mothersPaternalGrandfather' :: Sheep -> Maybe Sheep
mothersPaternalGrandfather' s = (Just s) `comb` mother `comb` father `comb` father

-- u get the picture by now

{-
We could also do this with a class, 
our functions would look like this:
-}

class Chain m where
    comb' :: m a -> (a -> m b) -> m b
    wrap  :: a -> m a

instance Chain Maybe where 
    comb' Nothing  _ = Nothing
    comb' (Just x) f = f x
    wrap  a          = Just a 


mothersPaternalGrandfather'' :: Sheep -> Maybe Sheep
mothersPaternalGrandfather'' s = (wrap s) `comb'` mother `comb'` father `comb'` father


{-
what we have just used is called a monad, the general definition goes as follows
-}

class Monad m where
    return :: a   -> m a
    (>>=)  == m a -> (a -> m b) -> m b


-- we can use a monad for a lot of different things, the maybe monad looks like this

instance Monad Maybe where
    Nothing  >>= f = Nothing
    (Just x) >>= f = f x 
    return         = Just

    
---- COMMANDS ----

{-
printing a character
-}

--putChar :: Char -> IO()

-- u can also combine commands using >>

--(>>) :: IO() -> IO() -> IO()

-- for example: 
putChar '?' >> putChar '!'


-- if this command is called, it wont do anything
-- it is like thinking about not doing anything vs actually doing nothing 
-- wtf 

--done :: IO()

-- example
putStr :: String -> IO ()
putStr [] = done
putStr (x : xs) = putChar x >> putStr xs

