package web.rest;

import repository.EmployeeRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeResource {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GET
    @Path(value = "{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("name") String name) {
        return employeeRepository.findOneByName(name)
            .map(e -> Response.ok().entity(e).build())
            .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
