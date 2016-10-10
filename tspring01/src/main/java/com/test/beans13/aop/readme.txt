AOP 
一、注解方式，使用步骤：
1. 在 spring 配置文件中设置要自动扫描的包，
	<!-- 配置自动扫描的包 -->
	<context:component-scan base-package="com.test.beans13.aop" use-default-filters="true"/>
2.在 spring 配置文件中设置请用aop支持。
	<!-- 启用 @aspectJ 支持 -->
	<aop:aspectj-autoproxy/>