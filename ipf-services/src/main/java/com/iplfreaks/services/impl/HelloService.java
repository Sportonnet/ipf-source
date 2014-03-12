package com.iplfreaks.services.impl;

import com.iplfreaks.services.api.IHelloService;

public class HelloService implements IHelloService {

	public String sayHello(String name) {
		return "Hello "+name;
	}

}
