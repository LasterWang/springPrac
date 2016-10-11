AOP 
一、注解方式，使用步骤：
1. 在 spring 配置文件中设置要自动扫描的包，
	<context:component-scan base-package="com.test.beans13.aop" use-default-filters="true"/>
2.在 spring 配置文件中设置请用aop支持。
	<aop:aspectj-autoproxy/>
3.编写日志切面业务类，LoggingAspect
4.在 LoggingAspect 中使用注解（ @Aspect @Component）将这个类注册进 IOC 容器，同时设置为一个切面。
5.【重要】使用注解（@Before）加入各种通知，将指定方法设置为前置或后置通知，并通过其参数设置切面。
6.为切面方法加入 JoinPoint，以便获取连接点信息。
二、切面的优先级
1.在@Aspect 注解前增加 @Order(1)注解，@Order(1) 包含的参数值越小，优先级越高，越先执行。
三、声明切入点
1.用注解 @Pointcut("xxx") 表达式方式，声明切入点。方便其他切面通知和切面调用。
2.切入点的调用代码在 ValidateAspect类中有实现。
ps.
1.后置通知、返回值通知、异常通知、环绕通知的使用方式都用注释写在切面类LoggingAspect中了。
2.一些被注释掉的代码是对应通知的另一种用法