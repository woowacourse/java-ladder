package ladder.domain.item;

import ladder.domain.LadderResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderItems {
    private final People people;
    private final WinningItems winningItems;

    public LadderItems(People people, WinningItems winningItems) {
        validateSize(people, winningItems);
        this.people = people;
        this.winningItems = winningItems;
    }

    private void validateSize(People people, WinningItems winningItems) {
        if (people.count() != winningItems.count()) {
            throw new IllegalArgumentException("사람의 수와 당첨 아이템의 개수는 동일해야 합니다.");
        }
    }

    public LadderResult mapResult(Map<Integer, Integer> climbResult) {
        return new LadderResult(climbResult.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> people.getByIndex(entry.getKey()),
                        entry -> winningItems.getByIndex(entry.getValue()))));
    }

    public int countItems() {
        return people.count();
    }

    public List<String> getPeopleNames() {
        return people.getPeopleNames();
    }

    public List<String> getWinningItemNames() {
        return winningItems.getWinningItemNames();
    }
}
