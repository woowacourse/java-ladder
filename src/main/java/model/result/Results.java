package model.result;

import java.util.ArrayList;
import java.util.List;
import model.Index;
import model.MatchedIndex;
import model.items.Item;
import model.items.Items;
import model.people.People;
import model.people.Person;

public class Results {
    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public static Results of(final People people, final List<MatchedIndex> resultIndexes, final Items items) {
        List<Result> results = new ArrayList<>();
        Index personIndex = new Index(0);

        for (MatchedIndex matchedIndex : resultIndexes) {
            Person person = people.findBy(matchedIndex.startIndex());
            Item item = items.findBy(matchedIndex.finalIndex());
            results.add(new Result(person, item));
            personIndex = personIndex.getNext();
        }
        return new Results(results);
    }

    public Item findItemByPerson(final String personName) {
        Result findResult = results.stream()
                .filter(result -> result.isSamePerson(personName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 사람의 결과가 존재하지 않습니다."));
        return findResult.getItem();
    }

    public List<Result> getResults() {
        return results;
    }
}
