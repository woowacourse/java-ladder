package ladder.domain;

import ladder.domain.item.Person;
import ladder.domain.item.WinningItem;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Person, WinningItem> result;

    public LadderResult(Map<Person, WinningItem> result) {
        this.result = new HashMap<>(result);
    }

    public WinningItem findWinningItemByPersonName(String personName) {
        return result.get(new Person(personName));
    }
}
