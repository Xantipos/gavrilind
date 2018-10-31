package ru.search;

import java.util.ArrayList;
import java.util.List;

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
        List<Person> result = new ArrayList<>();
        for (Person s: persons) {
            if (s.getName().contains(key) | s.getAddress().contains(key) | s.getPhone().contains(key) | s.getSurname().contains(key)) {
                result.add(s);
            }
        }
        return result;
    }
}