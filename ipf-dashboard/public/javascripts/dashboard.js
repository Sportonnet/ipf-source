
var fixtures = '';
var leagueName = '';

$(document).ready(function () {

    $("#Bck_Mth_Lst").click(function () {

        $("#allfixtures").show();
        $("#fixturedetails").hide();
        $("#maxRun").text('Drag Player here');
        $("#maxWct").text('Drag Player here');
        $("#MofM").text('Drag Player here');
    });

    $("#submitRes").click(function () {

        alert($("#maxRun").text());
        alert($("#maxWct").text());

    });

    $(".header1").click(function () {

        $header = $(this);
        //getting the next element
        $content = $header.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $content.slideToggle(500, function () {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
        });

    });

    $(".header2").click(function () {

        $header = $(this);
        //getting the next element
        $content = $header.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $content.slideToggle(500, function () {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
        });

    });
    
    $(".header3").click(function () {

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
    	leagueName = 'myt20';
        populateFixtures('present');
    });
    
    $(".home").click(function (e) {

    	$("#allfixtures").hide();
    	$("#fixturedetails").hide();
    });

});

function dragStart(ev) {
    ev.dataTransfer.effectAllowed = 'move';
    ev.dataTransfer.setData("playerName", ev.target.getAttribute('id'));
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
    ev.target.removeChild(ev.target.childNodes[0]);
    ev.target.appendChild(document.getElementById(src).cloneNode(true));
    ev.stopPropagation();
    return false;
}

function populateFixtures(type) {
    $('#match_details').empty();
    $('#match_details').append('<tr><td style="padding:7px 10px;" >Sr No.</td><td style="padding:7px 30px;" >Matches</td><td style="padding:7px 30px;" >Location</td><td style="padding:7px 10px;" >Action</td></tr>');
    
    var url = '/getFixturesDetails/'+leagueName+'/'+type;
    $.getJSON(url, function (response) {
    	fixtures = response.result.FIXTURES;
    	var count = 1;
        $(fixtures).each(function (index, element) {
            $('#match_details tr:last').after('<tr><td >'+count+'</td><td>'+element.fixtureName+'</td><td>'+element.venue+'</td><td><a id = "'+count+'" href="#" onclick = "displayFixturesDetails(this);" >play</a></td></tr>');
            count++;
        });
        $("#allfixtures").show();

    }).error(function (response) {
        errorHandler(response);
    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);
        window.location = '/login';

    });
    
}

function displayFixturesDetails(ev) {
    var id = ev.id;
    var trs = $('#match_details').find('tr:eq(' + id + ')');
    var match = $.trim(trs.find('td:eq(1)').html());
    var bonusQuestion = '';
    var fixtureId = '';
    
    $(fixtures).each(function (index, element) {
    	if(match == element.fixtureName)
    		{
    		alert(match);
    		}
    });
    
    
    
    var arr = match.split('vs');
    var count = 0;
    var team1 = $.trim(arr[0]);
    var team2 = $.trim(arr[1]);
    $('.header1 span').text('');
    $('.header2 span').text('');
    $('.header3 span').text('');
    $('.header1 span').text(' ' + team1);
    $('.header2 span').text(' ' + team2);
    $('.header3 span').text(' Teams');
    var requestPath = '/getAllPlayers/';
    var url = requestPath + team1;
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
        errorHandler(response);
    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);
        window.location = '/login';

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
        errorHandler(response);
    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ', ' + error;
        console.log("jqxhr: " + jqxhr);
        console.log("Request Failed: " + err + jqxhr.status);
        window.location = '/login';

    });

    $("#allfixtures").hide();
    $("#fixturedetails").show();


}

