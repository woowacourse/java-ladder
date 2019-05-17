package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final String NEXT_LINE = "\n";
    private static final String DEFALT_LENGTH_FORMAT = "%-6s";

    private List<Player> players;
    private List<DrawResult> drawResults;
    private Ladder ladder;
    private List<Record> log;
    private GameResult gameResult;

    public LadderGame(String[] names, String[] drawResults, Ladder ladder) {
        checkCount(names.length, drawResults.length);

        this.players = Arrays.stream(names).map(Player::new).collect(Collectors.toList());;
        this.drawResults = Arrays.stream(drawResults).map(DrawResult::new).collect(Collectors.toList());
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

    public String drawResult(String message){
        return gameResult.getResult(message);
    }

    @Override
    public String toString() {
        return players.stream().map(player -> String.format(DEFALT_LENGTH_FORMAT, player.getName())).collect(Collectors.joining()) + NEXT_LINE
                + ladder.toString() + NEXT_LINE
                + drawResults.stream().map(drawResult -> String.format(DEFALT_LENGTH_FORMAT, drawResult.getResult())).collect(Collectors.joining());
    }
}
