package exercise1

import org.specs2.mutable.Specification
import scalaz.syntax.std.option._

class OptionOperationSpec extends Specification {
  val impl: OptionOperation = new YourImpl

  "optPlus" should {

    "両方Someなら足す" in {
      val ret = impl.optPlus(1.some, 2.some)
      ret must beSome(3)
    }
    "NoneがあったらNone(1)" in {
      val ret = impl.optPlus(None, 2.some)
      ret must beNone
    }
    "NoneがあったらNone(2)" in {
      val ret = impl.optPlus(1.some, None)
      ret must beNone
    }

  }

  "optPlusGtTen" should {

    "両方Someなら足す, 10以上ならSome" in {
      val ret = impl.optPlusGtTen(1.some, 9.some)
      ret must beSome(10)
    }
    "両方Someなら足す, 10未満ならNone" in {
      val ret = impl.optPlusGtTen(1.some, 8.some)
      ret must beNone
    }
    "NoneがあったらNone(1)" in {
      val ret = impl.optPlusGtTen(None, 2.some)
      ret must beNone
    }
    "NoneがあったらNone(2)" in {
      val ret = impl.optPlusGtTen(1.some, None)
      ret must beNone
    }

  }
}
