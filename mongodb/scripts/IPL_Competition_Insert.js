db = connect("localhost:27017/sports_on_net_1", "gambler", "gambler");

db.cricketCompetition.insert({"name":"IPL7 2014", "sport":"Cricket", "season":"Season7 2014", "isActive":true});

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Kolkata Knight Riders (KKR)",
						"fixtureId" : "Mumbai Indians (MI) vs Kolkata Knight Riders (KKR) @ 2014-04-16T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-04-16T20:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs Royal Challengers Bangalore (RCB)",
						"fixtureId" : "Delhi Daredevils (DD) vs Royal Challengers Bangalore (RCB) @ 2014-04-17T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "dateTime" : ISODate("2014-04-17T20:00:00.000+05:30"),
                        "venue" : "Sharjah Cricket Stadium - Sharjah",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Super Kings (CSK) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Chennai Super Kings (CSK) vs Kings XI Punjab (KXIP) @ 2014-04-18T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-04-18T16:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Rajasthan Royals (RR)",
						"fixtureId" : "Sunrisers Hyderabad (SH) vs Rajasthan Royals (RR) @ 2014-04-18T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-04-18T20:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Mumbai Indians (MI)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Mumbai Indians (MI) @ 2014-04-19T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-04-19T16:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kolkata Knight Riders (KKR) vs Delhi Daredevils (DD)",
						"fixtureId" : "Kolkata Knight Riders (KKR) vs Delhi Daredevils (DD) @ 2014-04-19T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-04-19T20:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Rajasthan Royals (RR) vs Kings XI Punjab (KXIP) @ 2014-04-20T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-04-20T20:00:00.000+05:30"),
                        "venue" : "Sharjah Cricket Stadium - Sharjah",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Super Kings (CSK) vs Delhi Daredevils (DD)",
						"fixtureId" : "Chennai Super Kings (CSK) vs Delhi Daredevils (DD) @ 2014-04-21T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-04-21T20:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs Sunrisers Hyderabad (SH)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs Sunrisers Hyderabad (SH) @ 2014-04-22T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-04-22T20:00:00.000+05:30"),
                        "venue" : "Sharjah Cricket Stadium - Sharjah",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Chennai Super Kings (CSK)",
						"fixtureId" : "Rajasthan Royals (RR) vs Chennai Super Kings (CSK) @ 2014-04-23T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-04-23T20:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Kolkata Knight Riders (KKR)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Kolkata Knight Riders (KKR) @ 2014-04-24T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-04-24T20:00:00.000+05:30"),
                        "venue" : "Sharjah Cricket Stadium - Sharjah",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Delhi Daredevils (DD)",
						"fixtureId" : "Sunrisers Hyderabad (SH) vs Delhi Daredevils (DD) @ 2014-04-25T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-04-25T16:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Supers Kings (CSK) vs Mumbai Indians (MI)",
						"fixtureId" : "Chennai Supers Kings (CSK) vs Mumbai Indians (MI) @ 2014-04-25T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-04-25T20:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Royal Challengers Bangalore (RCB)",
						"fixtureId" : "Rajasthan Royals (RR) vs Royal Challengers Bangalore (RCB) @ 2014-04-26T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "dateTime" : ISODate("2014-04-26T16:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs Kolkata Knight Riders (KKR)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs Kolkata Knight Riders (KKR) @ 2014-04-26T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-04-26T20:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs Mumbai Indians (MI)",
						"fixtureId" : "Delhi Daredevils (DD) vs Mumbai Indians (MI) @ 2014-04-27T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-04-27T16:00:00.000+05:30"),
                        "venue" : "Sharjah Cricket Stadium - Sharjah",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Chennai Super Kings (CSK)",
						"fixtureId" : "Sunrisers Hyderabad (SH) vs Chennai Super Kings (CSK) @ 2014-04-27T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-04-27T20:00:00.000+05:30"),
                        "venue" : "Sharjah Cricket Stadium - Sharjah",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Kings XI Punjab (KXIP) @ 2014-04-28T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-04-28T20:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kolkata Knight Riders (KKR) vs Rajasthan Royals (RR)",
						"fixtureId" : "Kolkata Knight Riders (KKR) vs Rajasthan Royals (RR) @ 2014-04-29T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-04-29T20:00:00.000+05:30"),
                        "venue" : "Sheikh Zayed Stadium - Abu Dhabi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Sunrisers Hyderabad (SH)",
						"fixtureId" : "Mumbai Indians (MI) vs Sunrisers Hyderabad (SH) @ 2014-04-30T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-04-30T20:00:00.000+05:30"),
                        "venue" : "Dubai International Cricket Stadium - Dubai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Supers Kings (CSK) vs Kolkata Knight Riders (KKR)",
						"fixtureId" : "Chennai Supers Kings (CSK) vs Kolkata Knight Riders (KKR) @ 2014-05-02T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-05-02T20:00:00.000+05:30"),
                        "venue" : "JSCA International Stadium Complex - Ranchi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Mumbai Indians (MI) vs Kings XI Punjab (KXIP) @ 2014-05-03T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-05-03T16:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs Rajasthan Royals (RR)",
						"fixtureId" : "Delhi Daredevils (DD) vs Rajasthan Royals (RR) @ 2014-05-03T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-05-03T20:00:00.000+05:30"),
                        "venue" : "Feroz Shah Kotla - Delhi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Sunrisers Hyderabad (SH)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Sunrisers Hyderabad (SH) @ 2014-05-04T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-05-04T20:00:00.000+05:30"),
                        "venue" : "M. Chinnaswamy Stadium - Bengaluru",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Kolkata Knight Riders (KKR)",
						"fixtureId" : "Rajasthan Royals (RR) vs Kolkata Knight Riders (KKR) @ 2014-05-05T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-05-05T16:00:00.000+05:30"),
                        "venue" : "Sardar Patel Stadium - Ahmedabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs Chennai Super Kings (CSK)",
						"fixtureId" : "Delhi Daredevils (DD) vs Chennai Super Kings (CSK) @ 2014-05-05T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-05-05T20:00:00.000+05:30"),
                        "venue" : "Feroz Shah Kotla - Delhi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Royal Challengers Bangalore (RCB)",
						"fixtureId" : "Mumbai Indians (MI) vs Royal Challengers Bangalore (RCB) @ 2014-05-06T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "dateTime" : ISODate("2014-05-06T20:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs  Kolkata Knight Riders (KKR)",
						"fixtureId" : "Delhi Daredevils (DD) vs  Kolkata Knight Riders (KKR) @ 2014-05-07T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-05-07T16:00:00.000+05:30"),
                        "venue" : "Feroz Shah Kotla - Delhi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs  Chennai Super Kings (CSK)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs  Chennai Super Kings (CSK) @ 2014-05-07T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-05-07T20:00:00.000+05:30"),
                        "venue" : "Barabati Stadium - Cuttack",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Sunrisers Hyderabad (SH)",
						"fixtureId" : "Rajasthan Royals (RR) vs Sunrisers Hyderabad (SH) @ 2014-05-08T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-05-08T20:00:00.000+05:30"),
                        "venue" : "Sardar Patel Stadium - Ahmedabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Kings XI Punjab (KXIP) @ 2014-05-09T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-05-09T20:00:00.000+05:30"),
                        "venue" : "M. Chinnaswamy Stadium - Bengaluru",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs  Sunrisers Hyderabad (SH)",
						"fixtureId" : "Delhi Daredevils (DD) vs  Sunrisers Hyderabad (SH) @ 2014-05-10T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-05-10T16:00:00.000+05:30"),
                        "venue" : "Feroz Shah Kotla - Delhi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs  Chennai Super Kings (CSK)",
						"fixtureId" : "Mumbai Indians (MI) vs  Chennai Super Kings (CSK) @ 2014-05-10T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Super Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-05-10T20:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs  Kolkata Knight Riders (KKR)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs  Kolkata Knight Riders (KKR) @ 2014-05-11T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-05-11T16:00:00.000+05:30"),
                        "venue" : "Barabati Stadium - Cuttack",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs  Rajasthan Royals (RR)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs  Rajasthan Royals (RR) @ 2014-05-11T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-05-11T20:00:00.000+05:30"),
                        "venue" : "M. Chinnaswamy Stadium - Bengaluru",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Mumbai Indians (MI)",
						"fixtureId" : "Sunrisers Hyderabad ((SH) vs Mumbai Indians (MI) @ 2014-05-12T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-05-12T20:00:00.000+05:30"),
                        "venue" : "Rajiv Gandhi International Cricket Stadium - Hyderabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Supers Kings (CSK) vs Rajasthan Royals (RR)",
						"fixtureId" : "Chennai Supers Kings (CSK) vs Rajasthan Royals (RR) @ 2014-05-13T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-05-13T16:00:00.000+05:30"),
                        "venue" : "JSCA International Stadium Complex - Ranchi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Delhi Daredevils (DD)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Delhi Daredevils (DD) @ 2014-05-13T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-05-13T20:00:00.000+05:30"),
                        "venue" : "M. Chinnaswamy Stadium - Bengaluru",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Sunrisers Hyderabad (SH) vs Kings XI Punjab (KXIP) @ 2014-05-14T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-05-14T16:00:00.000+05:30"),
                        "venue" : "Rajiv Gandhi International Cricket Stadium - Hyderabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kolkata Knight Riders (KKR) vs Mumbai Indians (MI)",
						"fixtureId" : "Kolkata Knight Riders (KKR) vs Mumbai Indians (MI) @ 2014-05-14T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-05-14T20:00:00.000+05:30"),
                        "venue" : "Eden Gardens - Kolkata",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Delhi Daredevils (DD)",
						"fixtureId" : "Rajasthan Royals (RR) vs Delhi Daredevils (DD) @ 2014-05-15T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-05-15T20:00:00.000+05:30"),
                        "venue" : "Sardar Patel Stadium - Ahmedabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Supers Kings (CSK) vs Royal Challengers Bangalore (RCB)",
						"fixtureId" : "Chennai Supers Kings (CSK) vs Royal Challengers Bangalore (RCB) @ 2014-05-18T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "dateTime" : ISODate("2014-05-18T16:00:00.000+05:30"),
                        "venue" : "M. A. Chidambaram Stadium - Chennai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Kolkata Knight Riders (KKR)",
						"fixtureId" : "Sunrisers Hyderabad (SH) vs Kolkata Knight Riders (KKR) @ 2014-05-18T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "dateTime" : ISODate("2014-05-18T20:00:00.000+05:30"),
                        "venue" : "Rajiv Gandhi International Cricket Stadium - Hyderabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Rajasthan Royals (RR) vs Mumbai Indians (MI)",
						"fixtureId" : "Rajasthan Royals (RR) vs Mumbai Indians (MI) @ 2014-05-19T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-05-19T16:00:00.000+05:30"),
                        "venue" : "Sardar Patel Stadium - Ahmedabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Delhi Daredevils (DD) vs Kings XI Punjab (KXIP)",
						"fixtureId" : "Delhi Daredevils (DD) vs Kings XI Punjab (KXIP) @ 2014-05-19T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "awayTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "dateTime" : ISODate("2014-05-19T20:00:00.000+05:30"),
                        "venue" : "Feroz Shah Kotla - Delhi",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Sunrisers Hyderabad (SH) vs Royal Challengers Bangalore (RCB)",
						"fixtureId" : "Sunrisers Hyderabad (SH) vs Royal Challengers Bangalore (RCB) @ 2014-05-20T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "awayTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "dateTime" : ISODate("2014-05-20T16:00:00.000+05:30"),
                        "venue" : "Rajiv Gandhi International Cricket Stadium - Hyderabad",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kolkata Knight Riders (KKR) vs Chennai Supers Kings (CSK)",
						"fixtureId" : "Kolkata Knight Riders (KKR) vs Chennai Supers Kings (CSK) @ 2014-05-20T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-05-20T20:00:00.000+05:30"),
                        "venue" : "Eden Gardens - Kolkata",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs Mumbai Indians (MI)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs Mumbai Indians (MI) @ 2014-05-21T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "dateTime" : ISODate("2014-05-21T20:00:00.000+05:30"),
                        "venue" : "PCA Stadium - Mohali",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kolkata Knight Riders (KKR) vs Royal Challengers Bangalore (RCB)",
						"fixtureId" : "Kolkata Knight Riders (KKR) vs Royal Challengers Bangalore (RCB) @ 2014-05-22T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "awayTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "dateTime" : ISODate("2014-05-22T16:00:00.000+05:30"),
                        "venue" : "Eden Gardens - Kolkata",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Chennai Supers Kings (CSK) vs Sunrisers Hyderabad (SH)",
						"fixtureId" : "Chennai Supers Kings (CSK) vs Sunrisers Hyderabad (SH) @ 2014-05-22T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-05-22T20:00:00.000+05:30"),
                        "venue" : "M. A. Chidambaram Stadium - Chennai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Delhi Daredevils (DD)",
						"fixtureId" : "Mumbai Indians (MI) vs Delhi Daredevils (DD) @ 2014-05-23T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-05-23T16:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs Rajasthan Royals (RR)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs Rajasthan Royals (RR) @ 2014-05-23T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-05-23T20:00:00.000+05:30"),
                        "venue" : "PCA Stadium - Mohali",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Royal Challengers Bangalore (RCB) vs Chennai Supers Kings (CSK)",
						"fixtureId" : "Royal Challengers Bangalore (RCB) vs Chennai Supers Kings (CSK) @ 2014-05-24T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Royal Challengers Bangalore (RCB)"
                        },
                        "awayTeam" : {
                                "name" : "Chennai Supers Kings (CSK)"
                        },
                        "dateTime" : ISODate("2014-05-24T16:00:00.000+05:30"),
                        "venue" : "M. Chinnaswamy Stadium - Bengaluru",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kolkata Knight Riders (KKR) vs Sunrisers Hyderabad (SH)",
						"fixtureId" : "Kolkata Knight Riders (KKR) vs Sunrisers Hyderabad (SH) @ 2014-05-24T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kolkata Knight Riders (KKR)"
                        },
                        "awayTeam" : {
                                "name" : "Sunrisers Hyderabad (SH)"
                        },
                        "dateTime" : ISODate("2014-05-24T20:00:00.000+05:30"),
                        "venue" : "Eden Gardens - Kolkata",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Kings XI Punjab (KXIP) vs Delhi Daredevils (DD)",
						"fixtureId" : "Kings XI Punjab (KXIP) vs Delhi Daredevils (DD) @ 2014-05-25T16:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Kings XI Punjab (KXIP)"
                        },
                        "awayTeam" : {
                                "name" : "Delhi Daredevils (DD)"
                        },
                        "dateTime" : ISODate("2014-05-25T16:00:00.000+05:30"),
                        "venue" : "PCA Stadium - Mohali",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Rajasthan Royals (RR)",
						"fixtureId" : "Mumbai Indians (MI) vs Rajasthan Royals (RR) @ 2014-05-25T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : "Mumbai Indians (MI)"
                        },
                        "awayTeam" : {
                                "name" : "Rajasthan Royals (RR)"
                        },
                        "dateTime" : ISODate("2014-05-25T20:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Rajasthan Royals (RR)",
						"fixtureId" : "Mumbai Indians (MI) vs Rajasthan Royals (RR) @ 2014-05-27T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : ""
                        },
                        "awayTeam" : {
                                "name" : ""
                        },
                        "dateTime" : ISODate("2014-05-27T20:00:00.000+05:30"),
                        "venue" : "M. A. Chidambaram Stadium - Chennai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Rajasthan Royals (RR)",
						"fixtureId" : "Mumbai Indians (MI) vs Rajasthan Royals (RR) @ 2014-05-28T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : ""
                        },
                        "awayTeam" : {
                                "name" : ""
                        },
                        "dateTime" : ISODate("2014-05-28T20:00:00.000+05:30"),
                        "venue" : "M. A. Chidambaram Stadium - Chennai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Rajasthan Royals (RR)",
						"fixtureId" : "Mumbai Indians (MI) vs Rajasthan Royals (RR) @ 2014-05-30T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : ""
                        },
                        "awayTeam" : {
                                "name" : ""
                        },
                        "dateTime" : ISODate("2014-05-28T20:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : ""
                                }
                        }
                }}}, false, false);

db.cricketCompetition.update({"name":"IPL7 2014"},{"$addToSet":{"fixtures":{
						"fixtureName" : "Mumbai Indians (MI) vs Chennai Super Kings (CSK)",
						"fixtureId" : "Mumbai Indians (MI) vs Chennai Super Kings (CSK) @ 2014-06-01T20:00:00.000+05:30",
                        "homeTeam" : {
                                "name" : ""
                        },
                        "awayTeam" : {
                                "name" : ""
                        },
                        "dateTime" : ISODate("2014-06-01T20:00:00.000+05:30"),
                        "venue" : "Wankhede Stadium - Mumbai",
						"bonus" : [
                                {
                                        "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
										"option" : ["","","",""]
                                },
                                {
                                        "bonusQuestion" : "What will be the distance of longest six in the match?",
										"option" : ["","","",""]
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
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "",
												"option" : ["","","",""]
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : "Mumbai Indians (MI)"
                                }
                        }
                }}}, false, false);

	