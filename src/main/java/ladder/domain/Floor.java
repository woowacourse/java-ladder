/*
 * @(#)Floor.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 KwonMC and KimHG
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

/**
 * 사다리 높이를 위한 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Floor {
    private static final String NAT_NUM_EXCEPTION_MESSAGE = "층 수 0이하 입력 오류";
    private static final String VALID_TYPE_EXCEPTION_MESSAGE = "층 수 입력 형식 오류";

    private int number;

    public Floor(String input) {
        int number = checkValidType(input);
        checkNatNum(number);
        this.number = number;
    }

    private int checkValidType(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(VALID_TYPE_EXCEPTION_MESSAGE);
        }
        return number;
    }

    private void checkNatNum(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NAT_NUM_EXCEPTION_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
