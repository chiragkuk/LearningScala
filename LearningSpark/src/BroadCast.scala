import scala.io.Source
import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

/*
 *Problem statement is that we have a file at our local for list of boaring words
 *and we need to call it on each node so
 *that spark compares it with each file kept on node and filter out the words(delete the words)
 *at each node   
 */

object BroadCast extends App {
//Defining a function which returns the Set because Set is a collection of unique words
  def loadBoaringWords(): Set[String] = {
    
    //Defining the Empty set
    var boringWords: Set[String] = Set()
    
    //Reading the file from local
    val lines = Source.fromFile("D:\\BigData\\Week_10\\DataSets\\BoaringWords.txt").getLines()
    
    //Iterating each line in the file
    for (line <- lines) {
      boringWords += line
    }
    
    //Returning the set
    boringWords
  }
  //Logger for disabling the errors on the console
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Defining the Spark context rdd to define the usage of cores
  val sc = new SparkContext("local[*]", "wordcount")

  //Loading the Boaring words on each node so that words are not loaded
  var nameSet = sc.broadcast(loadBoaringWords)

  //Reading the file from the CSV format
  val initial_rdd = sc.textFile("D:\\BigData\\Week_10\\DataSets\\bigdatacampaigndata.csv")

  //Transforming map on 11th and 1st element
  val mappedInput = initial_rdd.map(x => (x.split(",")(10).toFloat, x.split(",")(0)))
  
  //Now Transforming Flatmap
  val words = mappedInput.flatMapValues(x => x.split(" "))
  
  //Again Transforming map in order to convert everything in lower case
  val finalMapped = words.map(x => (x._2.toLowerCase(), x._1))
  
  //Filtering the RDD
  val filteredRdd = finalMapped.filter(x => !nameSet.value(x._1))
  
  //Transforming reducebyKey
  val total = filteredRdd.reduceByKey(_ + _)
  
  //Transforming sortBy RDD
  val sorted = total.sortBy(x => x._2, false)
  
  //Taking action by calling take
  sorted.take(20).foreach(println)
}