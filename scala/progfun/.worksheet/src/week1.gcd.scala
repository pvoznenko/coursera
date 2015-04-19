package week1

object gcd {
  /**
   *
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(285); 

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(114); 

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = (e => e == elem);System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(184); 

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = (elem => s(elem) || t(elem));System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(193); 

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = (elem => s(elem) && t(elem));System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(185); 

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = (elem => s(elem) && !t(elem));System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(128); 

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p);System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(88); 

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(278); 

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (!p(a) && s(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(175); 

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x));System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(356); 

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = {
    def _map(i: Int, currentSet: Set): Set =
      if (i > bound) currentSet
      else if (contains(s, i)) _map(i + 1, union(currentSet, singletonSet(f(i))))
      else _map(i + 1, currentSet)

    _map(-bound, (_ => false))
  };System.out.println("""map: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(185); 

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  };System.out.println("""toString: (s: Int => Boolean)String""");$skip(117); 

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  };System.out.println("""printSet: (s: Int => Boolean)Unit""");$skip(28); 

  val s1 = singletonSet(1);System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(27); 
  val s2 = singletonSet(2);System.out.println("""s2  : Int => Boolean = """ + $show(s2 ));$skip(27); 
  val s3 = singletonSet(3);System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(19); val res$0 = 

  contains(s1, 1);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(25); 

  val s = union(s1, s2);System.out.println("""s  : Int => Boolean = """ + $show(s ));$skip(14); 
  printSet(s);$skip(17); val res$1 = 
  contains(s, 1);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(17); val res$2 = 
  contains(s, 2);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(17); val res$3 = 
  contains(s, 3);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(30); 

  val is = intersect(s1, s1);System.out.println("""is  : Int => Boolean = """ + $show(is ));$skip(15); 
  printSet(is);$skip(18); val res$4 = 
  contains(is, 1);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(18); val res$5 = 
  contains(is, 2);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(28); 

  val diff1 = diff(s1, s1);System.out.println("""diff1  : Int => Boolean = """ + $show(diff1 ));$skip(18); 
  printSet(diff1);$skip(21); val res$6 = 
  contains(diff1, 1);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(28); 

  val diff2 = diff(s1, s2);System.out.println("""diff2  : Int => Boolean = """ + $show(diff2 ));$skip(18); 
  printSet(diff2);$skip(21); val res$7 = 
  contains(diff2, 1);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(27); 

  val fs = filter(s1, s1);System.out.println("""fs  : Int => Boolean = """ + $show(fs ));$skip(15); 
  printSet(fs);$skip(18); val res$8 = 
  contains(fs, 1);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(18); val res$9 = 
  contains(fs, 2);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(37); 

  val us = union(union(s1, s2), s3);System.out.println("""us  : Int => Boolean = """ + $show(us ));$skip(15); 
  printSet(us);$skip(30); val res$10 = 
  forall(us, (x => x < 1000));System.out.println("""res10: Boolean = """ + $show(res$10));$skip(27); val res$11 = 
  forall(us, (x => x < 0));System.out.println("""res11: Boolean = """ + $show(res$11));$skip(29); val res$12 = 

  exists(us, (x => x == 3));System.out.println("""res12: Boolean = """ + $show(res$12));$skip(28); val res$13 = 
  exists(us, (x => x == 4));System.out.println("""res13: Boolean = """ + $show(res$13));$skip(31); 

  val m = map(us, x => x * 2);System.out.println("""m  : Int => Boolean = """ + $show(m ));$skip(32); 
  val diffAfterMap = diff(s, m);System.out.println("""diffAfterMap  : Int => Boolean = """ + $show(diffAfterMap ));$skip(25); 
  printSet(diffAfterMap);$skip(29); val res$14 = 

  contains(diffAfterMap, 1);System.out.println("""res14: Boolean = """ + $show(res$14))}
}
