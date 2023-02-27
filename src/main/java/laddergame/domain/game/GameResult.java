package laddergame.domain.game;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import laddergame.domain.LadderResultItem;
import laddergame.domain.PersonalName;

public class GameResult {
    final private Map<PersonalName, LadderResultItem> nameToItem;

    public GameResult(Map<PersonalName, LadderResultItem> nameToItem) {
        this.nameToItem = nameToItem;
    }

    public LadderResultItem searchBy(String value) {
        PersonalName keyName = PersonalName.valueOf(value);
        if (!nameToItem.containsKey(keyName)) {
            throw new IllegalArgumentException("게임 참여자의 이름이 아닙니다.");
        }
        return nameToItem.get(keyName);
    }

    public Map<PersonalName, LadderResultItem> getNameToItem() {
        return nameToItem;
    }

    public List<List<String>> getResultItemsWithName() {
        return nameToItem.entrySet().stream()
                .map(nameToItem -> List.of(nameToItem.getKey().getValue(), nameToItem.getValue().getName()))
                .collect(Collectors.toList());
    }
}
