package controllers;

import java.net.URLEncoder;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;
import views.html.index;

public class LoginController extends Controller{

	
	public static Result authenticate(String uName, String password) {

			session().put("loginName", uName);
			String requestData = "emailId="+URLEncoder.encode(uName)+"&password="+URLEncoder.encode(password);			
			String response = ServiceUtil.callPOST("/services/login/isUserAuthorized/", requestData, null, 50000);
			if("true".equalsIgnoreCase("true"))
			{
				return ok("success");
			}else{
				return ok("fail");
			}
			
		
	}
	
	public static Result signUp(String uName, String email, String password) {

		session().put("loginName", uName);
		String requestData = "name="+URLEncoder.encode(uName)+"&emailId="+URLEncoder.encode(email)+"&password="+URLEncoder.encode(password);			
		String response = ServiceUtil.callPOST("/services/signup/createUser/", requestData, null, 50000);
		if("true".equalsIgnoreCase("true"))
		{
			return ok("success");
		}else{
			return ok("fail");
		}
		
	
}
	
	public static Result goToDashboard() {

			return ok(dashboard.render());
		
	}
	
	public static Result logOut() {

		session().clear();
		return ok(index.render(""));
	
	}
	
}
