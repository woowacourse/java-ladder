/*
 * @(#)Main.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 KwonMC and KimHG
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */


package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

/**
 * View 와 Model 의 매개를 담당하는 컨트롤러 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Main {
    private static final String EXIT_CONDITION = "exit";
    private static final String ALL_CONDITION = "all";

    public static void main(String[] args) {
        PlayerTags playerTags = getPlayers();
        ResultTags results = getResults(playerTags.size());
        Floor floors = getFloor();

        LadderGame ladderGame = new LadderGame(playerTags, results, floors);

        OutputView.resultLadderTitle();
        OutputView.resultLadder(ladderGame);
        showResult(ladderGame);
    }

    private static PlayerTags getPlayers() {
        PlayerTags playerTags;
        try {
            playerTags = new PlayerTags(InputView.playerNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            playerTags = new PlayerTags(InputView.playerNames());
        }
        return playerTags;
    }

    private static ResultTags getResults(int playerNumbers) {
        ResultTags results;
        try {
            results = new ResultTags(InputView.resultNames(), playerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            results = new ResultTags(InputView.resultNames(), playerNumbers);
        }
        return results;
    }

    private static Floor getFloor() {
        Floor floors;
        try {
            floors = new Floor(InputView.floors());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            floors = new Floor(InputView.floors());
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
            select = InputView.selectResult();
            chooseOne(ladderGame, select);
            select = chooseAll(ladderGame, select);
        }
    }

    private static String chooseAll(LadderGame ladderGame, String select) {
        if (select.equals(ALL_CONDITION)) {
            OutputView.resultTitle();
            OutputView.resultPrint(ladderGame.getAllPlayerResult());
            select = EXIT_CONDITION;
        }
        return select;
    }

    private static void chooseOne(LadderGame ladderGame, String select) {
        if (!select.equals(EXIT_CONDITION) && !select.equals(ALL_CONDITION)) {
            OutputView.resultTitle();
            Tag selectTag = new Tag(select);
            OutputView.resultPrint(ladderGame.getOnePlayerResult(selectTag));
        }
    }
}
