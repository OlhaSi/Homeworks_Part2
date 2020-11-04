package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * an instance of the class stores Person objects
 */

public interface IPersonRepo extends CrudRepository<Person, Integer> {

    Collection<Person> findAll();

    // select * from person p where p.name like 'Vasya'

    Collection<Person> findAllByName(String name);

    Collection<Person> findAllByAgeAfter(int age);

    Collection<Person> findAllByAgeBetween(int after, int before);

    // the same with another options
//    @Query("select p from Person p where p.age>=?1 and p.age<=?2")
//    Collection<Person> findAllByAgeBeforeTwoValues(int after, int before);

//    @Query("select p from Person p where p.age>=:after and p.age<=:before")
//    Collection<Person> findAllByAgeBeforeTwoValues(@Param("after") int after, @Param("before") int before);

    Collection<Person> findAllBySecondNameContaining(String part);

}
