package dto;

import java.util.HashMap;
import java.util.Map;
import model.items.Item;
import model.people.Person;
import model.result.Result;

public record ResultDto(Map<String, String> personAndItemName) {
    public static ResultDto from(final Result result) {
        Map<Person, Item> matchedResult = result.getMatchedResult();
        Map<String, String> matchedPersonAndItemNames = new HashMap<>();
        matchedResult.forEach((person, item) -> matchedPersonAndItemNames.put(person.getName(), item.getName()));
        return new ResultDto(matchedPersonAndItemNames);
    }

    public String getItemNameByPersonName(final String personName) {
        return personAndItemName.get(personName);
    }
}
