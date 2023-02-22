package domain.value;

import java.util.ArrayList;
import java.util.List;

public class WinningEntries {

    private static final int MIN_ENTRY_COUNT_INCLUSIVE = 2;

    private final List<WinningEntry> winningEntries;

    private WinningEntries(final List<WinningEntry> winningEntries) {
        validateSize(winningEntries);
        this.winningEntries = new ArrayList<>(winningEntries);
    }

    private void validateSize(final List<WinningEntry> winningEntries) {
        if (winningEntries.size() < MIN_ENTRY_COUNT_INCLUSIVE) {
            throw new IllegalArgumentException("당첨 항목의 수는 2개 이상이어야 합니다.");
        }
    }

    public static WinningEntries forNames(final List<WinningEntry> winningEntries, final Names names) {
        validateWinningEntryAndNameCountIsSame(winningEntries, names);
        return new WinningEntries(winningEntries);
    }

    private static void validateWinningEntryAndNameCountIsSame(final List<WinningEntry> winningEntries, final Names names) {
        if (names.size() != winningEntries.size()) {
            throw new IllegalArgumentException("당첨 항목의 수는 이름의 수와 동일해야 합니다");
        }
    }

    public List<WinningEntry> winningEntries() {
        return new ArrayList<>(winningEntries);
    }

    public int size() {
        return winningEntries.size();
    }

    public WinningEntry get(final int value) {
        return winningEntries.get(value);
    }
}
