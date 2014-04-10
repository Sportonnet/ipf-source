$(document).ready(function () {

	var counter = 2;


	$(document).on('click', 'section footer a.btn-next', function () {

		var section = $(this).parent().parent();
		var completion_id = "#completion li#completed-" + $(section).attr('id');

		if ($(section).attr('id') == "league-details") {
			if ($('input[name="league-name"]').val() == '') {
				$("#orgStruct_ErrorMsg").html('Please enter League Name');
				$("#orgStruct_ErrorMsg").show();
				return;

			}
			createNewLeague(completion_id, section);
		}

		if ($(section).attr('id') == "add-member") {
			var isErrorMsgPresent = true;
			$("div.emailDiv > input").each(function (i) {
				var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
				var emailAddress = $(this).val();

				//alert("Email Address on Next" + emailAddress);
				if (emailAddress == '') {
					//alert("Inside Error");
					$("#addMember_ErrorMsg").html('Please enter email address');
					$("#addMember_ErrorMsg").show();
					isErrorMsgPresent = false;
					return false;
				}
				if (!emailReg.test(emailAddress)) {
					$("#addMember_ErrorMsg").html('Please enter valid email address');
					$("#addMember_ErrorMsg").show();
					isErrorMsgPresent = false;
					return false;
				}
			});
			if (isErrorMsgPresent == true) {
				$("#completion li").removeClass("active");
				$(completion_id).next().addClass("active");

				$(section).addClass("closed");
				$(section).next().removeClass("closed");
				addMember();
			}
		}
		
	});

	$(document).on('click', 'section footer a.btn-back', function () {

		var module = $(this).parent().parent();
		var completion_id = "#completion li#completed-" + $(module).attr('id');

		$("#completion li").removeClass("active");
		$(completion_id).prev().addClass("active");

		$(module).addClass("closed");
		$(module).prev().removeClass("closed");
		$("#orgStruct_ErrorMsg").hide();
	});

	$("#addButton").click(function () {

		$("#addMember_ErrorMsg").hide();
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var emailId = "#textbox" + (counter - 1);
		var emailaddress = $(emailId).val();
		if (!emailReg.test(emailaddress) || emailaddress == '') {
			$("#addMember_ErrorMsg").html('Please enter valid email address');
			$("#addMember_ErrorMsg").show();
			return false;
		}

		var html = '';
		html += '<label>Email Id #' + counter + ' : </label>' + '<input type="text" name="textbox' + counter + '" id="textbox' + counter + '" value="" >';

		$("#emailIdDiv1").append(html);
		counter++;
	});

	$("#removeButton").click(function () {
		if (counter == 2) {
			//alert("one member is mandatory");
			return false;
		}
		counter--;
		$("#emailIdDiv" + counter).remove();

	});

	$("#textbox1").onblur(function () {

		return false;
	});

	function createNewLeague(completion_id, section) {

		var competitionSport = $.trim($("#game_name").val());
		var competitionName = $.trim($("#competetion-type").val());
		var leagueName = $.trim($("#league-name").val());
		
		
		var requestPath = '/leagueRegistration/submitLeague/';
		var url = requestPath + competitionName + '/' + leagueName + '/' + competitionSport;
		console.log('requestPath = ' + url);
		$.post(url, '', function (data) {
			console.log("response from createLeague restservice " + data)

			if (data != null || data != '') {

				
				var jsonObj = eval('(' + unescape(data) + ')');
				//alert("The returned from service"+jsonObj.status);
				console.log("status " + jsonObj.status);

				if (jsonObj.status == 'ERROR') {
					var statusMessage = jsonObj.errorMessage;
					console.log("statusMessage " + jsonObj.errorMessage);
					$("#orgStruct_ErrorMsg").html(statusMessage);
					$("#orgStruct_ErrorMsg").show();

				}else{
					$("#completion li").removeClass("active");
					$(completion_id).next().addClass("active");
		
					$(section).addClass("closed");
					$(section).next().removeClass("closed");
				}
			}


		});
	};

	function addMember() {
		//alert("In Addmember");
		var arr = new Array();

		$("div.emailDiv > input").each(function (i) {
			var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
			var emailaddress = $(this).val();
			console.log("EmailAddress" + emailaddress);
			if (!emailReg.test(emailaddress) || emailaddress == '') {
				$("#addMember_ErrorMsg").html('Please enter valid email address');
				$("#addMember_ErrorMsg").show();
				return false;
			} else {
				if (emailaddress != '') {
					console.log('arr...' + arr);
					arr.push(emailaddress);
				} else {
					arr = '';
				}
				console.log(i + ": " + $(this).val());

			}
		});
		console.log("Email Array" + JSON.stringify(arr));
		var challengers = JSON.stringify(arr);
		challengersEncoded = encodeURIComponent(challengers);
		var requestPath = '/leagueRegistration/addChallengersToLeague/';
		var url = requestPath + challengersEncoded;
		console.log('requestPath = ' + url);
		$.post(url, '', function (data) {
			console.log("response from AddChallengers restservice " + data)

			if (data != null || data != '') {

				// alert('data is '+data);
				var jsonObj = eval('(' + unescape(data) + ')');
				alert(jsonObj);
				//alert("The returned from service"+jsonObj.status);
				console.log("status " + jsonObj.status);
				if(jsonObj.status=='SUCCESS'){
					var pendingChngers = jsonObj.result.PENDING_CHALLENGERS;
					$("#pendingChallengerList").html('The following Challengers could not be added to the league.<br>');
					 $(pendingChngers).each(function(index, element) {
						 $("#pendingChallengerList").append('<li>'+element.user.email+'</li>');
						 console.log('The element is '+element.user.email);
					 });

					
				 }

				if (jsonObj.status == 'Operation Failed') {

					$("#addMember_ErrorMsg").html('Error occured while registering the user.');
					$("#addMember_ErrorMsg").show();

				} 
				
				if(jsonObj.RestResponse != null && jsonObj.RestResponse.statusMessage !=null){

					console.log("statusmessage " + jsonObj.RestResponse.statusMessage);
					var statusmessage = jsonObj.RestResponse.statusMessage.split(":")[1];
					console.log("statusmessage ERROR" + statusmessage);
					$("#userReg_ErrorMsg").html(statusmessage);
					$("#userReg_ErrorMsg").show();

				}
			}


		});
	};

});