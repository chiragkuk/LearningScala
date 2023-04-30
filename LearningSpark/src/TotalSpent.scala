import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object TotalSpent extends App {

  //Logger for disabling the errors on the console
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Defining the Spark context rdd to define the usage of cores
  val sc = new SparkContext("local[*]", "wordcount")

  //Defining the File to be inputted
  val input = sc.textFile("D:/customerorders.csv")

  val mappedInput = input.map(x => (x.split(",")(0), x.split(",")(2).toFloat))

  val totalByCustomer = mappedInput.reduceByKey((x, y) => x + y)

  val sortedTotal = totalByCustomer.sortBy(x => x._2)

  val result = sortedTotal.collect

  result.foreach(println)

}