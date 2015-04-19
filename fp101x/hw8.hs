putStr' [] = return ()
putStr' (x : xs) = putChar x >> putStr' xs

putStrLn' [] = putChar '\n'
putStrLn' xs = putStr' xs >> putStrLn' ""

getLine' = get ""

get :: String -> IO String
get xs
    = do x <- getChar
         case x of
            '\n' -> return xs
            _ -> get (xs ++ [x])

seq_' :: Monad m => [m a] -> m ()
seq_' ms = foldr (>>) (return ()) ms

seq' :: Monad m => [m a] -> m [a]
seq' ms = foldr func (return []) ms
    where
        func :: (Monad m) => m a -> m [a] -> m [a]
        func m acc
            = do x <- m
                 xs <- acc
                 return (x : xs)

mapM' :: Monad m => (a -> m b) -> [a] -> m [b]
mapM' f [] = return []
mapM' f (a : as) =
    do b <- f a
       bs <- mapM' f as
       return (b : bs)

filterM' :: Monad m => (a -> m Bool) -> [a] -> m [a]
filterM' _ [] = return []
filterM' p (x : xs)
    = do flag <- p x
         ys <- filterM' p xs
         if flag then return (x : ys) else return ys

foldM :: (Monad m) => (a -> b -> m a) -> a -> [b] -> m a
foldM f a []       =  return a
foldM f a (x : xs) =  f a x >>= \ y -> foldM f y xs

foldrM :: Monad m => (a -> b -> m b) -> b -> [a] -> m b
foldrM f d []     = return d
foldrM f d (x:xs) = (\z -> f x z) <<= foldrM f d xs
    where (<<=) = flip (>>=)

-- liftM :: Monad m => (a -> b) -> m a -> m b
-- liftM f m = mapM f [m]
