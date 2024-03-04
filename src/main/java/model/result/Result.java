package model;

import model.items.Item;
import model.people.Person;

public class Result {
    private final Person person;
    private final Item item;

    public Result(final Person person, final Item item) {
        this.person = person;
        this.item = item;
    }
}
