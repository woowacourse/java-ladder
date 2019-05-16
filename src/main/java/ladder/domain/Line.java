/*
 * @(#)Line.java
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
    private static final String HEADER_HORIZON_LINE = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String NEW_LINE = "\n";
    private static final String NO_HORIZON_LINE = "     ";
    private static final String HORIZON_LINE = "-----";
    private static final String HORIZON_DUPLICATION_ERROR = "가로선 중복 오류";

    private List<Boolean> horizon;

    public Line(int playerNumber) {
        horizon = new ArrayList<>();
        makeRandomBooleans(playerNumber);
    }

    public Line(List<Boolean> horizon) {
        checkDuplicateHorizon(horizon);
        this.horizon = horizon;
    }

    public List<Boolean> getHorizon() {
        return this.horizon;
    }

    private void checkDuplicateHorizon(List<Boolean> horizon) {
        for (int i = 0; i < horizon.size(); i++) {
            checkOneDuplicationHorizon(horizon, i);
        }
    }

    private void makeRandomBooleans(int playerNumber) {
        for (int i = 0; i < playerNumber - 1; i++) {
            horizon.add(makeProperBoolean(i));
        }
    }

    private Boolean makeProperBoolean(int currentIndex) {
        Random random = new Random();
        if (currentIndex == 0) {
            return random.nextBoolean();
        }
        if (!this.horizon.get(currentIndex - 1)) {
            return random.nextBoolean();
        }
        return false;
    }

    private void checkOneDuplicationHorizon(List<Boolean> horizon, int i) {
        if (horizon.get(i) && horizon.get(i + 1)) {
            throw new IllegalArgumentException(HORIZON_DUPLICATION_ERROR);
        }
    }
    private String toStringEachHorLine(Boolean bool) {
        String result = NO_HORIZON_LINE;
        if (bool) {
            result = HORIZON_LINE;
        }
        return result;
    }

    public int moveRightOrLeft(int index) {
        if (canMoveLeft(index)) {
            return moveLeft(index);
        }
        if (canMoveRight(index)) {
            return moveRight(index);
        }
        return index;
    }
    private boolean canMoveLeft(int index) {
        return index > 0 && this.horizon.get(index - 1);
    }

    private int moveLeft(int index) {
        return index - 1;
    }

    private boolean canMoveRight(int index) {
        return index < horizon.size() && this.horizon.get(index);
    }

    private int moveRight(int index) {
        return index + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER_HORIZON_LINE);
        for (Boolean bool : this.horizon) {
            sb.append(VERTICAL_LINE);
            sb.append(toStringEachHorLine(bool));
        }
        sb.append(VERTICAL_LINE + NEW_LINE);
        return sb.toString();
    }

}
