package exercise1.example

import exercise1.OptionOperation
import scalaz.syntax.std.option._

class OptionOperationImpl extends OptionOperation {
  def optPlus(a: Option[Int], b: Option[Int]): Option[Int] =
    for {
      _a <- a
      _b <- b
    } yield _a + _b

  def optPlusGtTen(a: Option[Int], b: Option[Int]): Option[Int] =
    for {
      _a <- a
      _b <- b
      v = _a + _b
      if v >= 10
    } yield v

  def optPlusGtTen2(a: Option[Int], b: Option[Int]): Option[Int] =
    optPlus(a, b).flatMap { v =>
      if (v >= 10) v.some else None
    }

  def optPlusGtTen3(a: Option[Int], b: Option[Int]): Option[Int] =
    optPlus(a, b).filter(_ >= 10)

  def optPlusAsString(a: Option[Int], b: Option[Int]): Option[String] = ???
  def optDiv(a: Option[Int], b: Option[Int]): Option[Int] = ???
  def optFunc(a: Option[Int], b: Option[Int])(
      f: (Int, Int) => Int): Option[Int] = ???
}
