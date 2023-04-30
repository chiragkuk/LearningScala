import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object RatingsCalculator extends App {
  
  //Logger for disabling the errors on the console
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Defining the Spark context rdd to define the usage of cores
  val sc = new SparkContext("local[*]", "wordcount")

  val input = sc.textFile("D:/moviedata.data")

  //Performing the transition to split the whole data via space
  val mappedInput = input.flatMap(_.split("\t")(2))
  val ratings = mappedInput.map((_,1))
  val reducedRatings= ratings.reduceByKey(_+_)
  val localResult= reducedRatings.collect
  localResult.foreach(println)
}