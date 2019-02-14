package exercise1

trait OptionOperation {
  def optPlus(a: Option[Int], b: Option[Int]): Option[Int]
  def optPlusGtTen(a: Option[Int], b: Option[Int]): Option[Int]
  def optPlusGeTenAsTwiceString(a: Option[Int], b: Option[Int]): Option[String]
  def optDiv(a: Option[Int], b: Option[Int]): Option[Int]
  def optFunc(a: Option[Int], b: Option[Int])(f: (Int, Int) => Int): Option[Int]
  def optFunc2(a: Option[Double], b: Option[String])(
      f1: Double => Option[Int],
      f2: String => Option[Int],
      op: (Int, Int) => Int): Option[Int]
}

class YourImpl extends OptionOperation {
  def optPlus(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optPlusGtTen(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optPlusGeTenAsTwiceString(a: Option[Int],
                                b: Option[Int]): Option[String] = ???
  def optDiv(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optFunc(a: Option[Int], b: Option[Int])(
      f: (Int, Int) => Int): Option[Int] = ???
  def optFunc2(a: Option[Double], b: Option[String])(
      f1: Double => Option[Int],
      f2: String => Option[Int],
      op: (Int, Int) => Int): Option[Int] = ???

}
