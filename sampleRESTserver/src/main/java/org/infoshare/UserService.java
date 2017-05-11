package org.infoshare;

import org.infoshare.model.Credentials;
import org.infoshare.model.User;
import org.infoshare.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path("/")
public class UserService {

    @Context
    UriInfo uriinfo;

    private UserStore userStore;

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    public UserService() {
        userStore = new UserStore();
    }

    @GET
    @Path("/hi/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response say(@PathParam("name") String name) {
        LOG.info("Saying hello from " + uriinfo.getAbsolutePath());
        String msg = "Hello, " + name;
        return Response.ok(msg).build();
    }

    @GET
    @Path("/userInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo(@QueryParam("id") Integer id) {
        User user = userStore.getBase().get(id);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.noContent().build();
        }
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        Collection<User> users = userStore.getBase().values();
        if (users.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok(users).build();
        }
    }

    @GET
    @Path("/userAgent")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAgent(@HeaderParam("user-agent") String userAgent) {
        LOG.info("Klient uzywa: " + userAgent);
        return Response.ok("Używasz przeglądarki:" + userAgent).build();
    }

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response login(Credentials credentials) {
        LOG.info("Loguje się user: " + credentials.getName());
        return Response.ok("Wszystko poszło ok " + credentials.getName()).build();
    }

    @PUT
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User incomingUser) {
        LOG.info("Adding user:" + incomingUser.toString());
        User user = new User(incomingUser.getName(), incomingUser.getSurname(), null);
        userStore.add(user);
        return Response.ok(userStore.getBase().values()).build();
    }

}
