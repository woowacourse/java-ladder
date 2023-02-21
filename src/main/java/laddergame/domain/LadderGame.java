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

    public Map<PersonalName, LadderResultItem> match(Ladder ladder) {
        Map<PersonalName, LadderResultItem> gameResult = new HashMap<>();

        List<String> names = personalNames.getNames();
        List<String> resultItems = ladderResult.getItemNames();

        for (int index = 0; index < names.size(); index++) {
            int current = index;
            for (final Line line : ladder.getLines()) {
                if (current < names.size() - 1 && line.doesRungExistsIndexOf(current)) {
                    current += 1;
                    continue;
                }
                if (current > 0 && line.doesRungExistsIndexOf(current - 1)) {
                    current -= 1;
                }
            }
            gameResult.put(new PersonalName(names.get(index)), new LadderResultItem(resultItems.get(current)));
        }

        return gameResult;
    }
}
