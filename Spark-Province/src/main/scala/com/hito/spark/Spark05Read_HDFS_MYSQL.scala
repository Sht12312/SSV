package com.hito.spark

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

import java.util.Properties

/**
 * @Description
 * @Author Hito
 * @Date 2024/7/12
 *
 *
 */
object Spark05Read_HDFS_MYSQL {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME","root")
    val spark = new SparkSession.Builder()
      .config("dfs.client.use.datanode.hostname", "true")
      .master("local[*]")
      .appName("READ_HDFS_FILE")
      .getOrCreate()

    val df: DataFrame = spark.read
      .option("header","true")
      .csv("hdfs://bigdata1:9000/ht/base_province")

    df.show()

    val url = "jdbc:mysql://127.0.0.1:3306/store"
    val user = "root"
    val password = "root"

    df.write
      .mode(SaveMode.Overwrite)
      .jdbc(url,"base_province",new Properties(){
        {
          put("user",user)
          put("password",password)
        }
      })

    spark.stop()
  }
}
