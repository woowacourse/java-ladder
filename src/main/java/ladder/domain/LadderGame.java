package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private List<Player> players;
    private List<DrawResult> drawResults;
    private Ladder ladder;
    private List<Record> log;
    private GameResult gameResult;

    public LadderGame(List<Player> players, List<DrawResult> drawResults, Ladder ladder) {
        checkCount(players.size(), drawResults.size());
        this.players = players;
        this.drawResults = drawResults;
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
        log.add(new Record(Arrays.stream(IntStream.rangeClosed(0, players.size() - 1).toArray()).boxed().collect(Collectors.toList())));
        ladder.drawLadder(log);

        makeGameResult();

    }

    private void makeGameResult() {
        List<Integer> lastRecord = log.get(log.size() - 1).getIndices();

        for (int i = 0; i < players.size(); i++){
            gameResult.addGameResult(players.get(i), drawResults.get(lastRecord.indexOf(i)));
        }
    }

    String drawResult(String message){
        return gameResult.getResult(message);
    }

    @Override
    public String toString() {
        return players.stream().map(player -> String.format("%-6s", player.getName())).collect(Collectors.joining()) + "\n"
                + ladder.toString() + "\n"
                + drawResults.stream().map(drawResult -> String.format("%-6s", drawResult.getResult())).collect(Collectors.joining());
    }
}
