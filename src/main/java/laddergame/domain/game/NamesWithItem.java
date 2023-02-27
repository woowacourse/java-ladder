package laddergame.domain.game;

import java.util.Map;
import laddergame.domain.LadderResultItem;
import laddergame.domain.PersonalName;

public class NamesWithItem {
    final private Map<PersonalName, LadderResultItem> nameToItem;

    public NamesWithItem(Map<PersonalName, LadderResultItem> nameToItem) {
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
}
