{-# LANGUAGE NPlusKPatterns #-}

import Data.List
import Data.Char
import Unsafe.Coerce

data Nat = Zero
     | Succ Nat
     deriving Show

nti :: Nat -> Integer
nti = \ n -> genericLength [c | c <- show n, c == 'S']

itn 0 = Zero
itn (n+1) = Succ (itn n)


add n (Succ m) = Succ (add m n)
add n Zero = n

mult m Zero = Zero
mult m (Succ n) =  add m (mult m n)

-- data Tree = Leaf Integer
-- 		  | Node Tree Integer Tree
--
-- occurs :: Integer -> Tree -> Bool
-- occurs m (Leaf n) = m == n
-- occurs m (Node l n r)
-- 	| m == n = True
-- 	| m < n = occurs m l
-- 	| otherwise = occurs m r

data Tree = Leaf Integer
		  | Node Tree Tree

balanced :: Tree -> Bool
leaves (Leaf _) = 1
leaves (Node l r) = leaves l + leaves r
balanced (Leaf _) = True
balanced (Node l r)
	= abs (leaves l - leaves r) <= 1 && balanced l && balanced r

balance :: [Integer] -> Tree
halve xs = splitAt (length xs `div` 2) xs
balance [x] = Leaf x
balance xs = Node (balance ys) (balance zs)
	where (ys, zs) = halve xs
