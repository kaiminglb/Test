package com.yapai.bo.beans;

import com.yapai.bo.Utils;

/**
 * @author PipiLu
 * @version 创建时间：2014-6-9 下午3:15:47 类说明 商品父类
 */
public class Product {
	private Long id;
	private boolean isimport;// 是否进口，由name中是否含"进口"判断
	private String name;
	private float basePrice; // 基本价格
	private Type type;

	// 商品类型 枚举

	public Product() {
	}

	/**
	 * 构造函数
	 * 
	 * @param name
	 *            商品名称
	 * @param basePrice
	 *            基础价格
	 */
	public Product(String name, float basePrice, Type type) {
		this.name = name;
		this.basePrice = basePrice;
		this.type = type;
		if (this.name.contains("进口")) {
			this.setIsimport(true);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getIsimport() {
		return isimport;
	}

	public void setIsimport(boolean isimport) {
		this.isimport = isimport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * 
	 * @return 返回 销售价格 ：SalePrice = basePrice + tax，显示销售价格需四舍五入，汇总不用它损失精度
	 */
	public float getSalePrice() {
		return  Utils.parse2P(basePrice + getSaleTax());
	}

	/**
	 * 
	 * @return 返回：销售税tax = 基本税 + 进口税  这不用四舍五入，后面还要汇总不然损失精度
	 */
	public float getSaleTax() {
		float tax = 0f;
		float baseTax, importTax;
		if (type == Type.BOOK || type == Type.FOOD || type == Type.MEDICINE) {// 判断是否免除基本税
			baseTax = 0f;
		} else {// 不免税
			baseTax = basePrice * 0.1F;
		}
		if (isimport) {// 进口
			importTax = basePrice * 0.05F;
		} else {
			importTax = 0;
		}
		tax = baseTax + importTax;
//		tax = (float)(Math.round(tax * 100)) / 100;// 四舍五入保留2位小数    int/100 结果仍然是int型，所以要先转换
		return tax;
	}
}
