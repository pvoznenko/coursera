package week7

object week7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(102); 



  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(47); val res$0 = 
  ((1000 to 10000).toStream filter isPrime)(1);System.out.println("""res0: Int = """ + $show(res$0));$skip(63); 

  def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2);System.out.println("""secondPrime: (from: Int, to: Int)Int""");$skip(219); 
  def nthPrime(from: Int, to: Int, n: Int): Int =
    if (from >= to) throw new Error("no prime")
    else if (isPrime(from))
      if (n == 1) from else nthPrime(from + 1, to, n - 1)
    else nthPrime(from + 1, to, n);System.out.println("""nthPrime: (from: Int, to: Int, n: Int)Int""");$skip(28); val res$1 = 

  secondPrime(1000, 10000);System.out.println("""res1: Int = """ + $show(res$1));$skip(53); 

  def from(n: Int): Stream[Int] = n #:: from(n + 1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(22); 

  val nats = from(0);System.out.println("""nats  : Stream[Int] = """ + $show(nats ));$skip(30); 

  val m4s = nats map (_ * 4);System.out.println("""m4s  : scala.collection.immutable.Stream[Int] = """ + $show(m4s ));$skip(25); val res$2 = 

  (m4s take 100).toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(98); 

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(30); 
  val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(26); val res$3 = 

  (primes take 7).toList;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(189); 

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  };System.out.println("""sqrtStream: (x: Double)Stream[Double]""");$skip(95); 

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(53); val res$4 = 

  sqrtStream(0.001) filter (isGoodEnough(_, 0.001));System.out.println("""res4: scala.collection.immutable.Stream[Double] = """ + $show(res$4));$skip(43); 

  val problem = new Pouring(Vector(4, 7));System.out.println("""problem  : week7.Pouring = """ + $show(problem ));$skip(23); val res$5 = 
  problem.solutions(5);System.out.println("""res5: Stream[week7.week7.problem.Path] = """ + $show(res$5))}
}
