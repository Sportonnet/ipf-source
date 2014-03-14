package com.iplfreaks.services.rest.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/login")
@Produces({ "application/json" })
public interface IUserAuthenticationRestService {

	/**
	 * Rest Service to authenticate user
	 * 
	 * @param emailId
	 *            email id of the user
	 * @param password
	 *            password
	 * @return returns true if user is authenticated else false
	 */
	@POST
	@Path("/isUserAuthorized")
	public boolean isUserAuthorized(@FormParam("emailId") String emailId,
			@FormParam("password") String password);

}
