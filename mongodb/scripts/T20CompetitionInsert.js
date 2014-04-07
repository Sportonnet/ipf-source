db = connect("localhost:27017/sports_on_net_1", "gambler", "gambler");

db.cricketCompetition.insert({"name":"T20 World Cup 2014", "sport":"Cricket", "season":"T20 2014", "isActive":true});
db.cricketCompetition.update({"name":"T20 World Cup 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Australia vs England",
						"fixtureId" : "Australia vs England @ 2014-04-05T19:00:00Z",
                        "homeTeam" : {
                                "name" : "Australia"
                        },
                        "awayTeam" : {
                                "name" : "England"
                        },
                        "dateTime" : ISODate("2014-04-05T19:00:00Z"),
                        "venue" : "Shere Bangla National Stadium, Mirpur",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?"
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?"
                                }
                        ],
                        "outcome" : {
                                "bestBowler" : {
                                        "name" : ""
                                },
                                "bestBatsman" : {
                                        "name" : ""
                                },
                                "manOfTheMatch" : {
                                        "name" : ""
                                },
                                "bonus" : [
                                        {
                                                "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
                                                "bonusAnswer" : ""
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : ""
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);
				
db.cricketCompetition.update({"name":"T20 World Cup 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sri Lanka vs West Indies",
						"fixtureId" : "Sri Lanka vs West Indies @ 2014-04-07T19:00:00Z",
                        "homeTeam" : {
                                "name" : "Sri Lanka"
                        },
                        "awayTeam" : {
                                "name" : "West Indies"
                        },
                        "dateTime" : ISODate("2014-04-07T19:00:00Z"),
                        "venue" : "Shere Bangla National Stadium, Mirpur",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?"
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?"
                                }
                        ],
                        "outcome" : {
                                "bestBowler" : {
                                        "name" : ""
                                },
                                "bestBatsman" : {
                                        "name" : ""
                                },
                                "manOfTheMatch" : {
                                        "name" : ""
                                },
                                "bonus" : [
                                        {
                                                "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
                                                "bonusAnswer" : ""
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : ""
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);
				
db.cricketCompetition.update({"name":"T20 World Cup 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "India vs South Africa",
						"fixtureId" : "India vs South Africa @ 2014-04-08T19:00:00Z",
                        "homeTeam" : {
                                "name" : "India"
                        },
                        "awayTeam" : {
                                "name" : "South Africa"
                        },
                        "dateTime" : ISODate("2014-04-08T19:00:00Z"),
                        "venue" : "Shere Bangla National Stadium, Mirpur",
						"bonus" : [
                                {
                                        "bonusQuestion" : "What will be the total number of sixes hit in the match?"
                                }                                
                        ],
                        "outcome" : {
                                "bestBowler" : {
                                        "name" : ""
                                },
                                "bestBatsman" : {
                                        "name" : ""
                                },
                                "manOfTheMatch" : {
                                        "name" : ""
                                },
                                "bonus" : [
                                        {
                                                "bonusQuestion" : "What will be the total number of sixes hit in the match?",
                                                "bonusAnswer" : ""
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);



