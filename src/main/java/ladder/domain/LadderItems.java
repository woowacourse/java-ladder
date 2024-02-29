package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderItems {
    private final List<Person> people;
    private final List<WinningItem> winningItems;

    public LadderItems(List<Person> people, List<WinningItem> winningItems) {
        this.people = people;
        this.winningItems = winningItems;
    }

    public Map<Person, WinningItem> mapResult(Map<Integer, Integer> result) {
        return result.entrySet().stream()
                .collect(Collectors.toMap(entry -> people.get(entry.getKey()), entry -> winningItems.get(entry.getValue())));
    }

    public int countItems() {
        return people.size();
    }
}
