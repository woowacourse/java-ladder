package model.result;

import model.items.Item;
import model.people.Person;

public class Result {
    private final Person person;
    private final Item item;

    public Result(final Person person, final Item item) {
        this.person = person;
        this.item = item;
    }

    public boolean isSamePerson(Person person) {
        return this.person.equals(person);
    }

    public Item getItem() {
        return this.item;
    }
}
