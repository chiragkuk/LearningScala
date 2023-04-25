
import scala.io.StdIn.readLine
object StrictlyLesser {
  def main(args: Array[String]) {
    //Taking Input for first Line
    val inputLine1 : String = readLine()
    //Making a Space Split so that it suffice our requirement
    val inputLine1Arr : Array[Int] = inputLine1.split(" ").map(x=>x.toInt)
    //Taking Input for Second Line
    val inputLine2 : String = readLine()
    //Splitting the second input so that Arrays of Inputs are defined
    val inputLine2Arr : Array[Int] = inputLine2.split(" ").map(x=>x.toInt)

    //Capturing the Element from which we want to Compare
    val numK = inputLine1Arr(1)
    //Capturing the Count
    var count = 0
    //Logic is that we are iterating the code for all the arrays in line 2 by "for loop" and comparing it with the captured element in "if block"
    for (i <- inputLine2) {
      if (i < numK) {
        count = count + 1;
      }
    }
    println(count)
  }
}