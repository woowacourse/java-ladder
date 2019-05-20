package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPairs {
    private static final String NEW_LINE = "\n";

    final List<ResultPair> pairs;

    public ResultPairs(Players players, Rewards rewards, ResultIndex index) {
        pairs = Collections.unmodifiableList(index.getResultIndex().stream()
                .map(v -> new ResultPair<>(players.getPlayer(index.findIndex(v)), rewards.getReward(v)))
                .collect(Collectors.toList()));
    }

    public boolean hasName(String name) {
        return pairs.stream().filter(n -> n.matchName(name)).count() != 0;
    }

    public ResultPair findPlayer(String name) {
        return pairs.stream().filter(n -> n.matchName(name)).findAny().get();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ResultPair pair : pairs) {
            stringBuilder.append(pair.toString());
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}