package week6

object x {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(165); 
  val mnem = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""mnem  : scala.collection.immutable.Map[Char,String] = """ + $show(mnem ));$skip(97); 

  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; lrt <- str) yield lrt -> digit;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(17); val res$0 = 

  charCode('E');System.out.println("""res0: Char = """ + $show(res$0));$skip(74); 

  def wordCode(word: String): String =
    word.toUpperCase map charCode;System.out.println("""wordCode: (word: String)String""");$skip(20); val res$1 = 

  wordCode("Java");System.out.println("""res1: String = """ + $show(res$1))}
}
