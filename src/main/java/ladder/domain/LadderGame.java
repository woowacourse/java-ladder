package ladder.domain;

import ladder.domain.creator.LadderCreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Ladder processGame(People people, LadderHeight ladderHeight) {
        return ladderCreator.create(calculateLadderWidth(people), ladderHeight.getValue());
    }

    private int calculateLadderWidth(People people) {
        return people.getCount() - 1;
    }

    public Map<String, String> findResult(Ladder ladder, People people, List<String> winningResults) {
        List<String> names = people.getNames();
        Map<Integer, Integer> result = climbAll(ladder, names.size());

        return result.entrySet().stream()
                .collect(Collectors.toMap(entry -> names.get(entry.getKey()), entry -> winningResults.get(entry.getValue())));
    }

    private Map<Integer, Integer> climbAll(Ladder ladder, int railCounts) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int railCount = 0; railCount < railCounts; railCount++) {
            result.put(railCount, ladder.climb(railCount));
        }

        return result;
    }
}
