import scala.io.StdIn.readInt

object FibbonachiSeries extends App {

  //Taking input from user to find out that which Fibbonachi number user wants to find out
  var input: Int = readInt()

  //Assigning the first Fibbo number
  var firstNumber: Int = 0

  //Assigning the second Fibbo Number
  var secondNumber: Int = 1

  //Starting the count from 2 because we already have first 2 numbers
  var count: Int = 2

  //Now Comparing the count with input number
  while (count <= input) {

    //defining the temp variable and assigning the 2nd Fibbo Number
    var temp: Int = secondNumber

    //now adding the values over here so that it stores the value
    secondNumber = secondNumber + firstNumber

    //Now storing the value of temp in so that it adds up next time
    firstNumber = temp

    //Incrementing the count
    count = count + 1

  }

  //Printing the Fibbo Number
  print(firstNumber)
}
