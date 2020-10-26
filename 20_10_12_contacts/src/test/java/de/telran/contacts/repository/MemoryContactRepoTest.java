package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryContactRepoTest {

    MemoryContactRepo contactRepo;

    @BeforeEach
    public void init(){
        contactRepo = new MemoryContactRepo();
    }

    @Test
    public void testGetAll_noElements_emptyList(){
        assertEquals(0, contactRepo.getAll().size());
    }

    @Test
    public void testAddAndGet_oneElement_oneContact(){
        Contact dan = new Contact("Dan", "123");
        contactRepo.add(dan);

        List<Contact> contacts = contactRepo.getAll();
        assertEquals(1, contacts.size());

        Contact fromRepo = contacts.get(0);

        assertEquals(dan.name, fromRepo.name);
        assertEquals(dan.number, fromRepo.number);
    }

    @Test
    public void testAddAndGet_threeElements_threeContact(){
        Contact dan = new Contact("Dan", "123");
        Contact mike = new Contact("Mike", "5456");
        Contact kate = new Contact("Kate", "890");
        contactRepo.add(dan);
        contactRepo.add(mike);
        contactRepo.add(kate);

        List<Contact> contacts = contactRepo.getAll();
        assertEquals(3, contacts.size());

        Contact danFromRepo = contacts.stream()
                .filter(contact -> contact.id == dan.id)
                .findFirst().get();

        Contact mikeFromRepo = contacts.stream()
                .filter(contact -> contact.id == mike.id)
                .findFirst().get();

        Contact kateFromRepo = contacts.stream()
                .filter(contact -> contact.id == kate.id)
                .findFirst().get();

        assertEquals(dan.name, danFromRepo.name);
        assertEquals(dan.number, danFromRepo.number);
        assertEquals(mike.name, mikeFromRepo.name);
        assertEquals(mike.number, mikeFromRepo.number);
        assertEquals(kate.name, kateFromRepo.name);
        assertEquals(kate.number, kateFromRepo.number);
    }

    @Test
    public void testGet_treeElements_exists(){
        Contact dan = new Contact("Dan", "123");
        Contact mike = new Contact("Mike", "5456");
        Contact kate = new Contact("Kate", "890");
        contactRepo.add(dan);
        contactRepo.add(mike);
        contactRepo.add(kate);

        Contact mikeFromRepo = contactRepo.getById(mike.id);

        assertEquals(mike.name, mikeFromRepo.name);
        assertEquals(mike.number, mikeFromRepo.number);
    }

    @Test
    public void testGet_treeElements_notExists(){
        Contact dan = new Contact("Dan", "123");
        Contact mike = new Contact("Mike", "5456");
        Contact kate = new Contact("Kate", "890");
        contactRepo.add(dan);
        contactRepo.add(mike);
        contactRepo.add(kate);

        Contact fromRepo = contactRepo.getById(-100);

        assertNull(fromRepo);
    }

    @Test
    public void testGet_treeElements_exist(){
        Contact dan = new Contact("Dan", "123");
        Contact mike = new Contact("Mike", "5456");
        Contact kate = new Contact("Kate", "890");
        contactRepo.add(dan);
        contactRepo.add(mike);
        contactRepo.add(kate);

        contactRepo.remove(dan.id);

        assertEquals(2, contactRepo.getAll().size());

        Contact danFromRepo = contactRepo.getById(dan.id);
        Contact mikeFromRepo = contactRepo.getById(mike.id);
        Contact kateFromRepo = contactRepo.getById(kate.id);

        assertNull(danFromRepo);

        assertEquals(mike.name, mikeFromRepo.name);
        assertEquals(mike.number, mikeFromRepo.number);
        assertEquals(kate.name, kateFromRepo.name);
        assertEquals(kate.number, kateFromRepo.number);
    }

    @Test
    public void testEdit_treeElements_exist(){
        Contact dan = new Contact("Dan", "123");
        Contact mike = new Contact("Mike", "5456");
        Contact kate = new Contact("Kate", "890");
        contactRepo.add(dan);
        contactRepo.add(mike);
        contactRepo.add(kate);

        Contact mikeToChange = new Contact("Spike", "2345");
        mikeToChange.id = mike.id;

        contactRepo.edit(mikeToChange);

        Contact mikeFromRepo = contactRepo.getById(mike.id);

        assertEquals(mikeToChange.name, mikeFromRepo.name);
        assertEquals(mikeToChange.number, mikeFromRepo.number);
    }
}