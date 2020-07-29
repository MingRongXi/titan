import cn.edu.neu.titan.titanSpark.common.utils.JsonUtils
import org.apache.hadoop.hdfs.web.JsonUtil

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Zhao Lei
 * @Email: 1176066749@qq.com
 * @Date: 2020/7/6 
 * @Time: 15:45
 * @Version: 1.0
 * @Description:
 */
object JsonUtilsTest {
    def main(args: Array[String]): Unit = {
        val sc = analysis.sc
        sc.textFile("file:///D:\\study\\运营系统项目资料\\day03\\yiee_logs\\2020-07-02\\app\\test.log").map(JsonUtils.getJSON)
                .collect().foreach(line => {
            println(line.getString("eventid"))
            println(line.getJSONObject("event"))


        })

    }

}
