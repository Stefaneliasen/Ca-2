package facade;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class LogicFacade {

    EntityManagerFactory emf;

    public LogicFacade() {

    }

    public LogicFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void addPerson(Person person) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Person findPerson(String name) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.firstName = " + name);
            em.getTransaction().commit();
            Person person = (Person) query.getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }

    public Person findPersonById(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.id = " + id);
            em.getTransaction().commit();
            Person person = (Person) query.getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }

    public void addPhone(Phone phone) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(phone);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Phone findPhone(int number) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Phone p WHERE p.phoneNumber = " + number );
            em.getTransaction().commit();
            Phone phone = (Phone) query.getSingleResult();
            return phone;
        } finally {
            em.close();
        }

    }

    public void addAddress(Address address) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addCityInfo(CityInfo cityInfo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cityInfo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addHobby(Hobby hobby) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p from Person p");
            em.getTransaction().commit();
            List<Person> allPersons = query.getResultList();
            return allPersons;
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersonsByZip(int zip) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p from Person p where p.address.cityInfo.zipcode = " + zip);
            em.getTransaction().commit();
            List<Person> allPersons = query.getResultList();
            return allPersons;
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersonsByHobby(Long hobbyId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Person p, Hobby h where h =:Hobby");
            query.setParameter("Hobby", findHobbyById(hobbyId));
            em.getTransaction().commit();
            List<Person> allPersons = (List<Person>) query.getResultList();
            return allPersons;
        } finally {
            em.close();
        }
    }

    public Hobby findHobbyById(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT h from Hobby h where h.id =" + id);
            em.getTransaction().commit();
            Hobby hobby = (Hobby) query.getSingleResult();
            return hobby;
        } finally {
            em.close();
        }
    }
}
