package com.app.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.app.dao.DaoImp;
import com.app.models.Employee;

@Path("/emp")
public class AddEmployee {
	
	Logger logger=Logger.getLogger(AddEmployee.class);

	@POST
	@Path("/reg")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registeremp(Employee employee) {
		logger.info("Getting register Details");
		
		
		DaoImp daoImp = new DaoImp();
		daoImp.register(employee);
		
		logger.info(" registered Details"+employee.getName());
		return Response.status(201).entity("employee name  =" + employee.getName()).build();

	}
	@GET
	@Path("/allemp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		
		DaoImp daoImp=new DaoImp();
		List<Employee> getall = daoImp.getall();
		for (Employee employee : getall) {
			logger.info("Employee"+employee.toString());
		}
		
		return Response.status(200).entity("Employee List").build();
		
		
		
	}

}
