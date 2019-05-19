package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final String NEXT_LINE = "\n";


    private LadderGamePlayers players;
    private LadderGameRewards rewards;
    private Ladder ladder;
    private List<Record> log;
    private GameResult gameResult;

    public LadderGame(List<String> names, List<String> rewards, Ladder ladder) {
        checkCount(names.size(), rewards.size());

        this.players = new LadderGamePlayers(names);
        this.rewards = new LadderGameRewards(rewards);
        this.ladder = ladder;
        log = new ArrayList<>();
        gameResult = new GameResult();
    }

    private void checkCount(int countOfPlayers, int countOfResults) {
        if (countOfPlayers != countOfResults) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        log.add(new Record(Arrays.stream(IntStream.rangeClosed(0, players.size() - 1)
                .toArray())
                .boxed()
                .collect(Collectors.toList())));
        ladder.drawLadder(log);

        makeGameResult();
    }

    private void makeGameResult() {
        List<Integer> lastRecord = log.get(log.size() - 1).getIndices();

        for (int i = 0; i < players.size(); i++){
            gameResult.addGameResult(players.get(i), rewards.get(lastRecord.indexOf(i)));
        }
    }

    public String drawResult(String message){
        return gameResult.getResult(message);
    }

    @Override
    public String toString() {
        return players.toString() + NEXT_LINE
                + ladder.toString() + NEXT_LINE
                + rewards.toString();
    }
}
