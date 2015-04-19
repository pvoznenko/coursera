import Data.Char

factors n = [x | x <- [1 .. n], n `mod` x == 0]

find :: (Eq a) => a -> [(a, b)] -> [b]
find k t = [v | (k', v) <- t, k == k']

divides :: Int -> Int -> Bool
divides x y = x `mod` y == 0

char2int :: Char -> Char -> Int
char2int c cr = ord c - ord cr

let2int :: Char -> Int
let2int c = char2int c 'a'

int2char :: Int -> Char -> Char
int2char l c = chr (ord c + l)

int2let :: Int -> Char
int2let n = int2char n 'a'

upp2int :: Char -> Int
upp2int c = char2int c 'A'

int2upp :: Int -> Char
int2upp l = int2char l 'A'

shiftchar :: (Int -> Char) -> (Char -> Int) -> Int -> Char -> Char
shiftchar i2c c2i n c = i2c ((n + c2i c) `mod` 26)

shift :: Int -> Char -> Char
shift n c
  | isLower c = shiftchar int2let let2int n c
  | isUpper c = shiftchar int2upp upp2int n c
  | otherwise = c

encode :: Int -> String -> String
encode n xs = [shift n x | x <- xs]
