import scala.io.StdIn._

object RevString {
  
  def main (args : Array[String]){
   val input = readLine()
   //1st Output Changing the whole string literally i.e. "hello how are you" converted to "uoy era woh olleh"
   val output1= input.reverse
   println(output1)
      
   //2nd Output Changing the string in a manner that "hello how are you" converted to "olleh woh era uoy"
   val output2 = input.split(" ").map(x=>x.reverse)
   println(output2.mkString(" "))
   
   //3rd Output Changing the string in a manner that "hello how are you" converted to "you are how hello"
   val output3 = input.split(" ").reverse
   println(output3.mkString(" "))
   
  }
}