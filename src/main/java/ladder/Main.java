package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.nio.channels.SelectableChannel;

public class Main {
    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = getResults(players.getPlayerNumber());
        Floor floors = getFloor();

        LadderGame ladderGame = new LadderGame(players, results, floors);

        OutputView.resultLadderTitle();
        OutputView.resultLadder(ladderGame);
        try {
            selectResult(ladderGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectResult(ladderGame);
        }
    }

    private static Floor getFloor() {
        Floor floors;
        try {
            floors = InputView.inputFloorsMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            floors = InputView.inputFloorsMessage();
        }
        return floors;
    }

    private static Results getResults(int playerNumbers) {
        Results results;
        try {
            results = new Results(InputView.inputResultNamesMessage(), playerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            results = new Results(InputView.inputResultNamesMessage(), playerNumbers);
        }
        return results;
    }

    private static Players getPlayers() {
        Players players;
        try {
            players = new Players(InputView.inputPlayerNamesMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            players = new Players(InputView.inputPlayerNamesMessage());
        }
        return players;
    }

    private static void selectResult(LadderGame ladderGame) {
//        while (true) {
//            String select = InputView.inputSelectResultMessage();
//            OutputView.resultTitle();
//            if (select.equals("exit")) {
//                break;
//            }
//            if (!select.equals("all")) {
//                PlayerName selectName = new PlayerName(select);
//                OutputView.resultPrint(ladderGame.getOnePlayerResult(selectName));
//            }
//            if (select.equals("all")) {
//                OutputView.resultPrint(ladderGame.getAllPlayerResult());
//                break;
//            }
//        }
        String select = "";
        while (!select.equals("exit")) {
            select = InputView.inputSelectResultMessage();
            checkNotAll(ladderGame, select);
            select = checkAll(ladderGame, select);
        }
    }

    private static String checkAll(LadderGame ladderGame, String select) {
        if (select.equals("all")) {
            OutputView.resultTitle();
            OutputView.resultPrint(ladderGame.getAllPlayerResult());
            select = "exit";
        }
        return select;
    }

    private static void checkNotAll(LadderGame ladderGame, String select) {
        if (!select.equals("exit") && !select.equals("all")) {
            OutputView.resultTitle();
            PlayerName selectName = new PlayerName(select);
            OutputView.resultPrint(ladderGame.getOnePlayerResult(selectName));
        }
    }
}
