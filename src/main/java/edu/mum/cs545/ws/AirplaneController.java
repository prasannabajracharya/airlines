package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

@Path("airplane")
public class AirplaneController {
	
	@Inject
	private AirplaneService airplaneService;
	
	@GET
	public List<Airplane> findAll() {
		return airplaneService.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("create")
	public Response create(Airplane airplane){
		
		try {
			airplaneService.create(airplane);
			return Response.ok().entity(airplane).build();
		} 
		catch (Exception e) {			
			return Response.status(500).entity(e.getMessage()).build();
		}		
	}
	
	@PUT
	@Path("update/{id}")
	public Response update(Airplane airplane, @PathParam("id") long id){
		try{
			airplane.setId(id);
			airplaneService.update(airplane);
			return Response.ok().entity(airplane).build();
		}
		catch(Exception e){
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("remove")
	public Response delete(@QueryParam("id") long id){
		try{
			Airplane airplane = new Airplane();
			airplane.setId(id);
			airplane = airplaneService.find(airplane);
			airplaneService.delete(airplane);
			return Response.ok().entity(airplane).build();
		}
		catch(Exception e){
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
	
}
