package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.items.Item;
import model.items.Items;
import model.people.People;
import model.people.Person;

public class Result {
    private final Map<Person, Item> matchedResult;

    protected Result(final Map<Person, Item> matchedResult) {
        this.matchedResult = matchedResult;
    }

    public static Result of(final People people, final List<Integer> resultIndexes, final Items items) {
        Map<Person, Item> personAndItemName = new LinkedHashMap<>();
        int personIndex = 0;
        for (int itemIndex : resultIndexes) {
            Person person = people.findBy(personIndex);
            Item item = items.findBy(itemIndex);
            personAndItemName.put(person, item);
            personIndex++;
        }
        return new Result(personAndItemName);
    }

    public Item findItemByPerson(final Person person) {
        validatePersonExist(person);
        return matchedResult.get(person);
    }

    private void validatePersonExist(final Person person) {
        if (!matchedResult.containsKey(person)) {
            throw new IllegalArgumentException("결과를 보려는 사람이 사다리 참여자에 존재하지 않습니다.");
        }
    }

    public Map<Person, Item> getMatchedResult() {
        return matchedResult;
    }
}
