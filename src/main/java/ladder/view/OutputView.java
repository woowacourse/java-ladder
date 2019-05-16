/*
 * @(#)OutputView.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */
package ladder.view;

import ladder.model.LadderGame;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class OutputView {
    /*사다리게임의 출력에 대한 클래스*/
    private static final String LADDER_TITLE_MESSAGE = "사다리 결과";
    private static final String RESULT_TITLE_MESSAGE = "실행 결과";

    public static void PrintLadderTitle() {
        System.out.println(LADDER_TITLE_MESSAGE);
    }

    public static void PrintLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void PrintResultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void PrintResult(String result) {
        System.out.println(result);
    }
}
