package view;


import domain.Bridge;
import domain.Ladder;
import domain.Level;
import domain.Line;
import domain.Player;
import domain.Prize;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-----";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = " ";
    private static final String NAME_FORMAT = "%6s";
    private static final String PRIZE_FORMAT = "%-6s";
    private static final String ALL_RESULT_DELIMITER = " : ";
    private static final int OFFSET_COUNT = 5;

    public void printLadderGame(Ladder ladder, List<Player> players, List<Prize> prizes) {
        System.out.println("실행 결과");
        printPlayer(players);
        printLadder(ladder);
        printInputPrizes(prizes);
    }

    private void printPlayer(List<Player> players) {
        players.forEach(player -> System.out.print(String.format(NAME_FORMAT, player.getName())));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        Map<Level, Line> lines = ladder.getLines();
        lines.values().forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print(SPACE.repeat(OFFSET_COUNT));
        System.out.print(VERTICAL_DELIMITER);
        line.getBridges().values().forEach(this::printBridge);
        System.out.println();
    }

    private void printBridge(Bridge bridge) {
        if (bridge.isExist()) {
            System.out.print(HORIZON_DELIMITER);
            System.out.print(VERTICAL_DELIMITER);
            return;
        }
        System.out.print(SPACE.repeat(OFFSET_COUNT));
        System.out.print(VERTICAL_DELIMITER);
    }

    private void printInputPrizes(List<Prize> results) {
        results.forEach(result -> System.out.print(String.format(PRIZE_FORMAT, result.getPrize())));
        System.out.println();
    }

    public void printLadderResult(Map<Player, Prize> allResult) {
        allResult.forEach((key, value) -> System.out.println(
                String.format(key.getName() + ALL_RESULT_DELIMITER + value.getPrize())));
    }

    public void printLadderResult(Prize prize) {
        System.out.println(prize.getPrize());
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
