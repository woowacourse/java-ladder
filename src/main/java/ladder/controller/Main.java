/*
 * @(#)Main.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */


package ladder.controller;

import ladder.domain.*;
import ladder.domain.ladder.Height;
import ladder.domain.LadderGame;
import ladder.domain.tag.Tag;
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
        PlayerTags players = getPlayers();
        ResultTags results = getResults(players.size());
        Height floors = getFloor();

        LadderGame ladderGame = new LadderGame(players, results, floors);

        OutputView.ladderTitle();
        OutputView.ladderShape(ladderGame);
        showResult(ladderGame);
    }

    private static PlayerTags getPlayers() {
        try {
            return new PlayerTags(InputView.players());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new PlayerTags(InputView.players());
        }
    }

    private static ResultTags getResults(int playerNumbers) {
        try {
            return new ResultTags(InputView.results(), playerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new ResultTags(InputView.results(), playerNumbers);
        }
    }

    private static Height getFloor() {
        try {
            return new Height(InputView.floors());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new Height(InputView.floors());
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
        String select = "";
        while (!select.equals(EXIT_CONDITION)) {
            select = InputView.resultSelect();
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
