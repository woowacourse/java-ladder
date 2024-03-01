package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderItems {
    private static final int MIN_ITEMS_SIZE = 2;

    private final List<Person> people;
    private final List<WinningItem> winningItems;

    private LadderItems(List<Person> people, List<WinningItem> winningItems) {
        validate(people, winningItems);
        this.people = people;
        this.winningItems = winningItems;
    }

    public static LadderItems of(List<String> peopleNames, List<String> winningItemNames) {
        List<Person> people = peopleNames.stream()
                .map(Person::new)
                .toList();
        List<WinningItem> winningItems = winningItemNames.stream()
                .map(WinningItem::new)
                .toList();

        return new LadderItems(people, winningItems);
    }

    private void validate(List<Person> people, List<WinningItem> winningItems) {
        validateMinSize(people);
        validateMinSize(winningItems);
    }

    private void validateMinSize(List<?> items) {
        if (items.size() < MIN_ITEMS_SIZE) {
            throw new IllegalArgumentException("사다리 게임의 아이템들의 개수는 각각 2개 이상이어야 합니다.");
        }
    }

    public Map<Person, WinningItem> mapResult(Map<Integer, Integer> result) {
        return result.entrySet().stream()
                .collect(Collectors.toMap(entry -> people.get(entry.getKey()), entry -> winningItems.get(entry.getValue())));
    }

    public int countItems() {
        return people.size();
    }
}
