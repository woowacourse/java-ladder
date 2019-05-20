/*
 * @(#)LadderHeight.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain.ladder;

/**
 * 사다리 높이 래퍼 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class LadderHeight {
    private static final String NAT_NUM_EXCEPTION_MESSAGE = "층 수 0이하 입력 오류";
    private static final String VALID_TYPE_EXCEPTION_MESSAGE = "층 수 입력 형식 오류";
    private static final int MINIMUM_RANGE = 0;

    private int height;

    public LadderHeight(String input) {
        int number = validType(input);
        validRange(number);
        this.height = number;
    }

    int getHeight() {
        return height;
    }

    private int validType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(VALID_TYPE_EXCEPTION_MESSAGE);
        }
    }

    private void validRange(int number) {
        if (number <= MINIMUM_RANGE) {
            throw new IllegalArgumentException(NAT_NUM_EXCEPTION_MESSAGE);
        }
    }
}
