import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object FriendsAge extends App {

  def parseLine(line: String) = {
    val fields = line.split("::")
    val age = fields(2).toInt
    val numFriends = fields(3).toInt
    (age, numFriends)
  }

  //Logger for disabling the errors on the console
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Defining the Spark context rdd to define the usage of cores
  val sc = new SparkContext("local[*]", "wordcount")

  val input = sc.textFile("D:/friendsdata.csv")

  val mappedInput = input.map(parseLine)

  val mappedFinal = mappedInput.map(x => (x._1, (x._2, 1)))

  val totalsByAge = mappedFinal.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))

  val averagesByAge = totalsByAge.map(x => (x._1, x._2._1 / x._2._2)).sortBy(x => x._2)

  averagesByAge.collect.foreach(println)

}