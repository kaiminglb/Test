package junit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yapai.bo.Utils;

/**
 * @author PipiLu
 * @version ����ʱ�䣺2014-6-9 ����7:52:33
 * ��˵��  ���������룻��λ����5 ����5
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
