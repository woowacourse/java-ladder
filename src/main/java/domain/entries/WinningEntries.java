package domain.entries;

import java.util.List;
import java.util.stream.Collectors;

public class WinningEntries {

    private final List<WinningEntry> winningEntries;

    private WinningEntries(List<WinningEntry> winningEntries) {
        this.winningEntries = winningEntries;
    }

    public static WinningEntries from(List<String> entryValues) {
        List<WinningEntry> winningEntries = entryValues.stream().map(WinningEntry::new)
                .collect(Collectors.toUnmodifiableList());
        return new WinningEntries(winningEntries);
    }

    public List<String> getEntryValues() {
        return winningEntries.stream()
                .map(WinningEntry::getValue)
                .collect(Collectors.toList());
    }
}
