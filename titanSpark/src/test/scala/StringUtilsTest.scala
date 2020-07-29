import org.apache.commons.lang3.StringUtils
/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Zhao Lei
 * @Email: 1176066749@qq.com
 * @Date: 2020/7/6 
 * @Time: 15:29
 * @Version: 1.0
 * @Description:
 */
object StringUtilsTest {
    def main(args: Array[String]): Unit = {
        val a: String = "";
        val b: String = " ";
        println(StringUtils.isNotBlank(a))
        println(StringUtils.isNotBlank(b))

        println(StringUtils.isNotEmpty(a))
        println(StringUtils.isNotEmpty(b))

        println(StringUtils.isNoneBlank(a))
        println(StringUtils.isNoneBlank(b))
    }
}
