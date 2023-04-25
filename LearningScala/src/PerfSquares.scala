
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object PerfSquares {
  def main(args: Array[String]) {
    //taking number of customers as Input
    val numCustomers: Int = readInt()

    //taking second line as input of bills
    val billAmount: String  = readLine()

    var count = 0
    val billAmt: Array[Int] = billAmount.split(" ").map(x=>x.toInt)
    for (i <- billAmt) {
      val sqrt = Math.sqrt(i)
      if (sqrt.ceil - sqrt == 0) {
        count = count + 1
      }
    }
    println(count)
  }
}