package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Ladder ladder;
    private List<Record> log;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
        log = new ArrayList<>();
    }

    public GameResult play(List<Player> players, List<DrawResult> drawResults) {
        checkCount(players.size(), drawResults.size());

        log.add(new Record(initialValue(players.size())));
        log = ladder.drawLadder(log);

        return new GameResult(makeGameResult(players, drawResults));
    }

    private void checkCount(int countOfPlayers, int countOfResults) {
        if (countOfPlayers != countOfResults) {
            throw new IllegalArgumentException();
        }
    }

    private List initialValue(int size) {
        return Arrays.stream(IntStream.rangeClosed(0, size - 1)
                .toArray())
                .boxed()
                .collect(Collectors.toList());
    }

    private Map<Player, DrawResult> makeGameResult(List<Player> players, List<DrawResult> drawResults) {
        List<Integer> lastRecord = log.get(log.size() - 1).getIndices();
        Map<Player, DrawResult> results = new HashMap<>();

        for (int i = 0; i < players.size(); i++) {
            results.put(players.get(i), drawResults.get(lastRecord.indexOf(i)));
        }
        return results;
    }

}