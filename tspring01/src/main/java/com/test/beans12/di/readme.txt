泛型依赖注入
使用步骤：
1.创建两个带泛型的基类 BaseService<T> 和 BaseRepository<T>
2.【重要】在BaseService 中 创建一个 BaseRepository 属性，并在属性上使用@Autowired 注解。
3.分别创建 BaseService<T> 和 BaseRepository<T> 拥有同一泛型的子类，
	UserService extends BaseService<User> 和 UserRepository extends BaseRepository<User>，
	并将UserService 和 UserRepository 用注解注册进 IOC 容器
4.通过首字母小写id “userService” 从IOC容器获取 UserService 的bean ，
	通过调用继承自父类的方法，发现 UserRepository 类的bean 已经被注入。

	
ps.典型应用，数据库的操作，子类中可以根据传入的具体实体进行多种实现。