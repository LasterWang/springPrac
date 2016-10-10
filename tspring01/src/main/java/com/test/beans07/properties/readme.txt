外部属性文件的加载：
1.要导入 context 标签命名空间 
2.通过 下面方式导入properties文件
	<context:property-placeholder location="classpath:db.properties"/>
3.引用配置文件信息时采用 ${user.name} 的方式

ps 1.
这样做有个好处是在修改其他配置信息时，1.结构清晰，针对性的修改(如修改数据库信息)；2.不操作主体配置文件，防止误修改导致的混乱。

ps 2.
这个例子在pom中引入了mysql 和 c3p0 的jar文件，来支持代码的运行