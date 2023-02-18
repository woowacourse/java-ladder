package controller.response;

import domain.value.Name;
import domain.value.WinningEntry;

import java.util.Map;

public class GoDownLadderResponse {

    private final Map<Name, WinningEntry> nameWinningEntryMap;

    public GoDownLadderResponse(final Map<Name, WinningEntry> nameWinningEntryMap) {
        this.nameWinningEntryMap = nameWinningEntryMap;
    }

    public Map<Name, WinningEntry> nameWinningEntryMap() {
        return nameWinningEntryMap;
    }
}
