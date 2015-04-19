tw _ [] = []
tw p (x:xs)
 | p x = x : tw p xs
 | otherwise = []

dw _ [] = []
dw p (x : xs)
  | p x = dw p xs
  | otherwise = x : xs


unfold p h t x
  | p x = []
  | otherwise = h x : unfold p h t (t x)

type Bit = Int

chop8 :: [Bit] -> [[Bit]]
chop8 [] = []
chop8 bits = take 8 bits : chop8 (drop 8 bits)
