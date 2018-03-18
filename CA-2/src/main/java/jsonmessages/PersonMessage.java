/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmessages;

import entities.Hobby;
import entities.Person;
import facade.LogicFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bladt
 */
public class PersonMessage implements JSONMessage<Person> {

    public Long id;
    public String firstName;
    public String lastName;
    public List<Long> hobbyIds;

    public PersonMessage(Person p) {
        this.firstName = p.getFirstName();
        this.id = p.getId();
        //Get coursenames as list.
        Stream<Hobby> hobbies = p.getHobbys().stream();
        Stream<Long> hobbyIds = hobbies.map(c -> c.id);
        this.hobbyIds = hobbyIds.collect(Collectors.toList());
    }

    @Override
    public Person toInternal() {
        ArrayList<Hobby> hobbies = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CA-2_war_1.0-SNAPSHOTPU");
        LogicFacade lf = new LogicFacade(emf);
        for (Long id : hobbyIds) {
            hobbies.add(lf.findHobbyById(id));
        }
        return new Person(firstName, lastName, id, hobbies);
    }

}
