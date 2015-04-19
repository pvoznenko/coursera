package TheWaterPouringProblem

// http://demonstrations.wolfram.com/WaterPouringProblem/
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(145); 
  val problem = new Pouring(Vector(4, 7));System.out.println("""problem  : TheWaterPouringProblem.Pouring = """ + $show(problem ));$skip(23); val res$0 = 
  problem.solutions(5);System.out.println("""res0: Stream[TheWaterPouringProblem.test.problem.Path] = """ + $show(res$0))}
}
