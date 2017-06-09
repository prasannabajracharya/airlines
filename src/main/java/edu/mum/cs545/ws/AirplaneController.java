package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;


@Named
@Path("airplane")
public class AirplaneController {
	
	@Inject
	private AirplaneService airplaneService;
	
	public List<Airplane> findAll() {
		return airplaneService.findAll();
	}
}
