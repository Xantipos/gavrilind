package ru.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        var result = persons.stream().filter(
                person -> person.name.contains(key) | person.address.contains(key) | person.surname.contains(key) | person.phone.contains(key)
        ).collect(Collectors.toList());

        return result;
    }
}