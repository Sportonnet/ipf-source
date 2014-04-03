db = connect("localhost:27017/sports_on_net_1", "gambler", "gambler");

db.cricketCompetition.insert({"name":"T20 World Cup 2014", "sport":"Cricket", "season":"T20 2014", "isActive":true});

db.cricketCompetition.update({"name":"T20 World Cup 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sri Lanka vs West Indies",
                        "homeTeam" : {
                                "name" : "Sri Lanka"
                        },
                        "awayTeam" : {
                                "name" : "West Indies"
                        },
                        "dateTime" : ISODate("2014-04-03T19:00:00Z"),
                        "venue" : "Shere Bangla National Stadium, Mirpur",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Which player will score the maximum runs in the match?"
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
                                                "bonusQuestion" : "Which player will score the maximum runs in the match?",
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
                        "homeTeam" : {
                                "name" : "India"
                        },
                        "awayTeam" : {
                                "name" : "South Africa"
                        },
                        "dateTime" : ISODate("2014-04-04T19:00:00Z"),
                        "venue" : "Shere Bangla National Stadium, Mirpur",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Which player will hit maximum sixes?"
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
                                                "bonusQuestion" : "Which player will hit maximum sixes?",
                                                "bonusAnswer" : ""
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);



