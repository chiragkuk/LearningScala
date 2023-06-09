import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object WordCount extends App {
  //Logger for disabling the errors on the console
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Defining the Spark context rdd to define the usage of cores
  val sc = new SparkContext("local[*]", "wordcount")

  //Defining the File to be inputted
  val input = sc.textFile("D:/search_data.txt.txt")

  //Performing the transition to split the whole data via space
  val words = input.flatMap(_.split(" "))

  //Changing the whole data in lower case if there is any upper case
  val wordsLower = words.map(_.toLowerCase())

  //Now giving the numbers to the each word
  val wordMap = wordsLower.map((_, 1))

  //Now adding all the occurences of the number
  val finalCount = wordMap.reduceByKey(_+_)
  
  //Sorting the Values
  
  val reversedTuple=finalCount.map(x=>(x._2,x._1))
  val sortedRes=reversedTuple.sortByKey(false).map(x=>(x._2,x._1))

  //Collecting the result and printing it
  sortedRes.collect().foreach(println)
}