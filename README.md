# Airlines
##### Web Application Architecture and Framework - MidTerm Project using JSF and REST


###### An API documentation indicating the URLs provided, HTTP methods available and their meaning and format of the messages request and response.
#### 1. For Airlines
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

2. For Flights

    1. GET [http://localhost:8080/airlines/rs/flight]()
        * Read list of all flights in JSON Format
          ```
          eg:
          input:
          url :	http://localhost:8080/airlines/rs/flight
          
         output:
       		{
       		 "airline": {
		            "id": 2,
		            "name": "SkyTeam"
		        },
		        "airplane": {
		            "capacity": 519,
		            "id": 3,
		            "model": "A380",
		            "serialnr": "12345"
		        },
		        "arrivalDate": "6/25/15",
		        "arrivalTime": "9:00 AM",
		        "departureDate": "8/6/09",
		        "departureTime": "7:10 PM",
		        "destination": {
		            "airportcode": "AMS",
		            "city": "Amsterdam",
		            "country": "The Netherlands",
		            "id": 4,
		            "name": "Schiphol"
		        },
		        "flightnr": "NW 36",
		        "id": 1,
		        "origin": {
		            "airportcode": "DTW",
		            "city": "Detroid",
		            "country": "USA",
		            "id": 5,
		            "name": "Detroid City"
		        }
		    }
            ```
    
    2. POST [http://localhost:8080/airlines/rs/flight/create]()
        * Creates new Flight
            ``` 
            eg: 
            input: 
            url : POST http://localhost:8080/airlines/rs/flight/create
            Payload:
			{
				"flightnr": "PB747",
				"arrivalDate": "6/25/15",
			    "arrivalTime": "2:53 PM",
			    "departureDate": "6/25/15",
			    "departureTime": "1:45 PM"
			}
            
            output:
		    {
		        "arrivalDate": "6/25/15",
		        "arrivalTime": "2:53 PM",
		        "departureDate": "6/25/15",
		        "departureTime": "1:45 PM",
		        "flightnr": "PB747",
		        "id": 2451
		    }

            
    3. PUT [http://localhost:8080/airlines/rs/flight/update/{id}]()
        * Updates flight information
            ```
            eg: 
            input: url with id of flight to be updated
            PUT http://localhost:8080/airlines/rs/flight/update/2451
            new details of flight to be changed is provided through message body
		    {
		        "arrivalDate": "7/25/15",
		        "arrivalTime": "2:53 PM",
		        "departureDate": "6/25/15",
		        "departureTime": "1:45 PM",
		        "flightnr": "PB888"
		    }
			
            output:
			{
		        "arrivalDate": "7/25/15",
		        "arrivalTime": "2:53 PM",
		        "departureDate": "6/25/15",
		        "departureTime": "1:45 PM",
		        "flightnr": "PB888",
		        "id": 2451
		    }
            
    4. DELETE [http://localhost:8080/airlines/rs/flight/remove?id={value}]()
        * Deletes the flight that matches the id value passed into id parameter through url
            ```
            eg: 
            input:
            url : DELETE http://localhost:8080/airlines/rs/flight/remove?id=2451
            payload : N/A
            
            output:
            Information for flight with id = 2451 is deleted from the database

            
     5. GET [http://localhost:8080/airlines/rs/flight/findByAirline?id={id}]()
       	* Retrieve flight information using flight name passed in url
       	```
       	eg:
       	input:
       	url : http://localhost:8080/airlines/rs/flight/findByAirline?id=17
       	payload : N/A
       	
       	output:
       	Display flight information requested for the airline id in url
		 {
        "airline": {
            "id": 17,
            "name": "North Star"
        },
        "airplane": {
            "capacity": 519,
            "id": 18,
            "model": "A380",
            "serialnr": "34512"
        },
        "arrivalDate": "6/25/15",
        "arrivalTime": "5:45 AM",
        "departureDate": "8/6/09",
        "departureTime": "2:30 PM",
        "destination": {
            "airportcode": "FRA",
            "city": "Frankfurt",
            "country": "Germany",
            "id": 19,
            "name": "Frankfurt International Airport"
        },
        "flightnr": "UA 944",
        "id": 16,
        "origin": {
            "airportcode": "ORD",
            "city": "Chicago",
            "country": "USA",
            "id": 20,
            "name": "Chicago O'hare International"
        }
    }
    
    
 3. For Airplanes
    1. GET [http://localhost:8080/airlines/rs/airplane]()
        * Read list of all airlines in JSON Format
          ```
          eg:
          input:
          url :	http://localhost:8080/airlines/rs/airplane
          
          output:
          [ 
		    {
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
		    }
		    ]
            ```
    
    2. POST [http://localhost:8080/airlines/rs/airplane/create]()
        * Creates new Airplane
            ``` 
            eg: 
            input: 
            url : POST http://localhost:8080/airlines/rs/airplane/create
            Payload:
		    {
		        "capacity": 420,
		        "model": "A380",
		        "serialnr": "88888"
		    }
            
            output:
			{
			    "capacity": 420,
			    "id": 2551,
			    "model": "A380",
			    "serialnr": "88888"
			}
            
    3. PUT [http://localhost:8080/airlines/rs/airplane/update/{id}]()
        * Updates airplane information
            ```
            eg: 
            input: url with id of airplane to be updated
            PUT http://localhost:8080/airlines/rs/airplane/update/2551
            new details of airplane to be changed is provided through message body
		    {
		        "capacity": 420,
		        "model": "B747",
		        "serialnr": "99999"
		    }
			
            output:
			{
			    "capacity": 420,
			    "id": 2551,
			    "model": "B747",
			    "serialnr": "99999"
			}
            
    4. DELETE [http://localhost:8080/airlines/rs/airplane/remove?id={value}]()
        * Deletes the airplane that matches the id value passed into id paramerter through url
            ```
            eg: 
            input:
            url : DELETE http://localhost:8080/airlines/rs/airplane/remove?id=2551
            payload : N/A
            
            output:
            following info is deleted from the database
			{
			    "capacity": 420,
			    "id": 2551,
			    "model": "B747",
			    "serialnr": "99999"
			}
            
    5. GET [http://localhost:8080/airlines/rs/airplane/{airlineName}]()
       	* Retrieve airplane information using airplane name passed in url
       	```
       	eg:
       	input:
       	url : http://localhost:8080/airlines/rs/airplane/SkyTeam
       	payload : N/A
       	
       	output:
       	Display airplane info requested for the name in url
       	{
    		"id": 2,
    		"name": "SkyTeam"
		}
		
		
4. For Airport
    	
    	1. GET [http://localhost:8080/airlines/rs/airport]()
        * Read list of all airports in JSON Format
          ```
          eg:
          input:
          url :	http://localhost:8080/airlines/rs/airport
          Payload : N/A
          
          output:
          [
				{
			        "airportcode": "AMS",
			        "city": "Amsterdam",
			        "country": "The Netherlands",
			        "id": 4,
			        "name": "Schiphol"
			    },
			    {
			        "airportcode": "DTW",
			        "city": "Detroid",
			        "country": "USA",
			        "id": 5,
			        "name": "Detroid City"
			    }
		    ]
            ```
    
    2. POST [http://localhost:8080/airlines/rs/airport/create]()
        * Creates new Airline
            ``` 
            eg: 
            input: 
            url : POST http://localhost:8080/airlines/rs/airport/create
            Payload:
			    {
			        "airportcode": "CID",
			        "city": "Des Monies",
			        "country": "United States",
			        "name": "Cedar Rapids"
			    }
            
            output:
				{
				    "airportcode": "CID",
				    "city": "Des Monies",
				    "country": "United States",
				    "id": 2601,
				    "name": "Cedar Rapids"
				}
            
    3. PUT [http://localhost:8080/airlines/rs/airport/update/{id}]()
        * Updates airport information
            ```
            eg: 
            input: url with id of airport to be updated
            PUT http://localhost:8080/airlines/rs/airport/update/2601
            new name of airport to be changed is provided through message body
			    {
			        "airportcode": "CEDR",
			        "city": "Des Monies",
			        "country": "United States",
			        "name": "Cedar Rapids"
			    }
			
            output:
			{
			    "airportcode": "CEDR",
			    "city": "Des Monies",
			    "country": "United States",
			    "id": 2601,
			    "name": "Cedar Rapids"
			}
            
    4. DELETE [http://localhost:8080/airlines/rs/airport/remove?id={value}]()
        * Deletes the airport that matches the id value passed into id paramerter through url
            ```
            eg: 
            input:
            url : DELETE http://localhost:8080/airlines/rs/airport/remove?id=2601
            payload : N/A
            
            output:
            following info is deleted from the database
			{
			    "airportcode": "CEDR",
			    "city": "Des Monies",
			    "country": "United States",
			    "id": 2601,
			    "name": "Cedar Rapids"
			}
         