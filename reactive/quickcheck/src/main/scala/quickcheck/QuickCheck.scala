package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("min1") = forAll { a: A =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("min2") = forAll { (a: A, b: A) =>
    val min = if (a > b) b else a
    val h = insert(b, insert(a, empty))
    findMin(h) == min
  }

  property("del1") = forAll { a: A =>
    val h = deleteMin(insert(a, empty))
    isEmpty(h)
  }

  property("min_meld") = forAll { (h1: H, h2: H) =>
    val min1 = findMin(h1)
    val min2 = findMin(h2)
    val min = if (min1 > min2) min2 else min1
    val h = meld(h1, h2)

    findMin(h) == min
  }

  property("property heap, not fifo") = forAll { (a: A, b: A, c: A) =>
    def getSequence(heap: H): List[A] = {
      if(isEmpty(heap)) List()
      else findMin(heap)::getSequence(deleteMin(heap))
    }

    val h1 = insert(a, insert(b, insert(c, empty)))
    val h2 = insert(c, insert(b, insert(a, empty)))

    getSequence(h1) == getSequence(h2)
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  lazy val genHeap: Gen[H] = for {
    x <- arbitrary[A]
    h <- oneOf(const(empty), genHeap)
  } yield insert(x, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
