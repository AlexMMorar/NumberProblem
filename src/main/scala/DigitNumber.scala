import scala.annotation.tailrec
import scala.math.abs
import scala.util.Try

object DigitNumber {

  def run(number: String): Unit = {
    processNumber(number) match {
      case Left(e) => println(e)
      case Right(v) => println(s"Number is formed using $v digits.")
    }
  }

  def processNumber(inputN: String): Either[String, Int] = {
    Try {
      calculateLength(abs(inputN.toDouble))
    } fold (
      e => Left("Invalid input. Try using a number!"),
      v => Right(v)
    )
  }

  def processNumber1(inputN: Number): Either[String, Int] = {
    Try {
      calculateLength(abs(inputN.doubleValue()))
    } fold (
      e => Left("Invalid input"),
      v => Right(v)
    )
  }

  @tailrec
  private def calculateLength(x: Double, i: Int = 1): Int =
    if (x < 10) i
    else calculateLength(x / 10, i + 1)
}
