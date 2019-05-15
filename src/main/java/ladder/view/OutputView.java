package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(String name, Result result) {
        printResultMessage();
        System.out.println(result.getResult().get(name) + "\n");
    }

    public static void printResultAll(Result result) {
        printResultMessage();
        Map<String, String> a = result.getResult();
        for (Map.Entry<String, String> entry : a.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printLadderMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public static void printNames(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%s ", StringUtils.center(player.getName(), 5));
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        System.out.print("  |");
        for (Boolean point : line.getPoints()) {
            printPoint(point);
            System.out.print("|");
        }
        System.out.println();
    }

    private static void printPoint(Boolean point) {
        if (point) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }

    public static void printRewards(List<String> rewards) {
        for (String reward : rewards) {
            System.out.printf("%s ", StringUtils.center(reward, 5));
        }
        System.out.println("\n");
    }
}
