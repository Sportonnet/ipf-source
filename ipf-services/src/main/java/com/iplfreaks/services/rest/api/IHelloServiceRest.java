package com.iplfreaks.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("say")
public interface IHelloServiceRest {

	@GET
	@Path("hello/{name}")
	public String handleGet(@PathParam("name") String name);
}
