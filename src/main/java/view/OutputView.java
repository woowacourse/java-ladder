package view;

import java.util.List;
import java.util.Map;
import domain.Game;
import domain.GameResult;
import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Stick;

public class OutputView {

    public void printLadder(Game game) {
        System.out.println("실행결과");

        printPlayerNames(game.getPlayers());
        printLadder(game.getLadder());
        printGameResults(game.getGameResults());
    }

    private void printPlayerNames(Players players) {
        players.getPlayers().forEach(this::printEachPlayerName);

        System.out.println();
    }

    private void printEachPlayerName(Player player) {
        System.out.printf("%5s ", player.getName());
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        List<Stick> sticks = line.getSticks();
        for (Stick stick : sticks) {
            String shape = stick.getShape();
            sb.append(shape.repeat(5));
            sb.append("|");
        }

        System.out.printf("     |%s%n", sb);
    }

    private void printGameResults(List<GameResult> gameResults) {
        gameResults.forEach(gameResult -> System.out.printf("%-5s", gameResult.getName()));
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
