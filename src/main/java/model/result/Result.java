package model.result;

import java.util.Objects;
import model.items.Item;
import model.people.Person;

public class Result {
    private final Person person;
    private final Item item;

    public Result(final Person person, final Item item) {
        this.person = person;
        this.item = item;
    }

    public boolean isSamePerson(String personName) {
        return Objects.equals(person.getName(), personName);
    }

    public Item getItem() {
        return this.item;
    }

    public Person getPerson() {
        return this.person;
    }
}
