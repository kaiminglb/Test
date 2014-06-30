package junit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yapai.bo.Utils;

/**
 * @author PipiLu
 * @version 创建时间：2014-6-9 下午7:52:33
 * 类说明  先四舍五入；分位不到5 补到5
 */
public class UtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testParse2P() {
		System.out.println(Utils.parse2P(6.333F));
		System.out.println(Utils.parse2P(6.335F));
		System.out.println(Utils.parse2P(6.383F));
		System.out.println(Utils.parse2P(0.30F));
	}

}
