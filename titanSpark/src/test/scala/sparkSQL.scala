import org.apache.spark.sql.SparkSession

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Zhao Lei
 * @Email: 1176066749@qq.com
 * @Date: 2020/7/6 
 * @Time: 10:59
 * @Version: 1.0
 * @Description:
 */
object sparkSQL {
    def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder().master("local[*]").appName("spark-sql test").enableHiveSupport().getOrCreate()

        spark.sql("use titan")
        val df = spark.sql("select line from ods_event_log where dt = '2020-07-05'")
        df.show(10)
    }
}
