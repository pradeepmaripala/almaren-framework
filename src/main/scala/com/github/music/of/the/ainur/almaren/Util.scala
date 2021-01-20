package com.github.music.of.the.ainur.almaren

import org.apache.spark.sql.DataFrame

object Util {
  val spark = Almaren.spark.getOrCreate()

  import spark.implicits._

  def genDDLFromJsonString(df: DataFrame, field: String,sampleRatio : Double): String = {

    spark.read.json(df.select(field).as[String]).sample(sampleRatio).schema.toDDL
  }

  def genDDLFromDataFrame(df: DataFrame,sampleRatio : Double): String = {
    df.sample(sampleRatio).schema.toDDL
  }
}
