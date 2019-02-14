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

  "optFunc" should {

    "両方Someなら関数を当てる（１）" in {
      val plusFunc = (i: Int, j: Int) => i + j
      val ret = impl.optFunc(10.some, 2.some)(plusFunc)
      ret must beSome(12)
    }
    "両方Someなら関数を当てる（２）" in {
      val ret = impl.optFunc(10.some, 2.some)(_ * _)
      ret must beSome(20)
    }
    "NoneがあったらNone(1)" in {
      val ret = impl.optFunc(None, 2.some)(_ + _)
      ret must beNone
    }
    "NoneがあったらNone(2)" in {
      val ret = impl.optFunc(1.some, None)(_ + _)
      ret must beNone
    }

  }

  "optFunc2" should {

    import scala.util.control.Exception._

    val d2i: Double => Option[Int] = d =>
      if (d > 0) d.toInt.some else None
    val s2i: String => Option[Int] = s =>
      allCatch opt {
        s.toInt
    }
    val `+`: (Int, Int) => Int = _ + _

    "aにf1, bにf2を当ててオペレーションする" in {
      val ret = impl.optFunc2(10.0.some, "2".some)(d2i, s2i, `+`)
      ret must beSome(12)
    }
    "aにf1, bにf2を当てる：f1の結果がNoneならNone" in {
      val ret = impl.optFunc2((-10.0).some, "2".some)(d2i, s2i, `+`)
      ret must beNone
    }
    "aにf1, bにf2を当てる：f2の結果がNoneならNone" in {
      val ret = impl.optFunc2(10.0.some, "a".some)(d2i, s2i, `+`)
      ret must beNone
    }
    "NoneがあったらNone(1)" in {
      val ret = impl.optFunc2(None, "2".some)(d2i, s2i, `+`)
      ret must beNone
    }
    "NoneがあったらNone(2)" in {
      val ret = impl.optFunc2(10.0.some, None)(d2i, s2i, `+`)
      ret must beNone
    }

  }

}
