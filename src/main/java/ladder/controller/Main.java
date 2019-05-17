/*
 * @(#)Main.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.controller;

import ladder.model.game.LadderGame;
import ladder.model.ladder.Floor;
import ladder.model.tags.PlayerTags;
import ladder.model.tags.ResultTags;
import ladder.model.tags.Tag;
import ladder.view.InputView;
import ladder.view.OutputView;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class Main {
    /*사다리게임의 Controller역할을 하는 클래스*/
    private static final String EXIT = "exit";
    private static final String ALL = "all";

    public static void main(String[] args) {
        PlayerTags playerTags = getPlayerTags();
        ResultTags resultTags = getResultTags(playerTags.getTagsNumber());
        Floor floor = getFloor();
        LadderGame ladderGame = new LadderGame(playerTags, resultTags, floor);

        OutputView.PrintLadderTitle();
        OutputView.PrintTagsAndLadder(ladderGame);

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
            OutputView.PrintOneResult(ladderGame.getOneResultByTag(new Tag(choice)));
        }
    }

    private static String chooseAll(LadderGame ladderGame, String choice) {
        if (choice.equals(ALL)) {
            OutputView.PrintResultTitle();
            OutputView.PrintAllResult(ladderGame.getAllResults());
            choice = EXIT;
        }
        return choice;
    }
}
