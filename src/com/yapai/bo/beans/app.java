package com.yapai.bo.beans;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.yapai.bo.Utils;

/**
 * @author PipiLu
 * @version 创建时间：2014-6-9 下午4:07:26 类说明
 */
public class app {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product product1 = new Product("书", 12.49F, Type.BOOK);
		Product product2 = new Product("CD", 14.99F, Type.OTHER);
		Product product3 = new Product("巧克力", 0.85F, Type.FOOD);
		List<Product> list = new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		showList(list);
		
		
		Product product4 = new Product("进口巧克力", 10.00F, Type.FOOD);
		Product product5 = new Product("进口香水", 47.50F, Type.OTHER);
		List<Product> list2 = new ArrayList<Product>();
		list2.add(product4);
		list2.add(product5);
		showList(list2);
		
		Product product6 = new Product("进口香水", 27.99F, Type.OTHER);
		Product product7 = new Product("香水", 18.99F, Type.OTHER);
		Product product8 = new Product("头疼片", 9.75F, Type.MEDICINE);
		Product product9 = new Product("进口巧克力", 11.25F, Type.FOOD);
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
		//总价=累加销售价格
		//总销售税=总价-总原始价格
		DecimalFormat df = new DecimalFormat("0.00");  
		for (Product product : list) {
			System.out.println(product.getName() + ":" + df.format(product.getSalePrice()));
			sumBasePrice += product.getBasePrice();
			sumPrice += product.getSalePrice();
		}
		System.out.println("销售税：" + df.format(Utils.parse2P(sumPrice-sumBasePrice)));//统计的末尾不做特殊处理
		System.out.println("总价：" + df.format(sumPrice)); 
		System.out.println("------------------------");
	}

}
