package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    private static final String EXIT_CONDITION = "exit";
    private static final String ALL_CONDITION = "all";

    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = getResults(players.getPlayerNumber());
        Floor floors = getFloor();

        LadderGame ladderGame = new LadderGame(players, results, floors);

        OutputView.resultLadderTitle();
        OutputView.resultLadder(ladderGame);
        showResult(ladderGame);
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

    private static void showResult(LadderGame ladderGame) {
        try {
            selectResult(ladderGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectResult(ladderGame);
        }
    }

    private static void selectResult(LadderGame ladderGame) {
        String select = "";
        while (!select.equals(EXIT_CONDITION)) {
            select = InputView.inputSelectResultMessage();
            checkNotAll(ladderGame, select);
            select = checkAll(ladderGame, select);
        }
    }

    private static String checkAll(LadderGame ladderGame, String select) {
        if (select.equals(ALL_CONDITION)) {
            OutputView.resultTitle();
            OutputView.resultPrint(ladderGame.getAllPlayerResult());
            select = EXIT_CONDITION;
        }
        return select;
    }

    private static void checkNotAll(LadderGame ladderGame, String select) {
        if (!select.equals(EXIT_CONDITION) && !select.equals(ALL_CONDITION)) {
            OutputView.resultTitle();
            PlayerName selectName = new PlayerName(select);
            OutputView.resultPrint(ladderGame.getOnePlayerResult(selectName));
        }
    }
}
