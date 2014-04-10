var fixtures = '';
var leagueName = '';
var fixtureId = '';
var dateTime = '';

$(document).ready(function () {

    $("#Bck_Mth_Lst").click(function () {

        $("#allfixtures").show();
        $("#fixturedetails").hide();
        $("#scoreBoard").hide();
        $("#maxRun").text('Drag Player here');
        $("#maxWct").text('Drag Player here');
        $("#MofM").text('Drag Player here');
    });

    $("#submitRes").click(function () {

        alert($("#maxRun").text());
        alert($("#maxWct").text());

    });

    $(".header1, .header2, .header3, .header4 ").click(function () {

        $header = $(this);
        //getting the next element
        $content = $header.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $content.slideToggle(500, function () {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
        });

    });
    

    $("#future").click(function () {

        populateFixtures('future');
    });
    $("#present").click(function () {

        populateFixtures('present');
    });
    $("#past").click(function () {

        populateFixtures('past');
    });

    $(".myLeague").click(function (e) {
    	
    	 var url = '/getMyAllLeague';
    	    console.log('requestPath = ' + url);
    	    $.post(url, '', function (data) {
    	        var jsonObj = eval('(' + unescape(data) + ')');
    	        if (jsonObj.status == 'SUCCESS') {
    	            
    	        	var allLeagues = jsonObj.result.USER_LEAGUES.leagues;
    	        	$('#myAllLeague ul').empty();
    	        	$(allLeagues).each(function (index, element) {
    	                $('#myAllLeague ul').append('<li><a id = "'+element+'" href="#" onclick = "dispThisLeague(this);">'+element+'</a></li>');
    	                
    	            });
    	        } else if (jsonObj.status == 'ERROR') {
    	        }

    	    }).error(function (response) {

    	    }).fail(function (jqxhr, textStatus, error) {
    	        var err = textStatus + ', ' + error;
    	        console.log("jqxhr: " + jqxhr);
    	        console.log("Request Failed: " + err + jqxhr.status);


    	    });
    	    
        $("#myAllLeague").show();
        $("#allfixtures").hide();
        $("#fixturedetails").hide();
        $("#scoredetails").hide();
    });

    $(".home").click(function (e) {

        $("#allfixtures").hide();
        $("#fixturedetails").hide();
        $("#myAllLeague").hide();
        $("#scoredetails").hide();
    });
    
    $("#showScore").click(function () {
   	 //console.log("showScore: ");
   	//alert("In scoreDeatils");
   	   $("#allfixtures").hide();
       $("#fixturedetails").hide();
       $("#scoredetails").show();
   });
    
    $("#bckToAllFixtures").click(function () {
      	   $("#allfixtures").show();
          $("#fixturedetails").hide();
          $("#scoredetails").hide();
      });
    
    

});

function dragStart(ev) {
    ev.dataTransfer.effectAllowed = 'move';
    ev.dataTransfer.setData("playerName", ev.target.getAttribute('id'));
    ev.dataTransfer.setDragImage(ev.target, 0, 0);
    return true;
}

function dragStartTeam(ev) {
    ev.dataTransfer.effectAllowed = 'move';
    ev.dataTransfer.setData("team", ev.target.getAttribute('id'));
    ev.dataTransfer.setDragImage(ev.target, 0, 0);
    return true;
}

function dragStartBon(ev) {
    ev.dataTransfer.effectAllowed = 'move';
    ev.dataTransfer.setData("bon", ev.target.getAttribute('id'));
    ev.dataTransfer.setDragImage(ev.target, 0, 0);
    return true;
}


function dragEnter(ev) {
    event.preventDefault();
    return true;
}

function dragOver(ev) {
    return false;
}

function dragDrop(ev) {
    var src = ev.dataTransfer.getData("playerName");
    
    if(src == '')
    	{
    		return false;
    	}
    ev.target.removeChild(ev.target.childNodes[0]);
    ev.target.appendChild(document.getElementById(src).cloneNode(true));
    ev.stopPropagation();
    return false;
}

function dragDropTeam(ev) {
    var src = ev.dataTransfer.getData("team");
    if(src == '')
	{
		return false;
	}
    ev.target.removeChild(ev.target.childNodes[0]);
    ev.target.appendChild(document.getElementById(src).cloneNode(true));
    ev.stopPropagation();
    return false;
}

function dragDropBon(ev) {
    var src = ev.dataTransfer.getData("bon");
    if(src == '')
	{
		return false;
	}
    ev.target.removeChild(ev.target.childNodes[0]);
    ev.target.appendChild(document.getElementById(src).cloneNode(true));
    ev.stopPropagation();
    return false;
}

function populateFixtures(type) {
	
	$("#myAllLeague").hide();
	var view = '';
    $('#match_details').empty();
    $('#match_details').append('<tr><td style="padding:7px 10px;" >Sr No.</td><td style="padding:7px 30px;" >Matches</td><td style="padding:7px 30px;" >Location</td><td style="padding:7px 30px;" >When</td><td style="padding:7px 10px;" >Action</td></tr>');
    
    var url = '/getFixturesDetails/' + leagueName + '/' + type;
    if(type == 'past')
    	{
    	view = 'view';
    	$("#rightcolumn").hide();
    	}
    	else{
    		view = 'play';
    		$("#rightcolumn").show();
    	}
    $.getJSON(url, function (response) {
        fixtures = response.result.FIXTURES;        
        var count = 1;
        var m_names = new Array("January", "February", "March", 
        		"April", "May", "June", "July", "August", "September", 
        		"October", "November", "December");
        $(fixtures).each(function (index, element) {
        	var fixtureId = element.fixtureId;
        	dateTime = fixtureId.split('@')[1];
        	var date = dateTime.split('T')[0];
        	var time = dateTime.split('T')[1];
        	time = time.replace('Z','');
        	var formattedDate = new Date(date);
        	var curr_date = formattedDate.getDate();
        	var curr_month = formattedDate.getMonth();
        	var curr_year = formattedDate.getFullYear();
        	dateTime = curr_date + '-' + m_names[curr_month] + '-' + curr_year+', '+time;
            $('#match_details tr:last').after('<tr><td >' + count + '</td><td>' + element.fixtureName + '</td><td>' + element.venue + '</td><td>'+dateTime+'</td><td><a id = "' + count + '" href="#" onclick = "displayFixturesDetails(this);" >'+view+'</a></td></tr>');
            count++;
        });
        $("#allfixtures").show();

    }).error(function (response) {

    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);

    });

}

function displayFixturesDetails(ev) {
    var id = ev.id;
    var trs = $('#match_details').find('tr:eq(' + id + ')');
    var match = $.trim(trs.find('td:eq(1)').html());
    var bonusQuestion = '';
    var bonusAns = '';
    var venue = '';

    $(fixtures).each(function (index, element) {
        if (match == element.fixtureName) {
            fixtureId = element.fixtureId;
            bonusQuestion = element.bonus[0].bonusQuestion;
            bonusAns = element.bonus[0].options;
            venue = element.venue;
        }
    });
    $('#playGame ').html(match+'</br> <span style="font-size: 20px; font-weight: 400;">Venue</span> : '+venue+'</br> <span style="font-size: 20px; font-weight: 400;">When</span> : '+dateTime);
    var requestPath = '/getFixtureDetails/';
    var url = requestPath + leagueName + '/' + fixtureId;
    console.log('requestPath = ' + requestPath);
    $.post(url, '', function (data) {
        var response = eval('(' + unescape(data) + ')');
        var canEdit = response.result.CAN_EDIT_CHALLENGE;

        $('#fixturedetailsTable').empty();
        $('#fixturedetailsTable').append('<tr><td style="padding:7px 30px;" >Player Name</td><td style="padding:7px 30px;" >Max. Run Scorer</td><td style="padding:7px 30px;" >Max Wicket Taker</td><td style="padding:7px 30px;" >Man of the Match</td><td style="padding:7px 30px;" >Match Winner</td><td style="padding:7px 30px;" >' + bonusQuestion + '</td><td style="padding:7px 30px;" >Submit</td></tr>');

        var challengers = response.result.FIXTURE_CHALLENGES;
        var count = 1;
        $(challengers).each(function (index, element) {

            var sb = new StringBuilder();
            var predictions = element.PREDICTION;
            sb.append('<tr><td>' + element.CHALLENGER_NAME + '</td>');

            if (canEdit == true && element.CHALLENGER_EMAIL == 'hdeveliya483@gmail.com') {
                sb.append('<td><div  id = "maxRun' + count + '" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">Drag Player here</div></td>');
                sb.append('<td><div id = "maxWct' + count + '" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">Drag Player here</div></td>');
                sb.append('<td><div  id = "MofM' + count + '" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">Drag Player here</div></td>');
                sb.append('<td><div  id = "mWnr' + count + '" ondragenter="return dragEnter(event)" ondrop="return dragDropTeam(event)" ondragover="return dragOver(event)">Drag Team here</div></td>');
                sb.append('<td><div  id = "bAns' + count + '" ondragenter="return dragEnter(event)" ondrop="return dragDropBon(event)" ondragover="return dragOver(event)">Drag Bonus Ans here</div></td>');
                sb.append('<td><a href="#" id = "' + count + '" onclick = "savePrediction(this);" >Save</a></td></tr>');
                $('#fixturedetailsTable').append(sb.toString());
                if (typeof predictions !== 'undefined') {
                    if (predictions.bestBatsman.name != '') {
                        $('#maxRun' + count).text(predictions.bestBatsman.name);
                    }
                    if (predictions.bestBowler.name != '') {
                        $('#maxWct' + count).text(predictions.bestBowler.name);
                    }
                    if (predictions.manOfTheMatch.name != '') {
                        $('#MofM' + count).text(predictions.manOfTheMatch.name);
                    }
                    if (predictions.winnerTeam.name != '') {
                        $('#mWnr' + count).text(predictions.winnerTeam.name);
                    }
                    if (predictions.bonus[0].bonusAnswer != '') {
                        $('#bAns' + count).text(predictions.bonus[0].bonusAnswer);
                    }

                }
            } else {

                sb.append('<td><div  id = "maxRun"> </div></td>');
                sb.append('<td><div  id = "maxWct"> </div></td>');
                sb.append('<td><div  id = "MofM"> </div></td>');
                sb.append('<td><div  id = "mWnr"> </div></td>');
                sb.append('<td><div  id = "bAns"> </div></td>');
                sb.append('<td><div  id = "submitRes"> </div></td></tr>');
                $('#fixturedetailsTable').append(sb.toString());
                if (typeof predictions !== 'undefined' && canEdit == false) {
                    $('#maxRun' + count).text(predictions.bestBatsman.name);
                    $('#maxWct' + count).text(predictions.bestBowler.name);
                    $('#MofM' + count).text(predictions.manOfTheMatch.name);
                    $('#mWnr' + count).text(predictions.winnerTeam.name);
                    $('#bAns' + count).text(predictions.bonus[0].bonusAnswer);
                }
            }

            count++;
        });

    }).error(function (response) {
    	alert('er');
    	$('.CSSTableGenerator').text('There was some error..Pls contact Aniket..');
    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);
        $('.CSSTableGenerator').text('There was some error..Pls contact Aniket..');
    });



    var arr = match.split('vs');
    var count = 0;
    var team1 = $.trim(arr[0]);
    var team2 = $.trim(arr[1]);
    $('.header1 span').text('');
    $('.header2 span').text('');
    $('.header3 span').text('');
    $('.header4 span').text('');
    $('.header1 span').text(' ' + team1);
    $('.header2 span').text(' ' + team2);
    $('.header3 span').text(' Teams');
    $('.header4 span').text(' Bonus Ans');
    $('<div id = "team1" style="border:2px solid #ccc;" draggable="true" ondragstart="return dragStartTeam(event)"><p>' + team1 + '</p></div>').appendTo("#teams");
    $('<div id = "team2" style="border:2px solid #ccc;" draggable="true" ondragstart="return dragStartTeam(event)"><p>' + team2 + '</p></div>').appendTo("#teams");
    
    $(bonusAns).each(function (index, element) {
    	$('<div id = "bonAns'+count+'" style="border:2px solid #ccc;" draggable="true" ondragstart="return dragStartBon(event)"><p>1</p></div>').appendTo("#bonAns");
    	count++;    
    });
    count = 0;
    requestPath = '/getAllPlayers/';
    url = requestPath + team1;
    console.log('requestPath = ' + requestPath);
    $.getJSON(url, function (response) {
        $(response).each(function (index, element) {

            var players = element.players;
            $('#players1').html('');
            $(players).each(function (index1, player) {
                $('<div id = "ab' + count + '" style="border:2px solid #ccc;" draggable="true" ondragstart="return dragStart(event)"><p>' + player.name + '</p></div>').appendTo("#players1");
                count++;
            });

        });

    }).error(function (response) {

    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);


    });
    url = requestPath + team2;
    $.getJSON(url, function (response) {
        $(response).each(function (index, element) {
            var players = element.players;
            $('#players2').html('');
            $(players).each(function (index1, player) {
                $('<div id = "ab' + count + '" style="border:2px solid #ccc;" draggable="true" ondragstart="return dragStart(event)"><p>' + player.name + '</p></div>').appendTo("#players2");
                count++;
            });

        });

    }).error(function (response) {

    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);

    });

    $("#allfixtures").hide();
    $("#fixturedetails").show();


}

function savePrediction(ev) {
    var id = ev.id;
    var maxRun = $('#maxRun' + id).text();
    var maxWct = $('#maxWct' + id).text();
    var MofM = $('#MofM' + id).text();
    var mWnr = $('#mWnr' + id).text();
    var bAns = $('#bAns' + id).text();

    if (maxRun == '') {
        maxRun = 'Drag Player here';
    }
    if (maxWct == '') {
        maxWct = 'Drag Player here';
    }
    if (MofM == '') {
        MofM = 'Drag Player here';
    }
    if (mWnr == '') {
        mWnr = 'Drag Team here';
    }
    if (bAns == '') {
        bAns = 'Drag Bonus Ans here';
    }

    var requestPath = '/savePredictions/';
    var url = requestPath + fixtureId + '/' + leagueName + '/' + maxWct + '/' + maxRun + '/' + MofM + '/' + mWnr + '/' + bAns;
    console.log('requestPath = ' + url);
    $.post(url, '', function (data) {
        var jsonObj = eval('(' + unescape(data) + ')');
        if (jsonObj.status == 'SUCCESS') {
            alert('Predictions saved successfully');
        } else if (jsonObj.status == 'ERROR') {
            alert('Error while saving predictions');
        }

    }).error(function (response) {

    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);


    });
}

function dispThisLeague(ev) {
	leagueName = ev.id;
	populateFixtures('present');
}

function StringBuilder(value) {
    this.strings = new Array("");
    this.append(value);
}

// Appends the given value to the end of this instance.
StringBuilder.prototype.append = function (value) {
    if (value) {
        this.strings.push(value);
    }
}

// Clears the string buffer
StringBuilder.prototype.clear = function () {
    this.strings.length = 1;
}

// Converts this instance to a String.
StringBuilder.prototype.toString = function () {
    return this.strings.join("");
}

if(!String.prototype.startsWith){
    String.prototype.startsWith = function (str) {
        return !this.indexOf(str);
    }
}