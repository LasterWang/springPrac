һ��ʹ��springע��
1.����bean
2.װ��bean
3.����bean��ϵ

���� ���裺
1.���ɨ������
2.��ʵ������ʹ��ע����,��Ҫ����У� component��repository��controller��service

��������bean��ϵ
1. ʹ�� autowired ���Լ������ԣ�UserController�������췽�����вεķ����ϣ�UserService��������ƥ�����ͣ�
	a.���һ�������ж��ʵ�֣�����ƥ�������ͺ�ƥ����������(����ĸСд������)��
	b.��������������ƥ���⣬������ʹ����autowired���е�ע�� @Qualifier("userRepository")(����ĸСд������)��ָʾʹ�õľ�������bean
	c.Ҳ����ʹ��autowired ��required����������Ϊfalse��ʾ�Ǳ�������޴�beanʱ��Ϊnull��