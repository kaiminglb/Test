package com.yapai.bo;

/**
 * @author PipiLu
 * @version 创建时间：2014-6-9 下午7:20:35 类说明 工具类
 */
public class Utils {
	/**
	 * 
	 * @param value
	 * @return 浮点数 四舍五入保留2位小数 ；分位不到5 补到5，0不算
	 */
	public static float parse2P(float value) {
		int availNum = Math.round(value * 100); // 有效位数2位。如果是4位100换10000
		// 有效数位的个位<5，则改为5 否则不变
		int endPos = availNum % 10;
		if (endPos < 5 && endPos > 0) {
			availNum = availNum + 5 - endPos;
		}
		return (float) availNum / 100;
	}
}
