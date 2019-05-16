package ladder.controller;

import ladder.model.*;
import ladder.model.frame.Input;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.function.Function;

public class Main {
    private static final String EXIT_CONDITION = "exit";
    private static final String ALL_CONDITION = "all";

    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = getResults(players.getPlayerNumber());
        Floor floors = getFloor();
        LadderGame ladderGame = new LadderGame(players, results, floors);

        OutputView.PrintLadderTitle();
        OutputView.PrintLadder(ladderGame);

        showResult(ladderGame);
    }

    private static Players getPlayers() {
        try {
            return new Players(InputView.inputPlayers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }

    private static Results getResults(int playerNumbers) {
        try {
            return new Results(InputView.inputResults(), playerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResults(playerNumbers);
        }
    }

    private static Floor getFloor() {
        try {
            return InputView.inputFloors();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getFloor();
        }
    }

    private static void showResult(LadderGame ladderGame) {
        try {
            selectResult(ladderGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            showResult(ladderGame);
        }
    }

    private static void selectResult(LadderGame ladderGame) {
        String select = "";
        while (!select.equals(EXIT_CONDITION)) {   //select가 "exit"이 아닐 때까지 반복
            select = InputView.inputSelect();      //select를 받음
            checkNotAll(ladderGame, select);       //select가 "all"이 아닌지 검사 후 아니면 해당로직 실행
            select = checkAll(ladderGame, select); //select가 "all"인지 검사 후 맞으면 해당로직 실행
        }
    }

    private static void checkNotAll(LadderGame ladderGame, String select) {
        if (!select.equals(EXIT_CONDITION) && !select.equals(ALL_CONDITION)) {
            OutputView.PrintResultTitle();
            PlayerName selectName = new PlayerName(select);
            OutputView.PrintResult(ladderGame.getOnePlayerResult(selectName));
        }
    }

    private static String checkAll(LadderGame ladderGame, String select) {
        if (select.equals(ALL_CONDITION)) {
            OutputView.PrintResultTitle();
            OutputView.PrintResult(ladderGame.getAllPlayerResult());
            select = EXIT_CONDITION;
        }
        return select;
    }
}
