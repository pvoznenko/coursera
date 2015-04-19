package week7

object week7 {



  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
  ((1000 to 10000).toStream filter isPrime)(1)    //> res0: Int = 1013

  def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2)
                                                  //> secondPrime: (from: Int, to: Int)Int
  def nthPrime(from: Int, to: Int, n: Int): Int =
    if (from >= to) throw new Error("no prime")
    else if (isPrime(from))
      if (n == 1) from else nthPrime(from + 1, to, n - 1)
    else nthPrime(from + 1, to, n)                //> nthPrime: (from: Int, to: Int, n: Int)Int

  secondPrime(1000, 10000)                        //> res1: Int = 1013

  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]

  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)

  val m4s = nats map (_ * 4)                      //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)

  (m4s take 100).toList                           //> res2: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100, 104, 108, 112, 116, 120, 12
                                                  //| 4, 128, 132, 136, 140, 144, 148, 152, 156, 160, 164, 168, 172, 176, 180, 184
                                                  //| , 188, 192, 196, 200, 204, 208, 212, 216, 220, 224, 228, 232, 236, 240, 244,
                                                  //|  248, 252, 256, 260, 264, 268, 272, 276, 280, 284, 288, 292, 296, 300, 304, 
                                                  //| 308, 312, 316, 320, 324, 328, 332, 336, 340, 344, 348, 352, 356, 360, 364, 3
                                                  //| 68, 372, 376, 380, 384, 388, 392, 396)

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
  val primes = sieve(from(2))                     //> primes  : Stream[Int] = Stream(2, ?)

  (primes take 7).toList                          //> res3: List[Int] = List(2, 3, 5, 7, 11, 13, 17)

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }                                               //> sqrtStream: (x: Double)Stream[Double]

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001    //> isGoodEnough: (guess: Double, x: Double)Boolean

  sqrtStream(0.001) filter (isGoodEnough(_, 0.001))
                                                  //> res4: scala.collection.immutable.Stream[Double] = Stream(0.0316227824507010
                                                  //| 5, ?)

  val problem = new Pouring(Vector(4, 7))         //> problem  : week7.Pouring = week7.Pouring@7745c859
  problem.solutions(5)                            //> res5: Stream[week7.week7.problem.Path] = Stream(Fill(0) Pour(0,1) Fill(0) P
                                                  //| our(0,1) Empty(1) Pour(0,1) Fill(0) Pour(0,1)--> Vector(0, 5), ?)
}