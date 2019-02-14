package exercise1

trait OptionOperation {
  def optPlus(a: Option[Int], b: Option[Int]): Option[Int]
  def optPlusGtTen(a: Option[Int], b: Option[Int]): Option[Int]
  def optPlusAsString(a: Option[Int], b: Option[Int]): Option[String]
  def optDiv(a: Option[Int], b: Option[Int]): Option[Int]
  def optFunc(a: Option[Int], b: Option[Int])(f: (Int, Int) => Int): Option[Int]
}

class YourImpl extends OptionOperation {
  def optPlus(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optPlusGtTen(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optPlusAsString(a: Option[Int], b: Option[Int]): Option[String] = ???
  def optDiv(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optFunc(a: Option[Int], b: Option[Int])(
      f: (Int, Int) => Int): Option[Int] = ???
}
