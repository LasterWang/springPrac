一、spring 整合 Hibernate
主要是两方面
1、由 Spring IOC 容器来管理 Hibernate 的 SessionFactory
2、让 Hibernate 能够使用 spring 的声明式事务

二、整合步骤
1.加入hibernate
①.导入hibernate jar 支持，
		<dependency>
		    <groupId>org.hibernate</groupId>
		    <artifactId>hibernate-core</artifactId>
		    <version>4.2.4.Final</version>
		</dependency>
②.添加hibernate配置文件：hibernate.cfg.xml
	主要包括：数据源、sessionFactory、基本属性（方言、sql显示及格式化、生成数据表策略以及二级缓存等）
③.创建持久化类，及其映射文件
2.加入spring
①.导入spring jar 支持
	如pom中注释
②.在spring配置文件中配置hibernate 的 sessionFactory 和 声明式事务
3.整合