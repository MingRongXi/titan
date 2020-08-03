# titan数据运营系统

## 一、背景介绍

​	主营业务在线上(app/网站)进行的公司都需要针对用户的线上访问行为、消费行为、业务操作行为进行统计分析，数据挖掘！以 支撑公司的业务运营、精准画像营销、个性化推荐等，来提高业务转化率，改善公司运营效果！ 这些需求，都需要通过构建一个综合数据处理系统来支撑。

​	我们的项目主要是在学校提供的裸金属层的基础上完成资源管理层，分布式计算引擎层，作业托管层和用户逻辑层的搭建，提供具有基础的统计分析能力的大数据平台，具有良好的拓展性，可以在已完成功能的基础上添加更高级功能。

## 二、功能介绍

![image](https://img-blog.csdnimg.cn/20200729223309519.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YWJsZV96bA==,size_16,color_FFFFFF,t_70#pic_center)
## 三、架构介绍

数据采集传输：Flume、Kafka、Spark

数据存储：Mysql、HDFS

数据计算：Spark

数据可视化：Echarts

任务调度：Azkaban

元数据管理：Atlas

![image](https://img-blog.csdnimg.cn/20200729223321457.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YWJsZV96bA==,size_16,color_FFFFFF,t_70#pic_center)

## 四、效果展示

### web部分（部分）：

![image](https://img-blog.csdnimg.cn/20200729223236951.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YWJsZV96bA==,size_16,color_FFFFFF,t_70#pic_center)
![image](https://img-blog.csdnimg.cn/20200729223254840.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YWJsZV96bA==,size_16,color_FFFFFF,t_70#pic_center)

### spark任务部分：
![image](https://img-blog.csdnimg.cn/20200803212237311.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YWJsZV96bA==,size_16,color_FFFFFF,t_70#pic_center)
![image](https://img-blog.csdnimg.cn/20200729224210977.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YWJsZV96bA==,size_16,color_FFFFFF,t_70#pic_center)

## 五、代码介绍

### **titanApp**：web系统的代码，负责数据可视化

|-- titanApp 压缩为zip格式的源代码

​    |--src\main\java\edu\neu\titan\titanApp

|   |--controller     控制器包

|   |--service  业务逻辑包

|    |--impl       service实现包

|   |---dao  数据库访问包

|   |--impl dao实现包

|   |--sql sql语句包

|   |--common 公用模块包

|   |  |--beans     业务对象包

|   |  |--utils          工具包

|   |  |--constant      常量包

|   |  |--sql           数据库访问包

​    |-- src\main\resources\static

|   |--src\assets  原生资源包 

|   |--libs 官方标准库

|   |--extra-libs 额外库            模板提供

|   |--images 图片资源

|   |--scss 保存scss文件

|--src\material 保存页面html的包

|--dist

​    |--js  js文件包

​    |   |--myApp 自编写的与每个页面对应的js文件

​    |   |   |--common JS公共模块，存放工具js文件

​    |   |   |--channel 渠道分析模块对应的js包

​    |   |   |--overall概况模块对应的js包

​    |   |   |--retention 留存分析模块对应的js包

​    |   |   |--participation参与度分析模块对应的js包

​    |   |   |--terminal终端分析模块对应的js包

​    |   |   |--userAnalyse基础用户分析模块对应的js包

​    |--css css文件包（根据需求进行了在提供的基础上进行了一定修改）

### **titanSpark**：spark任务代码，负责执行数据在表之间转换的任务和数据迁移

|--tianSpark spark任务源代码

|--src/main/resource 资源文件夹，包括各种配置文件。

|-- src/main/scala 源代码文件

|   |-- cn/edu/neu/titan/titanSpark/common 公用部分包

|   |   |--conf  配置管理包

|   |   |--constan 常量管理包

|   |   |--utils 工具类包

|   |-- cn/edu/neu/titan/titanSpark/analysis 分析部分顶级包

|   |   |--base 基础表分析任务实现包

|   |   |--flow 流量表分析任务实现包

|   |   |--retention 留存表分析任务实现表

|   |   |--dim 维度表初始化包

|   |   |--apl 其他分析任务实现包

|   |   |   |--app 执行将多个任务按依赖关系串联形成的粗粒度的任务的对象包

|   |   |   |--bean 存放封装业务数据的案例类

|   |   |   |--function 其中每一个对象对应每一个定时任务

|   |   |   |--udf 存放spark-sql中使用的自定义函数（UDAF、UDTF）

|   |-- cn/edu/neu/titan/titanSpark/migrantion 迁移部分顶级包

|   |   |--baseAnalysis 包含基本统计分析结果展示表的迁移任务

|   |   |--participation 包含参与度分析结果展示表的迁移任务

|   |   |--retention 包含留存分析结果展示表的迁移任务

|   |   |--terminal 包含终端属性分析结果展示表的迁移任务

|   |   |   |--app 同analysis包内app

|   |   |   |--function 同analysis包内function

### **hive.sql**：

​	集合所需的数仓全部表的sql文件，用于部署

### **titan.sql**：

​	利用navicat工具自数据库中导出的sql文件。包含数据库结构、表结构的所有信息，可用于部署

**jobs**：

​	azkaban定时任务代码

### MockDataGenerate：

​	模拟数据生成代码

### flumeConf：

​	flume配置文件



​	



