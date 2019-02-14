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

  def optPlusGeTenAsTwiceString(a: Option[Int],
                                b: Option[Int]): Option[String] =
    (for {
      _a <- a
      _b <- b
      v = _a + _b
    } yield {
      if (v >= 10) v * 2 else v
    }).map { _.toString }

  def optPlusGeTenAsTwiceString2(a: Option[Int],
                                 b: Option[Int]): Option[String] =
    optPlus(a, b).collect {
      case v if v >= 10 => (v * 2).toString
      case v            => v.toString
    }

  def optDiv(a: Option[Int], b: Option[Int]): Option[Int] =
    for {
      _a <- a
      _b <- b
      if _b > 0
    } yield _a / _b

  import scala.util.control.Exception._
  def optDiv2(a: Option[Int], b: Option[Int]): Option[Int] =
    for {
      _a <- a
      _b <- b
      v <- allCatch opt { _a / _b }
    } yield v

  def optFunc(a: Option[Int], b: Option[Int])(
      f: (Int, Int) => Int): Option[Int] =
    for {
      _a <- a
      _b <- b
    } yield f(_a, _b)

  override def optFunc2(a: Option[Double], b: Option[String])(
      f1: Double => Option[Int],
      f2: String => Option[Int],
      op: (Int, Int) => Int): Option[Int] =
    for {
      _a <- a
      ai <- f1(_a)
      _b <- b
      bi <- f2(_b)
    } yield op(ai, bi)

}
