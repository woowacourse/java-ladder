package laddergame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final PersonalNames personalNames;
    private final LadderResult ladderResult;

    public LadderGame(PersonalNames personalNames, LadderResult ladderResult) {
        this.personalNames = personalNames;
        this.ladderResult = ladderResult;
    }

    public Map<String, String> match(Ladder ladder) {
        Map<String, String> gameResult = new HashMap<>();

        List<PersonalName> names = personalNames.getPersonalNames();
        List<LadderResultItem> resultItems = ladderResult.getResultItems();

        for (int index = 0; index < names.size(); index++) {
            int current = index;
            for (final Line line : ladder.getLines()) {
                current = move(line, current, names.size());
            }
            gameResult.put(names.get(index).getValue(), resultItems.get(current).getName());
        }

        return gameResult;
    }

    private int move(final Line line, final int current, final int limit) {
        if (current < limit - 1 && line.doesRungExistsIndexOf(current)) {
            return current + 1;

        }
        if (current > 0 && line.doesRungExistsIndexOf(current - 1)) {
            return current - 1;
        }
        return current;
    }
}
