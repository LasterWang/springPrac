��������ע��
ʹ�ò��裺
1.�������������͵Ļ��� BaseService<T> �� BaseRepository<T>
2.����Ҫ����BaseService �� ����һ�� BaseRepository ���ԣ�����������ʹ��@Autowired ע�⡣
3.�ֱ𴴽� BaseService<T> �� BaseRepository<T> ӵ��ͬһ���͵����࣬
	UserService extends BaseService<User> �� UserRepository extends BaseRepository<User>��
	����UserService �� UserRepository ��ע��ע��� IOC ����
4.ͨ������ĸСдid ��userService�� ��IOC������ȡ UserService ��bean ��
	ͨ�����ü̳��Ը���ķ��������� UserRepository ���bean �Ѿ���ע�롣

	
ps.����Ӧ�ã����ݿ�Ĳ����������п��Ը��ݴ���ľ���ʵ����ж���ʵ�֡�