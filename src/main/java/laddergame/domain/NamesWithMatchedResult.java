package laddergame.domain;

import java.util.Map;

public class NamesWithMatchedResult {
    final private Map<PersonalName, LadderResultItem> nameToItem;

    public NamesWithMatchedResult(Map<PersonalName, LadderResultItem> nameToItem) {
        this.nameToItem = nameToItem;
    }

    public LadderResultItem searchBy(String value) {
        PersonalName keyName = PersonalName.valueOf(value);
        return nameToItem.get(keyName);
    }
}
