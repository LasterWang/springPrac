package com.test.beans16.tx;

public interface BookShopDao {
	//������Ż�ȡ��ĵ���
	public int findBookPriceByIsbn(String isbn);
	//������Ŀ�棬ʹ��Ӧ�Ŀ���һ
	public void updateBookStock(String isbn);
	//�����û����˻���ʹ username �� balance -price
	public void updateUserAccount(String username,int price);
}
