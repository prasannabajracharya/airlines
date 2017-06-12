# airlines
##### Web Application Architecture and Framework - MidTerm Project using JSF and REST


###### An API documentation indicating the URLs provided, HTTP methods available and their meaning and format of the messages request and response.
1. For Airlines
    1. GET [http://localhost:8080/airlines/rs/airline]()
        * Read list of all airlines in JSON Format
          ```
          eg:
          input:
          url :	http://localhost:8080/airlines/rs/airline
          
          output:
          [{
                "id": 2,
                "name": "SkyTeam"
            },
            {
                "id": 10,
                "name": "oneworld"
            }]
            ```
    
    2. POST [http://localhost:8080/airlines/rs/airline/create]()
        * Creates new Airline
            ``` 
            eg: 
            input: 
            url : POST http://localhost:8080/airlines/rs/airline/create
            Payload:
            {
            	"name":"Buddha Airlines"
            }
            
            output:
            {
                "id": 2401,
                "name": "Buddha Airlines"
            }
            
    3. PUT [http://localhost:8080/airlines/rs/airline/update/{id}]()
        * Updates airline information
            ```
            eg: 
            input: url with id of airline to be updated
            PUT http://localhost:8080/airlines/rs/airline/update/1701
            new name of airline to be changed is provided through message body
           {
				"name" : "Yeti Airlines"
			}
			
            output:
            {
                "id": 1701,
                "name": "Yeti Airlines"
            }
            
    4. DELETE [http://localhost:8080/airlines/rs/airline/remove?id={value}]()
        * Deletes the airline that matches the id value passed into id paramerter through url
            ```
            eg: 
            input:
            url : DELETE http://localhost:8080/airlines/rs/airline/remove?id=1701
            payload : N/A
            
            output:
            following info is deleted from the database
            {
                "id": 1701,
                "name": "Yeti Airlines"
            }
            
       5. GET [http://localhost:8080/airlines/rs/airline/{airlineName}]()
       	* Retrieve airline information using airline name passed in url
       	```
       	eg:
       	input:
       	url : http://localhost:8080/airlines/rs/airline/SkyTeam
       	payload : N/A
       	
       	output:
       	Display airline info requested for the name in url
       	{
    		"id": 2,
    		"name": "SkyTeam"
		}

2. For Airplane
    1. GET [http://localhost:8080/airlines/rs/airplane]()
        * List of all Airplanes in following Format
          ```
          output:
          [{
               "capacity": 519,
               "id": 3,
               "model": "A380",
               "serialnr": "12345"
           },
           {
               "capacity": 416,
               "id": 7,
               "model": "747",
               "serialnr": "54321"
           }]
            ```
    2. GET [http://localhost:8080/airlines/rs/airplane/{id}]()
        * Returns an Airplane that matches the id
            ```
            eg: GET http://localhost:8080/airlines/rs/airplane/3
            output: 
            {
               "capacity": 519,
               "id": 3,
               "model": "A380",
               "serialnr": "12345"
           }
            ```
    3. GET [http://localhost:8080/airlines/rs/airplane/serial?serialNo={serialN}]()
        * Returns an Airplane that matches the serial number to serialN
            ```
            eg: GET http://localhost:8080/airlines/rs/airplane/serial?serialNo=12345
            output: 
            {
               "capacity": 519,
               "id": 3,
               "model": "A380",
               "serialnr": "12345"
           }
            ```
    4. GET [http://localhost:8080/airlines/rs/airplane/model?model={modelN}]()
        * Returns List of Airplane that matches the model to modelN
            ```
            eg: GET http://localhost:8080/airlines/rs/airplane/model?model=A380
            output: 
            [{
                    "capacity": 519,
                    "id": 3,
                    "model": "A380",
                    "serialnr": "12345"
                },
                {
                    "capacity": 519,
                    "id": 11,
                    "model": "A380",
                    "serialnr": "23451"
                }]
            ```
    5. POST [http://localhost:8080/airlines/rs/airplane/new]()
        * Creates new Airline
            ``` 
            eg: POST http://localhost:8080/airlines/rs/airplane/new
            input: 
            {
                "capacity": 500,
                "model": "A381",
                "serialnr": "12000"
            }
            output:
            {
                "capacity": 500,
                "id": 2253,
                "model": "A381",
                "serialnr": "12000"
            }
    5. DELETE [http://localhost:8080/airlines/rs/airplane/delete/{id}]()
        * Deletes the airline that matches the id
            ```
            eg: DELETE http://localhost:8080/airlines/rs/airplane/delete/2253
            output:
            {
                "capacity": 500,
                "id": 2253,
                "model": "A381",
                "serialnr": "12000"
            }
    6. PUT [http://localhost:8080/airlines/rs/airplane/update]()
        * Updates airline
            ```
            eg: PUT http://localhost:8080/airlines/rs/airplane/update
            input:
            {
                "capacity": 501,
                "id": 2253,
                "model": "A381",
                "serialnr": "12001"
            }
            output:
            {
                "capacity": 501,
                "id": 2253,
                "model": "A381",
                "serialnr": "12001"
            }