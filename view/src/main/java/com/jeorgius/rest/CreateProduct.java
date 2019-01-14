package com.jeorgius.rest;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/createproduct")
public class CreateProduct {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public void createProduct (@Context HttpServletRequest req,
                               @Context HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp")
                .forward(req,resp);
    }

    @GET
    public String hello(){
        return "Hello, GZ";
    }
}
