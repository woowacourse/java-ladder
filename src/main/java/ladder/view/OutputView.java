/*
 * @(#)OutputView.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package ladder.view;

import ladder.domain.LadderGame;

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

    public static void resultLadderTitle() {
        System.out.println(LADDER_TITLE);
    }

    public static void resultLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void resultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void resultPrint(String result) {
        System.out.println(result);
    }
}
