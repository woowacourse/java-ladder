package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Person, Item> matchedResult;

    public Result(final Map<Person, Item> matchedResult) {
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
        if (!matchedResult.containsKey(person)) {
            throw new IllegalArgumentException("결과를 보려는 사람이 사다리 참여자에 존재하지 않습니다.");
        }
        return matchedResult.get(person);
    }

    public Map<Person, Item> getMatchedResult() {
        return matchedResult;
    }
}
