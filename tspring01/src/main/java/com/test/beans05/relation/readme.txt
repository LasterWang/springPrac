1.bean 配置的继承： 使用 bean的parent属性
2.模板bean ：abstract 属性
3.bean之间的依赖关系配置：depends-on 属性，指定在本bean实例化之前已经实例化的bean，
	ps.这个动作只是指定依赖关系，并没有注入动作。