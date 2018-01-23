package service;

import junit.framework.Assert;

import org.junit.Test;
import service.demo.HelloService;

public class HellowServiceTest {

	@Test
	public void test() {
		HelloServiceService hss = new HelloServiceService();
		HelloService hs = hss.getHelloServicePort();
		String rs = hs.sayHello();

		System.out.println(rs);
		Assert.assertNotNull(rs);
		Assert.assertEquals("hello", rs);
	}

}
