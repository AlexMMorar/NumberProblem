import org.scalatest.FunSuite

class DigitNumberTest extends FunSuite {

  val ERROR: Int = -1

  test("two digit number as input") {
    assert(DigitNumber.processNumber("23").getOrElse(ERROR) == 2)
  }

  test("negative two digit number as input") {
    assert(DigitNumber.processNumber("-23").getOrElse(ERROR) == 2)
  }

  test("real number with one digit") {
    assert(DigitNumber.processNumber("1.73").getOrElse(ERROR) == 1)
  }

  test("negative real number with one digit") {
    assert(DigitNumber.processNumber("-1.73").getOrElse(ERROR) == 1)
  }

  test("zero number as input") {
    assert(DigitNumber.processNumber("0").getOrElse(ERROR) == 1)
  }

  test("Integer|Float|Double maximum/minimum value") {
    assert(DigitNumber.processNumber(Int.MaxValue.toString).getOrElse(ERROR) == 10)
    assert(DigitNumber.processNumber(Int.MinValue.toString).getOrElse(ERROR) == 10)
    assert(DigitNumber.processNumber(Float.MaxValue.toString).getOrElse(ERROR) == 39)
    assert(DigitNumber.processNumber(Float.MinValue.toString).getOrElse(ERROR) == 39)
    assert(DigitNumber.processNumber(Double.MaxValue.toString).getOrElse(ERROR) == 309)
    assert(DigitNumber.processNumber(Double.MinValue.toString).getOrElse(ERROR) == 309)
  }

  test("Boolean input should give error") {
    assert(DigitNumber.processNumber(true.toString).getOrElse(ERROR) == ERROR)
    assert(DigitNumber.processNumber(false.toString).getOrElse(ERROR) == ERROR)
  }

  test("random string as input should give error") {
    assert(DigitNumber.processNumber("3123erd").getOrElse(ERROR) == ERROR)
    assert(DigitNumber.processNumber("***").getOrElse(ERROR) == ERROR)
    assert(DigitNumber.processNumber("kotr").getOrElse(ERROR) == ERROR)
    assert(DigitNumber.processNumber("2*3").getOrElse(ERROR) == ERROR)
    assert(DigitNumber.processNumber("zero").getOrElse(ERROR) == ERROR)
  }
}
