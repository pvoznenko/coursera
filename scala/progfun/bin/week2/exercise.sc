package week2

object exercise {
val s = Seq("as" -> Seq(1))                       //> s  : Seq[(String, Seq[Int])] = List((as,List(1)))


  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def factorial(n: Int): Int = {
    //if (n == 0) 1 else n * factorial(n - 1)
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)

    loop(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(4)                                    //> res0: Int = 24

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)              //> gcd: (a: Int, b: Int)Int

  gcd(21, 14)                                     //> res1: Int = 7
}