import scala.io.StdIn.readInt
object LargestNum extends App {

  //Taking input from user
  var a: Int = readInt()
  var b: Int = readInt()
  var c: Int = readInt()

  //Making sure that a is greater then if will get executed
  if (a > b && a > c) {
    println(a)
  } //Making sure that b is greater then else-if will get executed
  else if (b > a && b > c) {
    println(b)
  } //Making sure that c is greater then else part will be executed
  else
    println(c)

}