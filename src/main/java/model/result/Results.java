package model.result;

import java.util.ArrayList;
import java.util.List;
import model.Index;
import model.items.Item;
import model.items.Items;
import model.people.People;
import model.people.Person;

public class Results {
    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public static Results of(final People people, final List<Index> resultIndexes, final Items items) {
        List<Result> results = new ArrayList<>();
        Index personIndex = new Index(0);
        for (Index itemIndex : resultIndexes) {
            Person person = people.findBy(personIndex);
            Item item = items.findBy(itemIndex);
            results.add(new Result(person, item));
            personIndex = personIndex.getNext();
        }
        return new Results(results);
    }

    public Item findItemByPerson(final Person person) {
        Result findResult = results.stream()
                .filter(result -> result.isSamePerson(person))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 사람의 결과가 존재하지 않습니다."));
        return findResult.getItem();
    }
}
