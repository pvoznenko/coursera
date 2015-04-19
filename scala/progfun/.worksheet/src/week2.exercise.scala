package week2

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
val s = Seq("as" -> Seq(1));System.out.println("""s  : Seq[(String, Seq[Int])] = """ + $show(s ));$skip(46); 


  println("Welcome to the Scala worksheet");$skip(192); 

  def factorial(n: Int): Int = {
    //if (n == 0) 1 else n * factorial(n - 1)
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)

    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(16); val res$0 = 

  factorial(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(71); 

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(15); val res$1 = 

  gcd(21, 14);System.out.println("""res1: Int = """ + $show(res$1))}
}
