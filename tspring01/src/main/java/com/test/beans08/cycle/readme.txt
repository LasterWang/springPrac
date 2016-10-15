bean生命周期管理
一、在配置文件中配置初始化及销毁方法，注意调用顺序
1.涉及到创建、使用、销毁bean的操作。
2.包含了容器的关闭操作。
二、使用bean后置处理器
1.使用步骤：a.实现自己的后置处理器 b.将后置处理器配置到容器（配置文件）中
2.bean后置处理器是针对容器中所有bean的，因此，在进行操作时要进行筛选

ps.使用后置处理器之后的方法调用顺序
   1.创建对象实例
   2.调用bean的setter系列方法
   3.将bean传递给后置处理器的 postProcessBeforeInitialization 方法
   4.调用bean 的初始化方法
   5.将bean传递给后置处理器的 postProcessAfterInitialization 方法
   6.业务中使用bean
   7.容器关闭时，调用bean的销毁方法