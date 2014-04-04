db = connect("localhost:27017/sports_on_net_1", "gambler", "gambler");

db.cricketCompetition.update({"name" : "T20 World Cup 2014","fixtures.fixtureName" : "Sri Lanka vs West Indies"},{"$set":{"fixtures.$.outcome":{"bestBowler" : {
                                        "name" : "Lasith Malinga"
                                },
                                "bestBatsman" : {
                                        "name" : "HDRL Thirimanne"
                                },
                                "manOfTheMatch" : {
                                        "name" : "AD Mathews"
                                },
                                "bonus" : [
                                        {
                                                "bonusQuestion" : "Who will be the bowler with the most expensive over in the match?",
                                                "bonusAnswer" : "AD Russell"
                                        },
                                        {
                                                "bonusQuestion" : "What will be the distance of longest six in the match?",
                                                "bonusAnswer" : "80 - 85 metres"
                                        }
                                ],
                                "winnerTeam" : {
                                        "name" : "Sri Lanka"
                                }
                        }}});