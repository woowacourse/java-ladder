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
import ladder.domain.ladder.LadderHeight;
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
        LadderHeight floors = getFloor();

        LadderGame ladderGame = new LadderGame(players, results, floors);
        GameResult gameResult = ladderGame.getAllResult();

        OutputView.ladderTitle();
        OutputView.ladderBody(ladderGame);
        showResult(gameResult);
    }

    private static PlayerTags getPlayers() {
        try {
            return new PlayerTags(InputView.players());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }

    private static ResultTags getResults(int playerNumbers) {
        try {
            return new ResultTags(InputView.results(), playerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResults(playerNumbers);
        }
    }

    private static LadderHeight getFloor() {
        try {
            return new LadderHeight(InputView.floors());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getFloor();
        }
    }

    private static void showResult(GameResult gameResult) {
        try {
            chooseResult(gameResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            showResult(gameResult);
        }
    }

    private static void chooseResult(GameResult gameResult) {
        String select = "";
        while (!select.equals(EXIT_CONDITION)) {
            select = InputView.resultSelect();
            chooseOne(gameResult, select);
            select = chooseAll(gameResult, select);
        }
    }

    private static String chooseAll(GameResult gameResult, String select) {
        if (select.equals(ALL_CONDITION)) {
            OutputView.resultTitle();
            OutputView.resultGameResult(gameResult);
            select = EXIT_CONDITION;
        }
        return select;
    }

    private static void chooseOne(GameResult gameResult, String select) {
        if (!select.equals(EXIT_CONDITION) && !select.equals(ALL_CONDITION)) {
            OutputView.resultTitle();
            OutputView.resultOneResult(gameResult.get(new Tag(select)));
        }
    }
}
