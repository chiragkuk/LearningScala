import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
object AppearanceOfNumber {
  def main(args: Array[String]) = {
    //Taking a Counter as 0 i.e. assuming the counter as 0
    var count: Int = 0

    //Taking the input of number from user in Array format where 0th place tell the number by user and 1st place tell the number to find by user
    val inputInteger: String = readLine()
    val inputIntegerArr: Array[Int] = inputInteger.split(" ").map(x => x.toInt)

    /*Running down the logic while the value inputted by user is Greater than 10 then take the remainder of the inputted value and dividing it by
    10 to get the modulus. After that 1st place of Array to compare the remainder and to increase the count and dividing the element by 10 to iterate
    the number and finally getting the count */

    while (inputIntegerArr(0) > 0) {
      var remainder = inputIntegerArr(0) % 10
      if (remainder == inputIntegerArr(1)) {
        count = count + 1
      }
      inputIntegerArr(0) = inputIntegerArr(0) / 10;
    }
    print(count);
  }
}