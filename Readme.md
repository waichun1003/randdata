#### 技术架构：

1. 基于前后端分离开发的web应用，springboot微服务+VUE前端技术+springMVC+spring+mybatisPlus。

2. 采用SQLite数据库。

3. 采用swagger做为接口文档（详见《接口说明》）。

4. 引入faker

5. 引入JSoup抓取行政区域数据。

#### 设计原则

1. 部署简单

2. 操作简单

3. 中国式数据格式

4. 单机运行，数据不联机存储（这样意味着一更新程序原先的数据就不存在了）

5. 生成数据不冗余，每次生成的数据都不一样。

6. 生成的数据可直接插入到数据库或程序测试等。

   #### 代码导入

     直接用STS(eclipse)导入即可，

     步骤：a.File->Import

   ​              b.Maven->Existing Maven Projects

   ​              c.选择已下载文件夹的pom.xml即可

   #### 联系方式

   QQ：449280292(验证注明：测试数据制造神器)

   或邮箱:chenlinux@sohu.com