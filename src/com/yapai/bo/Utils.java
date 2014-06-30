package com.yapai.bo;

/**
 * @author PipiLu
 * @version ����ʱ�䣺2014-6-9 ����7:20:35 ��˵�� ������
 */
public class Utils {
	/**
	 * 
	 * @param value
	 * @return ������ �������뱣��2λС�� ����λ����5 ����5��0����
	 */
	public static float parse2P(float value) {
		int availNum = Math.round(value * 100); // ��Чλ��2λ�������4λ100��10000
		// ��Ч��λ�ĸ�λ<5�����Ϊ5 ���򲻱�
		int endPos = availNum % 10;
		if (endPos < 5 && endPos > 0) {
			availNum = availNum + 5 - endPos;
		}
		return (float) availNum / 100;
	}
}
