
$(document).ready(function(){
 
	$('#clickLogin').click(function () {
		
		var requestPath = '/loginAuthenticate/login/';
		var loginName = $('#username').val();
		var password = $('#password').val();
		 var url = requestPath+loginName+'/'+password;
		 console.log('requestPath = '+requestPath);
		 $.post(url,'',function(data){
			 console.log("response from userRegistration restservice "+data)	
			 if(data!=null || data!=''){
				 if(data == 'success')
					 {
					 window.location = '/loginSuccess'
					 }else{
						 	$("#login_ErrorMsg").html('Login failed.. Either email Id or password is wrong');			
							$("#login_ErrorMsg").show();
					 }
			 	}
		 });
		 
		});
	
	$('#signUp').click(function () {
		
		var requestPath = '/loginAuthenticate/signup/';
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var valid = true;
		
		var usernamesignup = $('#usernamesignup').val();
		var emailsignup = $('#emailsignup').val();
		var passwordsignup = $('#passwordsignup').val();
		var passwordsignupconfirm = $('#passwordsignup_confirm').val();
		
		$("#signUp_ErrorMsg").html('')
		$("#signUp_SuccessMsg").html('')
		if(usernamesignup == '')
			{
				$("#signUp_ErrorMsg").html('<li>username is blank </li>');			
				$("#signUp_ErrorMsg").show();
				valid = false;
			}
		if(emailsignup == '' || !emailReg.test(emailsignup))
			{
				$("#signUp_ErrorMsg").append('<li>email id is invalid</li>');			
				$("#signUp_ErrorMsg").show();
				valid = false;
			}
		if(passwordsignup == '')
			{
				$("#signUp_ErrorMsg").append('<li>password is blank </li>');			
				$("#signUp_ErrorMsg").show();
				valid = false;
			} 
		else if(passwordsignup != passwordsignupconfirm)
			{
				$("#signUp_ErrorMsg").append('<li>password does not match with confirm password </li>');			
				$("#signUp_ErrorMsg").show();
				valid = false;
			}
		if(valid)
			{
			var url = requestPath+usernamesignup+'/'+emailsignup+'/'+passwordsignup;
			 console.log('requestPath = '+requestPath);
			 $.post(url,'',function(data){
				 console.log("response from userRegistration restservice "+data)	
				 if(data!=null || data!=''){
					 
					 var jsonObj = eval( '(' +  unescape(data) + ')');
					 if(jsonObj.status == 'SUCCESS')
					 {
						 $('#usernamesignup').val('');	
						 $('#emailsignup').val('');
						 $('#passwordsignup').val('');
						 $('#passwordsignup_confirm').val('');
						 
						 $("#signUp_SuccessMsg").html('User created Successfully..');			
						 $("#signUp_SuccessMsg").show();
					 }
					 else if(jsonObj.status == 'ERROR'){
						 	$("#signUp_ErrorMsg").html(jsonObj.errorMessage);			
							$("#signUp_ErrorMsg").show();
						 }
				 	}
			 });
			}
		 
		 
		});
	
	
	});	



