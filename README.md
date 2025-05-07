# order-management-system
A full-stack order management system using Spring Boot and Vue.（一个基于SpringBoot+Vue的前后端分离的订单管理系统）
前端：xxx_vue
后端：backend
数据库：xxx.sql


## 下载数据库文件，并使用SQL Server打开
打开 SSMS，连接到目标服务器。
在左侧对象资源管理器中，右键点击你要导入到的数据库（或先创建一个新数据库），选择：新建查询（New Query）
点击菜单栏中的：文件 → 打开 → 文件...
然后选择你的 .sql 文件。
点击**执行（Execute）**按钮（或按 F5）即可执行脚本。

## 使用用户名来连接数据库
## 确保sqlserver中的用户名与后端相同
在application.yml中将用户名与密码改成相同的。
## 运行后端
打开并运行com/example/demo/DemoApplication.java
## 运行前端
打开xxx_vue项目，在终端中输入npm run serve
