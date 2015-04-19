package week5

import com.sun.org.apache.xalan.internal.xsltc.compiler.Import

object week5 {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]

  removeAt(1, List("a", "b", "c", "d"))           //> res0: List[String] = List(a, c, d)

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil =>
          ys
        case x :: xs1 =>
          ys match {
            case Nil =>
              xs
            case y :: ys1 =>
              if (x < y) x :: merge(xs1, ys)
              else y :: merge(xs, ys1)
          }
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: (xs: List[Int])List[Int]

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean

  isPrime(5)                                      //> res1: Boolean = true
  isPrime(6)                                      //> res2: Boolean = false
}