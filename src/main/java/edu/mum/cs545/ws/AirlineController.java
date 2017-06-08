package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named
@Path("airline")
public class AirlineController {
	@Inject
	private AirlineService airlineService;
	
	@GET
	public List<Airline> getAirlines(){
		return airlineService.findAll();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/create")
	public Response create(Airline airport){
		try{
			airlineService.create(airport);
			return Response.ok().entity(airport).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Path("update")
	public void update(String id){
		
	}
}