package com.iplfreaks.services.rest.impl;

import com.iplfreaks.services.api.IHelloService;
import com.iplfreaks.services.rest.api.IHelloServiceRest;

/**
 * @author dhananjayp
 *
 */
public class HelloServiceRestImpl implements IHelloServiceRest {

	private IHelloService helloService;
	
	public IHelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}

	public String handleGet(String name) {
		return this.helloService.sayHello(name);
	}

}
