package week5

import com.sun.org.apache.xalan.internal.xsltc.compiler.Import

object week5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(138); 

  println("Welcome to the Scala worksheet");$skip(83); 

  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(41); val res$0 = 

  removeAt(1, List("a", "b", "c", "d"));System.out.println("""res0: List[String] = """ + $show(res$0));$skip(504); 

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
  };System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(71); 

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(14); val res$1 = 

  isPrime(5);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(13); val res$2 = 
  isPrime(6);System.out.println("""res2: Boolean = """ + $show(res$2))}
}
