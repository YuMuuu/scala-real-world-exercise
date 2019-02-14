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

  "optPlusGeTenAsTwiceString" should {

    "両方Someなら足す, 10以上なら2倍String" in {
      val ret = impl.optPlusGeTenAsTwiceString(1.some, 9.some)
      ret must beSome("20")
    }
    "両方Someなら足す, 10未満ならそのままString" in {
      val ret = impl.optPlusGeTenAsTwiceString(1.some, 8.some)
      ret must beSome("9")
    }
    "NoneがあったらNone(1)" in {
      val ret = impl.optPlusGeTenAsTwiceString(None, 2.some)
      ret must beNone
    }
    "NoneがあったらNone(2)" in {
      val ret = impl.optPlusGeTenAsTwiceString(1.some, None)
      ret must beNone
    }

  }

  "optDiv" should {

    "両方Someなら割る" in {
      val ret = impl.optDiv(10.some, 2.some)
      ret must beSome(5)
    }
    "両方Someなら割る, 0" in {
      val ret = impl.optDiv(0.some, 10.some)
      ret must beSome(0)
    }
    "両方Someなら割る, 0 div はNone" in {
      val ret = impl.optDiv(10.some, 0.some)
      ret must beNone
    }
    "NoneがあったらNone(1)" in {
      val ret = impl.optDiv(None, 2.some)
      ret must beNone
    }
    "NoneがあったらNone(2)" in {
      val ret = impl.optDiv(1.some, None)
      ret must beNone
    }

  }

}
