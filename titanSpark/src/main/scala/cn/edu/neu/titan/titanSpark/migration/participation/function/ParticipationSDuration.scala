package cn.edu.neu.titan.titanSpark.migration.participation.function

import cn.edu.neu.titan.titanSpark.common.constant.Constants
import cn.edu.neu.titan.titanSpark.migration.terminal.executeMigrate

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 张志浩 Zhang Zhihao
 * @Email: 3382885270@qq.com
 * @Date: 2020/7/19 
 * @Time: 22:19
 * @Version: 1.0
 * @Description: Description 
 */
object ParticipationSDuration {

  def main(args: Array[String]): Unit = {
    migrate()
  }

  def migrate(): Unit = {

    val dimName = "duration_range"
    val tbDurationRange = Constants.MYSQL_TABLE_DURATION_RANGE_SINGLE
    val tbTarget = Constants.MYSQL_TABLE_BASE_PARTICIPATION_DURATION_SINGLE

    val tbSource = Constants.HIVE_TABLE_ADS_FLW_DDURATION_CUBE

    val colDurationCount = "duration_count"
    val colUser = "user_num"

    // 声明需要增加的列
    val tbCols = Array((tbSource, colDurationCount))
    val colTarget = Array(colUser)
    // 执行迁移
    executeMigrate(tbCols, tbTarget, tbDurationRange, dimName, colTarget)
  }
}
