/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

import Exceptions.PersonNotFoundException;
import Exceptions.ValidationErrorException;
import com.google.gson.Gson;
import entities.Person;
import facade.LogicFacade;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jsonmessages.JSONMessage;
import jsonmessages.MessageFacade;
import jsonmessages.PersonMessage;

/**
 * REST Web Service
 *
 * @author Stefan
 */
@Path("person")
public class PersonResource {

    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of entities.PersonResource
     *
     * @return an instance of java.lang.String
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CA-2_war_1.0-SNAPSHOTPU");
    LogicFacade lf = new LogicFacade(emf);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersons() {
        ArrayList<JSONMessage> messages = new ArrayList<>();
        for (Person person : lf.getAllPersons()) {
            messages.add(new PersonMessage(person));
        }
        return gson.toJson(messages);
    }
    @Path("/zip/{zipcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersonsByZip(@PathParam("zipcode") Integer zip ) {
        ArrayList<JSONMessage> messages = new ArrayList<>();
        for (Person person : lf.getAllPersonsByZip(zip)) {
            messages.add(new PersonMessage(person));
        }
        return gson.toJson(messages);
    }
    @Path("/hobby/{hobbyid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersonsByHobby(@PathParam("hobbyid") Long hobbyid ) {
        ArrayList<JSONMessage> messages = new ArrayList<>();
        for (Person person : lf.getAllPersonsByHobby(hobbyid)) {
            messages.add(new PersonMessage(person));
        }
        return gson.toJson(messages.size());
    }

    @Path("/id/{personid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("personid") Integer id) throws PersonNotFoundException {
        Person p = lf.findPersonById(id);
        if (p == null) {
            throw new PersonNotFoundException("The person ID does not exsist");
        }
        return MessageFacade.messagetoJson(new PersonMessage(p));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(String p) throws ValidationErrorException {
        Person newPerson = gson.fromJson(p, Person.class);
        lf.addPerson(newPerson);
        if(newPerson.getFirstName() == null){
        throw new ValidationErrorException("Missing first name");
        }
        if(newPerson.getLastName() == null){
        throw new ValidationErrorException("Missing last name");
        }
    }
    
}

