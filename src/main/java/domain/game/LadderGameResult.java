package domain.game;

import domain.value.Name;
import domain.value.WinningEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LadderGameResult {
    private final Map<Name, WinningEntry> nameWinningEntryMap;

    public LadderGameResult(final Map<Name, WinningEntry> nameWinningEntryMap) {
        this.nameWinningEntryMap = nameWinningEntryMap;
    }

    public LadderGameResult(final Name name, final WinningEntry winningEntry) {
        this.nameWinningEntryMap = new HashMap<>();
        nameWinningEntryMap.put(name, winningEntry);
    }

    public Set<Name> names() {
        return nameWinningEntryMap.keySet();
    }

    public WinningEntry get(final Name name) {
        return nameWinningEntryMap.get(name);
    }
}
