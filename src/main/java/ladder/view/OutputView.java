package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.Line;

import java.util.Map;

public class OutputView {

    public static final String ALL_USER = "all";

    private static final String GAME_START_RESULT_MSG = "\n실행결과";
    private static final String GAME_LADDER_RESULT_MSG = "\n사다리결과\n";
    private static final String COLON = " : ";
    private static final String LINE_COMPONENT = "|------";
    private static final String NONE_LINE_COMPONENT = "|      ";


    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println(GAME_LADDER_RESULT_MSG);
        String[] names = ladderGame.getNames();
        String[] prizes = ladderGame.getPrizes();
        printLadderGameComponent(names);
        printLadder(ladderGame.getLadder());
        printLadderGameComponent(prizes);
    }

    private static void printLadderGameComponent(String[] components) {
        for (String component : components) {
            System.out.printf("%-7s", component);
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        for (int point : line.getPoints()) {
            printLineComponent(point);
        }
        System.out.println();
    }

    private static void printLineComponent(int point) {
        if (point == 1) {
            System.out.print(LINE_COMPONENT);
            return;
        }
        System.out.print(NONE_LINE_COMPONENT);
    }


    public static void printLadderGameResult(LadderGameResult ladderGameResult, String name) {
        System.out.println(GAME_START_RESULT_MSG);
        Map<String, String> map = ladderGameResult.getNameToPrize();
        if (name.equals(ALL_USER)) {
            printUsersResult(map);
            return;
        }
        System.out.println(map.get(name));
    }

    private static void printUsersResult(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + COLON + map.get(key));
        }
    }
}
