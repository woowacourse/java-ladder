package dto;

import model.items.Item;
import model.people.Person;
import model.result.Result;

public record ResultDto(String personName, String itemName) {
    public static ResultDto from(final Result result) {
        Item item = result.getItem();
        Person person = result.getPerson();
        return new ResultDto(person.getName(), item.getName());
    }
}
