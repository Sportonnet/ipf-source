package com.iplfreaks.services.rest.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/signup")
@Produces({ "application/json" })
public interface ICreateUserRestService {

	/**
	 * Rest Service to create user
	 * 
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 * @param emailId
	 *            email id
	 * @param password
	 *            password
	 * @return return true if user is created successfully else false
	 */
	@POST
	@Path("/createUser")
	public boolean createUser(@FormParam("name") String name,
			@FormParam("emailId") String emailId,
			@FormParam("password") String password);
}
