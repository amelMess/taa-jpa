package web.rest;

import domain.Department;
import repository.DepartmentRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/department")
public class DepartementResource {

    private DepartmentRepository departmentRepository = new DepartmentRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
