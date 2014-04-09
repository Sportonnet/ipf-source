db = connect("localhost:27017/sports_on_net_1", "gambler", "gambler");

db.teams.insert({"name":"Mumbai Indians (MI)", "homeCity":"Mumbai", "country":"India", "homeVenue":"Wankhede Stadium"});
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Rohit Sharma (c)", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Lasith Malinga", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Harbhajan Singh", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Ambati Rayudu", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Kieron Pollard", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Michael Hussey", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Corey Anderson", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Pragyan Ojha", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Zaheer Khan", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Aditya Tare", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Jasprit Bumrah", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Jalaj Saxena", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Josh Hazlewood", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Marchant De Lange", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Krismar Santokie", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Ben Dunk", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"C.M. Gautam", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Apoorv Vijay Wankhade", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Pawan Suyal", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Sushant Marathe", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Mumbai Indians (MI)"},{"$addToSet":{"Player":{"playerName":"Shreyas Gopal", "skill":"ALL-ROUNDER"}}}, false, false);

db.teams.insert({"name":"Chennai Super Kings (CSK)", "homeCity":"Chennai", "country":"India", "homeVenue":"M. A. Chidambaram Stadium , 	JSCA International Stadium Complex - Ranchi"});
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"MS Dhoni (c)", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Ravindra Jadeja", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Ravichandran Ashwin", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Dwayne Bravo", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Suresh Raina", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Faf Du Plessis", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Dwayne Smith", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Brendon McCullum", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Ashish Nehra", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Mohit Sharma", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Ishwar Chandra Pandey", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Ben Hilfenhaus", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"John Hastings", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Samuel Badree", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Matt Henry", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Mithun Manhas", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Vijay Shankar", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Ronit More", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Baba Aparajith", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Chennai Super Kings (CSK)"},{"$addToSet":{"Player":{"playerName":"Pawan Negi", "skill":"BOWLER"}}}, false, false);

db.teams.insert({"name":"Rajasthan Royals (RR)", "homeCity":"Ahmedabad", "country":"India", "homeVenue":"Sardar Patel Stadium"});
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Shane Watson (c)", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"James Faulkner", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Stuart Binny", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Ajinkya Rahane", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Sanju Samson", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Steve Smith", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Brad Hodge", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Rajat Bhatia", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Tim Southee", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Dhawal Kulkarni", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Abhishek Nayar", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Kane Richardson", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Ben Cutting", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Karun Nair", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Unmukt Chand", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Iqbal Abdullah", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Deepak Hooda", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Dishant Yagnik", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Kevon Cooper", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Vikramjeet Malik", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Ankit Nagendra Sharma", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Rahul Tewatia", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Ankush Bains", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Amit Mishra", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Rajasthan Royals (RR)"},{"$addToSet":{"Player":{"playerName":"Pravin Tambe", "skill":"BOWLER"}}}, false, false);

db.teams.insert({"name":"Sunrisers Hyderabad (SH)", "homeCity":"Hyderabad", "country":"India", "homeVenue":"Rajiv Gandhi International Cricket Stadium"});
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Shikhar Dhawan (c)", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Dale Steyn", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"David Warner", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Amit Mishra", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Bhuvneshwar Kumar", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Aaron Finch", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Karn Sharma", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Darren Sammy", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Ishant Sharma", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Irfan Pathan", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Moises Henriques", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"K Lokesh Rahul", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Parveez Rasool", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Jason Holder", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Venugopal Rao", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Naman Ojha", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Brendan Taylor", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Prasanth Parameswaran", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Amit Paunikar", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Ashish Reddy", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Srikkanth Anirudha", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Ricky Bhui", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Chama Milind", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Sunrisers Hyderabad (SH)"},{"$addToSet":{"Player":{"playerName":"Manprit Juneja", "skill":"BATSMAN"}}}, false, false);

db.teams.insert({"name":"Royal Challengers Bangalore (RCB)", "homeCity":"Bengaluru", "country":"India", "homeVenue":"M. Chinnaswamy Stadium"});
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Virat Kohli (c)", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Chris Gayle", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"AB De Villiers", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Yuvraj Singh", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Mitchell Starc", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Albie Morkel", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Varun Aaron", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Ashok Dinda", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Parthiv Patel", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Muttiah Muralitharan", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Ravi Rampaul", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Nic Maddinson", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Harshal Patel", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Vijay Zol", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Abu Nechim Ahmed", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Sachin Rana", "skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Shadab Jakati", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Sandeep Warrier", "skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Tanmay Mishra", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Yogesh Takawale", "skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Royal Challengers Bangalore (RCB)"},{"$addToSet":{"Player":{"playerName":"Yuzvendra Singh Chahal", "skill":"BOWLER"}}}, false, false);

db.teams.insert({"name":"Kolkata Knight Riders (KKR)", "homeCity":"Kolkata", "country":"India", "homeVenue":"Eden Gardens"});
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Gautam Gambhir (c)","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Sunil Narine","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Jacques Kallis","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Robin Uthappa","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Piyush Chawla","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Yusuf Pathan","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Shakib Al Hasan","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Morne Morkel","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Vinay Kumar","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Umesh Yadav","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Manish Pandey","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Chris Lynn","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Patrick Cummins","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Ryan Ten Doeschate","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Suryakumar Yadav","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Andre Russell","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Manvinder Bisla","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Veer Pratap Singh","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Kuldeep Singh Yadav","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Debabrata Das","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kolkata Knight Riders (KKR)"},{"$addToSet":{"Player":{"playerName":"Sayan Sekhar Mandal","skill":"BOWLER"}}}, false, false);

db.teams.insert({"name":"Kings XI Punjab (KXIP)", "homeCity":"Mohali", "country":"India", "homeVenue":"PCA Stadium - Mohali , Barabati Stadium - Cuttack"});
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Manan Vohra","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"David Miller","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Mitchell Johnson","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Glenn Maxwell","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"George Bailey (c)","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Virender Sehwag","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Rishi Dhawan","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Wriddhiman Saha","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Shaun Marsh","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Cheteshwar Pujara","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Beuran Hendricks","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Lakshmipathy Balaji","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Thisara Perera","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Gurkirat Singh Mann","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Murali Kartik","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Sandeep Sharma","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Mandeep Hardev Singh","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Akshar Rajesh Patel","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Parvinder Awana","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Shardul Narendra Thakur","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Anureet Singh","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Shivam Sharma","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Kings XI Punjab (KXIP)"},{"$addToSet":{"Player":{"playerName":"Karanveer Singh","skill":"BOWLER"}}}, false, false);

db.teams.insert({"name":"Delhi Daredevils (DD)", "homeCity":"Delhi", "country":"India", "homeVenue":"Feroz Shah Kotla"});
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Dinesh Karthik","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Kevin Pietersen (c)","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Murali Vijay","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Mohammad Shami","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Nathan Coulter-Nile","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Quinton De Kock","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Manoj Tiwary","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Jaydev Unadkat","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Jean-Paul Duminy","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Ross Taylor","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Kedar Jadhav","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Rahul Sharma","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Mayank Agarwal","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Laxmi Ratan Shukla","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Jimmy Neesham","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Wayne Parnell","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Shahbaz Nadeem","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Saurabh Tiwary","skill":"BATSMAN"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Siddarth Kaul","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Rahul Shukla","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Jayant Yadav","skill":"ALL-ROUNDER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"HS Sharath","skill":"BOWLER"}}}, false, false);
db.teams.update({"name":"Delhi Daredevils (DD)"},{"$addToSet":{"Player":{"playerName":"Milind Kumar","skill":"BATSMAN"}}}, false, false);











