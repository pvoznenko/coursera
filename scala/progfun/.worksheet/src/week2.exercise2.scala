package week2

object exercise2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(192); 
  def sum(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, f(a) + acc)

    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(25); val res$0 = 

  sum(x => x * x, 3, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(152); 

  def sum1(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  };System.out.println("""sum1: (f: Int => Int)(Int, Int) => Int""");$skip(39); 

  def sumCubes = sum1(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(18); val res$1 = 

  sumCubes(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(97); 

  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b);System.out.println("""sum2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(103); 

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(29); val res$2 = 

  product(x => x * x)(3, 7);System.out.println("""res2: Int = """ + $show(res$2));$skip(44); 

  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(11); val res$3 = 

  fact(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(176); 

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(92); 
  def product1(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product1: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$4 = 

  product1(x => x * x)(3, 7);System.out.println("""res4: Int = """ + $show(res$4))}
}
