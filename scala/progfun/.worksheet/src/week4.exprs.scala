package week4

object exprs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(403); 
  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + " + show(r)
    case Var(x) => x
    case Prod(e1, e2) =>
      val format = (e1, e2) match {
        case (Sum(_, _), _) => "(%s) * %s"
        case (_, Sum(_, _)) => "%s * (%s)"
        case (_, _) => "%s * %s"
      }
      format.format(show(e1), show(e2))
  };System.out.println("""show: (e: week4.Expr)String""");$skip(36); val res$0 = 

  show(Sum(Number(1), Number(44)));System.out.println("""res0: String = """ + $show(res$0));$skip(49); val res$1 = 
  show(Sum(Prod(Number(2), Var("x")), Var("y")));System.out.println("""res1: String = """ + $show(res$1));$skip(49); val res$2 = 
  show(Prod(Sum(Number(2), Var("x")), Var("y")));System.out.println("""res2: String = """ + $show(res$2))}
}
