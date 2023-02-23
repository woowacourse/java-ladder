package domain;

import java.util.HashMap;
import java.util.Map;
import view.OutputView;

public class LadderGame {

    private final Players playersInGame;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(Players players, Ladder ladder, Results results) {
        this.playersInGame = new Players(players.getPlayers());
        this.ladder = ladder;
        this.results = results;
    }

    public void printLadder() {
        OutputView.printLadderMessage();
        OutputView.printPlayers(playersInGame);
        OutputView.printLadder(ladder);
        OutputView.printLadderResult(results);
    }

    public void playGame() {
        for (Line line : ladder.getLines().getLines()) {
            crossLadder(line);
        }
    }

    private void crossLadder(Line line) {
        for (int index = 0; index < line.getLine().size(); index++) {
            changePosition(line, index);
        }
    }

    private void changePosition(Line line, int index) {
        if (line.getLine().get(index).getStatus()) {
            playersInGame.changePosition(index, index + 1);
        }
    }

    public Map<Player, String> getLadderGameResult() {
        Map<Player, String> ladderGameResult = new HashMap<>();

        for (int index = 0; index < playersInGame.getNumberOfPlayers(); index++) {
            ladderGameResult.put(playersInGame.getPlayers().get(index), results.getResultByIndex(index));
        }

        return ladderGameResult;
    }

    public void printResult2() {
        for (Player player : playersInGame.getPlayers()) {
            System.out.println(player.getName());
        }
    }
}
