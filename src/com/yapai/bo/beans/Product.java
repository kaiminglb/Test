package com.yapai.bo.beans;

import com.yapai.bo.Utils;

/**
 * @author PipiLu
 * @version ����ʱ�䣺2014-6-9 ����3:15:47 ��˵�� ��Ʒ����
 */
public class Product {
	private Long id;
	private boolean isimport;// �Ƿ���ڣ���name���Ƿ�"����"�ж�
	private String name;
	private float basePrice; // �����۸�
	private Type type;

	// ��Ʒ���� ö��

	public Product() {
	}

	/**
	 * ���캯��
	 * 
	 * @param name
	 *            ��Ʒ����
	 * @param basePrice
	 *            �����۸�
	 */
	public Product(String name, float basePrice, Type type) {
		this.name = name;
		this.basePrice = basePrice;
		this.type = type;
		if (this.name.contains("����")) {
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
	 * @return ���� ���ۼ۸� ��SalePrice = basePrice + tax����ʾ���ۼ۸����������룬���ܲ�������ʧ����
	 */
	public float getSalePrice() {
		return  Utils.parse2P(basePrice + getSaleTax());
	}

	/**
	 * 
	 * @return ���أ�����˰tax = ����˰ + ����˰  �ⲻ���������룬���滹Ҫ���ܲ�Ȼ��ʧ����
	 */
	public float getSaleTax() {
		float tax = 0f;
		float baseTax, importTax;
		if (type == Type.BOOK || type == Type.FOOD || type == Type.MEDICINE) {// �ж��Ƿ��������˰
			baseTax = 0f;
		} else {// ����˰
			baseTax = basePrice * 0.1F;
		}
		if (isimport) {// ����
			importTax = basePrice * 0.05F;
		} else {
			importTax = 0;
		}
		tax = baseTax + importTax;
//		tax = (float)(Math.round(tax * 100)) / 100;// �������뱣��2λС��    int/100 �����Ȼ��int�ͣ�����Ҫ��ת��
		return tax;
	}
}
