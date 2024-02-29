package dto;

import java.util.Map;
import model.Items;
import model.Ladder;
import model.People;

public record Result(Map<String, String> personAndItemName) {
    public static Result from(final People people, final Ladder ladder, final Items items) {
        Map<String, String> matchedPersonAndItemNames = ladder.match(people, items);
        return new Result(matchedPersonAndItemNames);
    }

    public String getItemNameByPersonName(final String personName) {
        return personAndItemName.get(personName);
    }
}
