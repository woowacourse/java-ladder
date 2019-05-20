package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class OutputView {
    public static final String ALL_USER = "all";

    private static final String GAME_START_RESULT_MSG = "\n실행결과";
    private static final String GAME_LADDER_RESULT_MSG = "\n사다리결과\n";
    private static final String COLON = " : ";
    private static final String LINE_COMPONENT = "|------";
    private static final String NONE_LINE_COMPONENT = "|      ";
    private static final String LADDER_VIEW_LENGTH = "%-7s";

    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println(GAME_LADDER_RESULT_MSG);
        Players players = ladderGame.getPlayers();
        Prizes prizes = ladderGame.getPrizes();
        printLadderGamePlayer(players);
        printLadder(ladderGame.getLadder());
        printLadderGamePrize(prizes);
    }

    private static void printLadderGamePrize(Prizes prizes) {
        for (Prize prize : prizes.getPrizes()) {
            System.out.printf(LADDER_VIEW_LENGTH, prize.getPrize());
        }
        System.out.println();
    }

    private static void printLadderGamePlayer(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf(LADDER_VIEW_LENGTH, player.getName());
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        for (Direction direction : line.getDirections()) {
            printLineComponent(direction);
        }
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
        System.out.println(matchedUserToPrize.get(new Player(name)).getPrize());
    }

    private static void printUsersResult(Map<Player, Prize> map) {
        for (Player key : map.keySet()) {
            System.out.println(key.getName() + COLON + map.get(key).getPrize());
        }
    }

    public static void showGameResult(LadderGameResult ladderGameResult) {
        String inputNameForResult;
        do {
            inputNameForResult = InputView.inputNameForResult();
            OutputView.printLadderGameResult(ladderGameResult, inputNameForResult);
        } while (!inputNameForResult.equals(OutputView.ALL_USER));
    }
}
