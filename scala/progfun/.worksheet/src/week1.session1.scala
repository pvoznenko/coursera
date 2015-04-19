package week1

object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(35); val res$0 =  //]]> gcd: (a: Int, b: Int)Int

  gcd(21, 14) //]]> res1: Int = 7;System.out.println("""res0: Int = """ + $show(res$0))}
}
