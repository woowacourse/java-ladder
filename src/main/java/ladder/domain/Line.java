/*
 * @(#)Line.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 사다리 가로줄을 담당하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Line {
    private static final String HEADER_HORIZONTAL_LINE = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String NEW_LINE = "\n";
    private static final String NO_HORIZONTAL_LINE = "     ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String HORIZONTAL_DUPLICATION_ERROR = "가로선 중복 오류";

    private List<Boolean> horizontal;

    public Line(int playerNumber) {
        horizontal = new ArrayList<>();
        generateLine(playerNumber);
    }

    private void generateLine(int playerNumber) {
        for (int i = 0; i < playerNumber - 1; i++) {
            horizontal.add(getProperBoolean(i));
        }
    }

    public Line(List<Boolean> horizontal) {
        checkAdjacent(horizontal);
        this.horizontal = horizontal;
    }

    public List<Boolean> getHorizontal() {
        return this.horizontal;
    }

    private void checkAdjacent(List<Boolean> horizontal) {
        for (int i = 0; i < horizontal.size() - 1; i++) {
            validAdjacent(horizontal, i);
        }
    }

    private void validAdjacent(List<Boolean> horizontal, int index) {
        if (horizontal.get(index) && horizontal.get(index + 1)) {
            throw new IllegalArgumentException(HORIZONTAL_DUPLICATION_ERROR);
        }
    }


    private Boolean getProperBoolean(int index) {
        Random random = new Random();
        if (index == 0) {
            return random.nextBoolean();
        }
        if (!this.horizontal.get(index - 1)) {
            return random.nextBoolean();
        }
        return false;
    }

    private String toStringEachHorLine(Boolean bool) {
        return bool ? HORIZONTAL_LINE : NO_HORIZONTAL_LINE;
    }

    public int moveHorizontal(int index) {
        if (canMoveLeft(index)) {
            return moveLeft(index);
        }
        if (canMoveRight(index)) {
            return moveRight(index);
        }
        return index;
    }
    private boolean canMoveLeft(int index) {
        return index > 0 && this.horizontal.get(index - 1);
    }

    private int moveLeft(int index) {
        return index - 1;
    }

    private boolean canMoveRight(int index) {
        return index < horizontal.size() && this.horizontal.get(index);
    }

    private int moveRight(int index) {
        return index + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER_HORIZONTAL_LINE);
        for (Boolean bool : this.horizontal) {
            sb.append(VERTICAL_LINE);
            sb.append(toStringEachHorLine(bool));
        }
        sb.append(VERTICAL_LINE + NEW_LINE);
        return sb.toString();
    }

}
