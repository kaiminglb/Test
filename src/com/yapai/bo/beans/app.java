package com.yapai.bo.beans;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.yapai.bo.Utils;

/**
 * @author PipiLu
 * @version ����ʱ�䣺2014-6-9 ����4:07:26 ��˵��
 */
public class app {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product product1 = new Product("��", 12.49F, Type.BOOK);
		Product product2 = new Product("CD", 14.99F, Type.OTHER);
		Product product3 = new Product("�ɿ���", 0.85F, Type.FOOD);
		List<Product> list = new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		showList(list);
		
		
		Product product4 = new Product("�����ɿ���", 10.00F, Type.FOOD);
		Product product5 = new Product("������ˮ", 47.50F, Type.OTHER);
		List<Product> list2 = new ArrayList<Product>();
		list2.add(product4);
		list2.add(product5);
		showList(list2);
		
		Product product6 = new Product("������ˮ", 27.99F, Type.OTHER);
		Product product7 = new Product("��ˮ", 18.99F, Type.OTHER);
		Product product8 = new Product("ͷ��Ƭ", 9.75F, Type.MEDICINE);
		Product product9 = new Product("�����ɿ���", 11.25F, Type.FOOD);
		List<Product> list3 = new ArrayList<Product>();
		list3.add(product6);
		list3.add(product7);
		list3.add(product8);
		list3.add(product9);
		showList(list3);
		
		
		
	}

	private static void showList(List<Product> list) {
		float sumBasePrice = 0;
		float sumPrice = 0;
		//�ܼ�=�ۼ����ۼ۸�
		//������˰=�ܼ�-��ԭʼ�۸�
		DecimalFormat df = new DecimalFormat("0.00");  
		for (Product product : list) {
			System.out.println(product.getName() + ":" + df.format(product.getSalePrice()));
			sumBasePrice += product.getBasePrice();
			sumPrice += product.getSalePrice();
		}
		System.out.println("����˰��" + df.format(Utils.parse2P(sumPrice-sumBasePrice)));//ͳ�Ƶ�ĩβ�������⴦��
		System.out.println("�ܼۣ�" + df.format(sumPrice)); 
		System.out.println("------------------------");
	}

}
