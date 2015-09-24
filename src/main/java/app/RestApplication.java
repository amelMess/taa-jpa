package app;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import web.rest.DepartementResource;
import web.rest.EmployeeResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    public static void main(String[] args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(new RestApplication());
        server.start(Undertow.builder().addHttpListener(8080, "localhost"));
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> clazzes = new HashSet<>();

        clazzes.add(DepartementResource.class);
        clazzes.add(EmployeeResource.class);

        return clazzes;
    }
}
