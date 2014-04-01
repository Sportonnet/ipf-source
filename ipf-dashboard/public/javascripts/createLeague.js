
$(document).ready(function(){
 
    var counter = 2;

$(document).on('click', 'section footer a.btn-next', function(){

	var section = $(this).parent().parent();
	var completion_id = "#completion li#completed-"+$(section).attr('id');
	
	if($(section).attr('id') == "league-details")
	{
		if($('input[name="league-name"]').val() == ''){
				$("#orgStruct_ErrorMsg").html('Please enter League Name');			
				$("#orgStruct_ErrorMsg").show();
				return;
			
		}
		$("#completion li").removeClass("active");
		$(completion_id).next().addClass("active");

		$(section).addClass("closed");
		$(section).next().removeClass("closed");
		createNewLeague();
	}
	
	if($(section).attr('id') == "add-member")
	{
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var emailAddress = $("#textbox1").val();
		if(emailAddress == ''){
				$("#addMember_ErrorMsg").html('Please enter atleast one email address');			
				$("#addMember_ErrorMsg").show();
				return false;
		}
		if(!emailReg.test(emailAddress)){
			$("#addMember_ErrorMsg").html('Please enter valid email address');			
			$("#addMember_ErrorMsg").show();
			return false;
		}
		$("#completion li").removeClass("active");
		$(completion_id).next().addClass("active");

		$(section).addClass("closed");
		$(section).next().removeClass("closed");
		//createNewLeague();
	}
				
	});

	$(document).on('click', 'section footer a.btn-back', function(){
	
		var module = $(this).parent().parent();
		var completion_id = "#completion li#completed-"+$(module).attr('id');
	
		$("#completion li").removeClass("active");
		$(completion_id).prev().addClass("active");
	
		$(module).addClass("closed");
		$(module).prev().removeClass("closed");
		$("#orgStruct_ErrorMsg").hide();
	});

	$("#addButton").click(function () {  
 
		$("#addMember_ErrorMsg").hide();
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		 var emailId = "#textbox"+(counter-1);
		 var emailaddress = $(emailId).val();
		 if(!emailReg.test(emailaddress) || emailaddress == '') {
			 $("#addMember_ErrorMsg").html('Please enter valid email address');			
				$("#addMember_ErrorMsg").show();
			 return false;
		 }
		var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'emailIdDiv' + counter);
 
		newTextBoxDiv.after().html('<label>Email Id #'+ counter + ' : </label>' +
	      '<input type="text" name="textbox' + counter + 
	      '" id="textbox' + counter + '" value="" >');
 
		newTextBoxDiv.appendTo("#emailIdGroup");
		counter++;
     });
	
	 $("#removeButton").click(function () {
		 if(counter==2){
			 alert("one member is mandatory");
			 return false;
		 }   
		 counter--;
		 $("#emailIdDiv" + counter).remove();
		 
	 });
	 
	 $("#textbox1").onblur(function () {
		
		 return false;
	 });
	 
	 function createNewLeague(){
		
		 var gameName = $.trim($("#game_name").val());
		 var competetionType = $.trim($("#competetion-type").val());
		 var leagueName = $.trim($("#league-name").val());
		 /*counter--;
		 var emailIds = '';
		 for(i=0;i<counter;i++)
		   {
			 emailIds = emailIds+$.trim($("#textbox"+counter).val())+",";
		   }
		 var league = new League(gameName,competetionType,leagueName,emailIds);
		 var leagueConf = new LeagueConfigObj(league);//Vishaln changed for JSON POST change
		 var leagueConfStr= JSON.stringify(leagueConf);
		 leagueConfStr=encodeURIComponent(leagueConfStr);*/
		 
		 var requestPath = '/leagueRegistration/submitLeague/';
		 var url = requestPath+competetionType+'/'+leagueName;
		 console.log('requestPath = '+requestPath);
		 $.post(url,'',function(data){
			 console.log("response from userRegistration restservice "+data)	
			 
			 if(data!=null || data!=''){
				 
				 var jsonObj = eval( '(' +  unescape(data) + ')');
				 alert("The returned from service"+jsonObj.RestResponse.statusMessage);
				 console.log("statusmessage "+jsonObj.RestResponse.statusMessage);
				 
				 if(jsonObj.RestResponse.statusMessage == 'Operation Failed')
					{

						$("#createLeague_ErrorMsg").html('Error occured while registering the user.');			
						$("#createLeague_ErrorMsg").show();

					}
			 }
		});
	 };
	 
	 
	/* function LeagueConfigObj(user){
			this.LeagueConfig = user;

		}
	 
	 
	 function League(gameName,competetionType, leagueName, emailIds){
			this.gameName = gameName; 
			this.competetionType = competetionType;
			this.leagueName = leagueName;
			this.emailIds = emailIds;
		}*/
	 
	 

});

