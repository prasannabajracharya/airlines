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
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Path("flight")
public class FlightController {

	@Inject
	private FlightService flightService;

	@GET
	public List<Flight> findAll() {
		return flightService.findAll();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("create")
	public Response create(Flight flight) {
		try {
			flightService.create(flight);
			return Response.ok().entity(flightService.find(flight)).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Path("update/{id}")
	@Consumes("application/json")
	public Response updateFlight(Flight flight, @PathParam("id") int id) {
		try {
			flight.setId(id);
			flightService.update(flight);
			return Response.ok().entity(flightService.find(flight)).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFlight(@QueryParam("id") int id) {
		try {
			Flight flight = new Flight();
			flight.setId(id);
			flight = flightService.find(flight);
			flightService.delete(flight);
			return Response.ok().entity(flightService.find(flight)).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("findByAirline")
	public List<Flight> findByAirline(@QueryParam("id") long id) {
		Airline airline = new Airline();
		airline.setId(id);
		return flightService.findByAirline(airline);
	}

}
