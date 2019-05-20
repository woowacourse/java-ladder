/*
 * @(#)OutputView.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.view;

import java.util.Map;

import ladder.domain.GameResult;
import ladder.domain.LadderGame;
import ladder.domain.PlayerTags;
import ladder.domain.ResultTags;
import ladder.domain.ladder.Ladder;
import ladder.domain.tag.Tag;

/**
 * 사다리 게임 출력을 담당하는 View 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class OutputView {
    private static final String LADDER_TITLE = "사다리 결과";
    private static final String RESULT_TITLE = "실행 결과";

    public static void ladderTitle() {
        System.out.println(LADDER_TITLE);
    }

    public static void ladderBody(LadderGame ladderGame) {
        ladderPlayers(ladderGame.getPlayers());
        ladderShape(ladderGame.getLadder());
        ladderResults(ladderGame.getResults());
    }

    private static void ladderPlayers(PlayerTags playerTags) {
        System.out.println(playerTags.toString());
    }

    private static void ladderShape(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    private static void ladderResults(ResultTags resultTags) {
        System.out.println(resultTags.toString());
    }

    public static void resultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void resultPrint(String result) {
        System.out.println(result);
    }

    public static void resultPrint2(GameResult gameResult) {
        for (Map.Entry<Tag, Tag> map : gameResult) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }
}
