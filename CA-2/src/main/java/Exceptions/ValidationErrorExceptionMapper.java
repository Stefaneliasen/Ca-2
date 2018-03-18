/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import static Exceptions.PersonNotFoundExceptionMapper.gson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author DD
 */
@Provider
public class ValidationErrorExceptionMapper implements ExceptionMapper<ValidationErrorException> {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(ValidationErrorException ex) {
        boolean isDebug = context.getInitParameter("debug").equals("true");
        ErrorMessages err = new ErrorMessages(ex, 400, isDebug);
        err.setDescription("You tried to call... ");
        return Response.status(400)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).build();
    }

}
