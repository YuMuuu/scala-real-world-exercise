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
  def optPlus(a: Option[Int], b: Option[Int]): Option[Int] = {
    for {
      _a <- a
      _b <- b
    }yield _a + _b
  }

  def optPlusGtTen(a: Option[Int], b: Option[Int]): Option[Int] = optPlus(a, b).filter(_ >= 10)

  def optPlusGeTenAsTwiceString(a: Option[Int],
                                b: Option[Int]): Option[String] = {
    optPlus(a, b) collect {
      case v if v >= 10 => (v * 2).toString
      case v            => v.toString
    }
  }
  def optDiv(a: Option[Int], b: Option[Int]): Option[Int] = {
    for {
      _a <- a
      _b <- b
      if _b != 0
    }yield _a / _b
  }

  def optFunc(a: Option[Int], b: Option[Int])(
      f: (Int, Int) => Int): Option[Int] = {
    for {
      _a <- a
      _b <- b
    } yield f(_a , _b)
  }

  def optFunc2(a: Option[Double], b: Option[String])(
      f1: Double => Option[Int],
      f2: String => Option[Int],
      op: (Int, Int) => Int): Option[Int] = {
    for {
      _a <- a
      ai <- f1(_a)
      _b <- b
      bi <- f2(_b)
    } yield op(ai, bi)
  }

}
