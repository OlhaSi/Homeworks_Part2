package de.telran.person.repo;

import de.telran.person.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IPersonRepoIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IPersonRepo personRepo;

    @Test
    public void testFindAllByName_onePerson_existing(){
        Person person = new Person("Dan");
        person.setAge(20);
        person.setSecondName("Person");

        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByName("Dan");

        assertEquals(1, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();

        assertEquals(person.getName(), personFromDb.getName());
        assertEquals(person.getSecondName(), personFromDb.getSecondName());
        assertEquals(person.getAge(), personFromDb.getAge());

        assertTrue(personFromDb.getId() > 0);
    }

    @Test
    public void testFindAll_noPersonsExist_emptyList() {
        List<Person> persons = (List<Person>) personRepo.findAll();
        assertEquals(0, persons.size());
    }

    @Test
    public void testFindAllByName_onePerson_nonExisting(){
        Person person = new Person("Dan");
        person.setAge(20);
        person.setSecondName("Person");

        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByName("Da");

        assertEquals(0, personsFromDb.size());
    }

    @Test
    public void testFindAllByAgeOlderThan_onePerson_existing(){
        Person person = new Person("Dan");
        person.setAge(20);
        person.setSecondName("Person");

        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByAgeAfter(10);

        assertEquals(1, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();

        assertEquals(person.getName(), personFromDb.getName());
        assertEquals(person.getSecondName(), personFromDb.getSecondName());
        assertEquals(person.getAge(), personFromDb.getAge());

        assertTrue(personFromDb.getId() > 0);
    }

    @Test
    public void testFindAllByAgeBetween_twoPersons_existing(){
        Person person1 = new Person("Dan");
        person1.setAge(20);
        person1.setSecondName("Person");

        Person person2 = new Person("Jack");
        person2.setAge(30);
        person2.setSecondName("Person");

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByAgeBetween(10, 50);

        assertEquals(2, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb1 = iterator.next();
        Person personFromDb2 = iterator.next();

        assertEquals(person1.getName(), personFromDb1.getName());
        assertEquals(person1.getSecondName(), personFromDb1.getSecondName());
        assertEquals(person1.getAge(), personFromDb1.getAge());

        assertEquals(person2.getName(), personFromDb2.getName());
        assertEquals(person2.getSecondName(), personFromDb2.getSecondName());
        assertEquals(person2.getAge(), personFromDb2.getAge());

        assertTrue(personFromDb1.getId() > 0);
    }

//    @Test
//    public void testFindAllBySecondNameContaining_onePerson_existing(){
//        Person person1 = new Person("Dan");
//        person1.setAge(20);
//        person1.setSecondName("Person");
//
//        entityManager.persist(person1);
//        entityManager.flush();
//        entityManager.clear();
//
//        Collection<Person> personsFromDb = personRepo.findAllBySecondNameContaining("Da");
//
//        assertEquals(1, personsFromDb.size());
//
//        Iterator<Person> iterator = personsFromDb.iterator();
//        Person personFromDb1 = iterator.next();
//
//        assertEquals(person1.getName(), personFromDb1.getName());
//        assertEquals(person1.getSecondName().contains("da"), personFromDb1.getSecondName());
//        assertEquals(person1.getAge(), personFromDb1.getAge());
//
//        assertTrue(personFromDb1.getId() > 0);
//    }
}