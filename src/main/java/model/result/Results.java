package model.result;

import java.util.List;
import model.items.Item;
import model.people.Person;

public class Results {
    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public Item findItemByPerson(final Person person) {
        Result findResult = results.stream()
                .filter(result -> result.isSamePerson(person))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 사람의 결과가 존재하지 않습니다."));
        return findResult.getItem();
    }
}
