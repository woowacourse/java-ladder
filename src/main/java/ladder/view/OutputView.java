package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String ALL_USER = "all";

    private static final String GAME_START_RESULT_MSG = "\n실행결과";
    private static final String GAME_LADDER_RESULT_MSG = "\n사다리결과\n";
    private static final String COLON = " : ";
    private static final String LINE_COMPONENT = "|------";
    private static final String NONE_LINE_COMPONENT = "|      ";
    private static final String PRINT_FORMAT = "%-7s";


    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println(GAME_LADDER_RESULT_MSG);
        List<Player> players = ladderGame.getPlayers();
        printPlayerName(players);

        printLadder(ladderGame.getLadder());

        List<Prize> prizes = ladderGame.getPrizes();
        printPrizeName(prizes);
    }

    private static void printPlayerName(List<Player> players) {
        players.forEach(player -> System.out.printf(PRINT_FORMAT, player.getName()));
        System.out.println();
    }

    private static void printPrizeName(List<Prize> prizes) {
        prizes.forEach(prize -> System.out.printf(PRINT_FORMAT, prize.getPrizeName()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(line -> printLine(line));
    }

    private static void printLine(Line line) {
        Arrays.stream(line.getPoints())
                .forEach(direction -> printLineComponent(direction));
        System.out.println();
    }

    private static void printLineComponent(Direction direction) {
        if (direction == Direction.RIGHT) {
            System.out.print(LINE_COMPONENT);
            return;
        }
        System.out.print(NONE_LINE_COMPONENT);
    }


    public static void printLadderGameResult(LadderGameResult ladderGameResult, String name) {
        System.out.println(GAME_START_RESULT_MSG);
        Map<Player, Prize> matchedUserToPrize = ladderGameResult.getNameToPrize();
        if (name.equals(ALL_USER)) {
            printUsersResult(matchedUserToPrize);
            return;
        }
        System.out.println(matchedUserToPrize.get(new Player(name)).getPrizeName());
    }

    private static void printUsersResult(Map<Player, Prize> matchedUserToPrize) {
        matchedUserToPrize.keySet()
                .forEach(key -> System.out.println(key.getName() + COLON + matchedUserToPrize.get(key).getPrizeName()));
    }
}
