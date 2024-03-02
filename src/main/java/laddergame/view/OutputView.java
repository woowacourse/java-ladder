package laddergame.view;

import java.util.List;
import java.util.Map;
import laddergame.domain.Game;
import laddergame.domain.GameResult;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Stick;

public class OutputView {

    private static final String FILLED_STICK_SHAPE = "-";
    private static final String NOT_FILLED_STICK_SHAPE = " ";

    public void printLadder(Game game) {
        System.out.println("사다리 결과");

        printPlayerNames(game.getPlayerNames());
        printLadder(game.getLadder());
        printGameResults(game.getGameResults());
    }

    private void printPlayerNames(List<String> playerNames) {
        playerNames.forEach(this::printEachPlayerName);

        System.out.println();
    }

    private void printEachPlayerName(String playerName) {
        System.out.printf("%5s ", playerName);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        List<Stick> sticks = line.getSticks();
        for (Stick stick : sticks) {
            String shape = getStickShape(stick);
            sb.append(shape.repeat(5));
            sb.append("|");
        }

        System.out.printf("     |%s%n", sb);
    }

    private String getStickShape(Stick stick) {
        if (stick.isFilled()) {
            return FILLED_STICK_SHAPE;
        }

        return NOT_FILLED_STICK_SHAPE;
    }

    private void printGameResults(List<GameResult> gameResults) {
        gameResults.forEach(gameResult -> System.out.printf("%5s ", gameResult.getName()));
        System.out.println();
    }

    public void printResult(GameResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getName());
    }

    public void printResultAll(Map<String, GameResult> result) {
        result.forEach(this::printEachPlayerResult);
    }

    private void printEachPlayerResult(String playerName, GameResult gameResult) {
        System.out.printf("%s : %s%n", playerName, gameResult.getName());
    }
}
