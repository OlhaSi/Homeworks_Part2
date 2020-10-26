package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//@Component
@Repository
public class MemoryContactRepo implements IContactRepo {

    private final List<Contact> contacts = new ArrayList<>();
    private static final AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(Contact contact) {
        contact.id = currentId.incrementAndGet();
        contacts.add(contact);
    }

    @Override
    public Contact getById(int id) {
        return contacts.stream()
                .filter(contact -> contact.id == id)
                .findFirst().orElse(null);

//        for (Contact contact : contacts) {
//            if (contact.id == id) {
//                return contact;
//            }
//        }
//        return null;
    }

    @Override
    public void edit(Contact contact) {
        Contact oldContact = getById(contact.id);

        if (oldContact == null)
            return;

        oldContact.name = contact.name;
        oldContact.number = contact.number;
    }

    @Override
    public List<Contact> getAll() {
        return Collections.unmodifiableList(contacts);
    }

    @Override
    public void remove(int id) {
        contacts.removeIf(contact -> contact.id == id);
    }
}
