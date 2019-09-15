# genesis-spring-boot-using-mongo-db
Spring Boot Microservice to serve data using REST and MongoDB

## SETTING UP THE DATA BASE:
The database has already been set up MongoDB Cloud Atlas:
Steps of setting the Database: 

1. Connect to MongoDB Atlas with your CLI (details for my AWS instance can be found in details below).
2. Create Database (megaman) with the below command: 
	> use megaman
3. Create Collection bosses with the below command:
	> create collection("bosses")
4. add documents to the bosses collection:
	> db.bosses.insertMany([{"name": "Man", "weapon": "Rolling Cutter", "weakness": "Super Arm" }, {"name": "Guts Man", "weapon": "Super Arm", "weakness": "Hyper Bomb" }, {"name": "Fire Man", "weapon": "Fire Wave", "weakness": "Ice Slasher" } ]);
	> db.bosses.insertMany([{"name": "Super Siyaan", "weapon": "Rolling Cutter", "weakness": "Gohan" }, {"name": "Gohan", "weapon": "Hyper Bomb", "weakness": "Fire Wave" }, {"name": "Fire Girl", "weapon": "Fire Wave", "weakness": "Ice Slasher" } ]);
	> db.bosses.insertMany([{"name": "Arrow", "weapon": "bow and Arrow", "weakness": "Fire Wave" }, {"name": "Aparichit", "weapon": "Dagger", "weakness": "Ambi" }, {"name": "Ambi", "weapon": "Rules and Law", "weakness": "Nandini" } ]);
5. check the added documents via the command below:
	> db.bosses.find().forEach(prinjson)
	
## SETTING UP THE CODE_BASE:
1. Pull the code to your local repository and import into your IDE.
2. Do maven updated on the project.
3. Run the spring boot project.

Instance runs on Port : 8080

## API DETAILS:
Below is the list of APIs provided by the project:

| Request Method | ----------------------- Request Endpoint ----------------------------------- |
| -------------- | ---------------------------------------------------------------------------- |
| ---- GET ----- | http://localhost:8080/megaman/bosses/{id}                                 	  |
| ---- GET ----- | http://localhost:8080/megaman/bosses/all                                  	  |
| ---- GET ----- | http://localhost:8080/megaman/bosses/name/{name}                          	  |
| ---- GET ----- | http://localhost:8080/megaman/bosses/weapon/{weapon}                      	  |
| ---- GET ----- | http://localhost:8080/megaman/bosses/weakness/{weakness}                  	  |
| ---- GET ----- | http://localhost:8080/megaman/bosses/weapon/{weapon}/and/weakness/{weakness} | 
| ---- GET ----- | http://localhost:8080/megaman/bosses/weapon/{weapon}/or/weakness/{weakness}  |
| ---- GET ----- | http://localhost:8080/megaman/bosses/weakness/{weakness}?order=desc          |
