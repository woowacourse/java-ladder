/*
 * @(#)Height.java
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
 * 사다리 높이를 위한 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Height {
    private static final String NAT_NUM_EXCEPTION_MESSAGE = "층 수 0이하 입력 오류";
    private static final String VALID_TYPE_EXCEPTION_MESSAGE = "층 수 입력 형식 오류";

    private int floor;

    public Height(String input) {
        int number = validType(input);
        validRange(number);
        this.floor = number;
    }

    int getFloor() {
        return floor;
    }

    private int validType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(VALID_TYPE_EXCEPTION_MESSAGE);
        }
    }

    private void validRange(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NAT_NUM_EXCEPTION_MESSAGE);
        }
    }

}
