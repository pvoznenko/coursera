import Prelude hiding ((!!))

and1 [] = True
and1 (b: bs)
  | b = b
  | otherwise = and1 bs

-- and1 [True, True, True]
-- and1 [True, False, True]

con [] = []
con (xs: xss) = xs ++ con xss

rep :: Int -> a -> [a]
rep 0 _ = []
rep n x = x : rep (n - 1) x

(!!) :: [a] -> Int -> a
(x : _) !! 0 = x
(_ : xs) !! n = xs !! (n - 1)

el :: Eq a => a -> [a] -> Bool
el _ [] = False
el x (y : ys)
  | x == y = True
  | otherwise = el x ys

mer :: Ord a => [a] -> [a] -> [a]
mer [] ys = ys
mer xs [] = xs
mer (x : xs) (y : ys)
  = if x <= y then x : mer xs (y : ys) else y : mer (x : xs) ys

let m = 2
let n = 3

m ^ 0 = 1
m ^ n = m * m ^ (n - 1)
