一、使用spring注解
1.配置bean
2.装配bean
3.配置bean关系

二、 步骤：
1.组件扫描配置
2.在实体类中使用注解标记,主要标记有： component、repository、controller、service

三、配置bean关系
1. 使用 autowired 可以加在属性（UserController）、构造方法或有参的方法上（UserService），用来匹配类型，
	a.如果一个类型有多个实现，会在匹配完类型后匹配属性名称(首字母小写的名称)。
	b.除了用属性名称匹配外，还可以使用与autowired并列的注解 @Qualifier("userRepository")(首字母小写的名称)来指示使用的具体类型bean
	c.也可以使用autowired 的required参数设置其为false表示非必须项，则当无此bean时置为null。