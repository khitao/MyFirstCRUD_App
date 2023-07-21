package ru.khodov.springg.dao;

import org.springframework.stereotype.Component;
import ru.khodov.springg.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {

    private static int PEOPLE_COUNT;
    private List<Person> persons;

    {
        persons = new ArrayList<>();

        persons.add(new Person(++PEOPLE_COUNT, "Nikita"));
        persons.add(new Person(++PEOPLE_COUNT, "Max"));
        persons.add(new Person(++PEOPLE_COUNT, "Sasha"));
        persons.add(new Person(++PEOPLE_COUNT, "Kostia"));
    }

    public List<Person> index() {
        return persons;
    }

    public Person show(int id) {
        return persons.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        persons.add(person);
    }

    public void update(Person person, int id) {
        Person personChange = show(id);
        personChange.setName(person.getName());
    }


    public void delete(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
