package service;

import service.demo.HelloService;

public class HelloServiceclient {
	public static void main(String [] args){

		HelloServiceService hss = new HelloServiceService();
		HelloService hs = hss.getHelloServicePort();
		System.out.println(hs.sayHello());
	}
}
