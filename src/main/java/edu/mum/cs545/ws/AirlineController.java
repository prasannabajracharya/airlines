package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

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
	
	@GET
	@Path("/{airlineName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Airline getAirlineByName(@PathParam("airlineName") String name){
		return airlineService.findByName(name);		
	}
	
	@PUT
	@Path("update/{airlineId}")
	@Consumes("application/json")
	public Response updateAirline(Airline airline, @PathParam("airlineId") int id){
		try{
		airline.setId(id);
		airlineService.update(airline);
		return Response.ok().entity(airlineService.find(airline)).build();
		}
		catch(Exception e){
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAirline(@QueryParam("id") int id){
		try{
		Airline airline = new Airline();
		airline.setId(id);
		airline=airlineService.find(airline);
		airlineService.delete(airline);
		return Response.ok().entity(airline).build();
		}
		catch(Exception e){
			return Response.status(500).build();
		}
	}
	
	

}
