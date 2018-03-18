package tester;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import facade.LogicFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CA-2_war_1.0-SNAPSHOTPU");
        LogicFacade lf = new LogicFacade(emf);
        Persistence.generateSchema("com.mycompany_CA-2_war_1.0-SNAPSHOTPU", null);
        CityInfo cityInfo = new CityInfo(2800, "Lyngby");
        Address højbjerg = new Address("højbjerfg", "ligger på et højt bjerg", cityInfo);
        Hobby hobby = new Hobby("Golf", "ram hullet");
        Hobby hobby1 = new Hobby("CS", "gaminglivet");
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(hobby);
        lf.addHobby(hobby1);
        Person oliver = new Person("Oliver", "idiot", højbjerg, hobbies);
        Person oliver123 = new Person("Oliver123", "idiot", højbjerg, hobbies);
        //Person oliver123 = new Person("Oliver123", "idiot", højbjerg, hobbies);
        lf.addCityInfo(cityInfo);
        lf.addAddress(højbjerg);
        lf.addPerson(oliver);
        lf.addPerson(oliver123);
        //lf.addPerson(oliver123);
        lf.addPhone(new Phone(12345, "arnenugagren", oliver));
        //Person findPerson = lf.findPerson("Oliver");
       // System.out.println("FIRSTNAME: " + findPerson.getFirstName());
        Phone findPhone = lf.findPhone(12345);
        Person person = lf.findPersonById(1);
        System.out.println(person.getFirstName());
        System.out.println("Phonenumber " + findPhone.getPhoneNumber() + " belongs to: " + findPhone.getPerson().getFirstName());
        List<Person> allPersons = lf.getAllPersons();
        for (Person allPerson : allPersons) {
            System.out.println(allPerson.getFirstName());
        }
        List<Person> personsByZip = lf.getAllPersonsByZip(2800);
        for (Person person1 : personsByZip) {
            System.out.println(person1.getAddress().getCityInfo().getZipcode() + " hehe "  + person1.getFirstName());
        }
    }
}
