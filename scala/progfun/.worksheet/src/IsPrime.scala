
object IsPrime {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
	def isPrime1 (n: Int): Boolean = (2 until n) forall (d => n % d != 0);System.out.println("""isPrime1: (n: Int)Boolean""")}

}
