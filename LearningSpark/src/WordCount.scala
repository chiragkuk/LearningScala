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
  val words = input.flatMap(x => x.split(" "))

  //Changing the whole data in lower case if there is any upper case
  val wordsLower = input.flatMap(x => x.toLowerCase())

  //Now giving the numbers to the each word
  val wordMap = wordsLower.map(x => (x, 1))

  //Now adding all the occurences of the number
  val finalCount = wordMap.reduceByKey((a, b) => a + b)

  //Collecting the result and printing it
  finalCount.collect().foreach(println)
}