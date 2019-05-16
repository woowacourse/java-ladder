package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    private static final String EXIT = "exit";
    private static final String ALL = "all";

    public static void main(String[] args) {
        PlayerTags playerTags = getPlayerTags();
        ResultTags resultTags = getResultTags(playerTags.getTagsNumber());
        Floor floor = getFloor();
        LadderGame ladderGame = new LadderGame(playerTags, resultTags, floor);

        OutputView.PrintLadderTitle();
        OutputView.PrintLadder(ladderGame);

        showResult(ladderGame);
    }

    private static PlayerTags getPlayerTags() {
        try {
            return new PlayerTags(InputView.inputPlayers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerTags();
        }
    }

    private static ResultTags getResultTags(int tagsNumber) {
        try {
            return new ResultTags(InputView.inputResults(), tagsNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResultTags(tagsNumber);
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
            chooseResult(ladderGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            showResult(ladderGame);
        }
    }

    private static void chooseResult(LadderGame ladderGame) {
        String choice = "";
        while (!choice.equals(EXIT)) {
            choice = InputView.inputChoice();
            chooseOne(ladderGame, choice);
            choice = chooseAll(ladderGame, choice);
        }
    }

    private static void chooseOne(LadderGame ladderGame, String choice) {
        if (!choice.equals(EXIT) && !choice.equals(ALL)) {
            OutputView.PrintResultTitle();
            OutputView.PrintResult(ladderGame.getOneResultByTag(new Tag(choice)));
        }
    }

    private static String chooseAll(LadderGame ladderGame, String choice) {
        if (choice.equals(ALL)) {
            OutputView.PrintResultTitle();
            OutputView.PrintResult(ladderGame.getAllResults());
            choice = EXIT;
        }
        return choice;
    }
}
