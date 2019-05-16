/*
 * @(#)Line.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */
package ladder.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class Line {
    /*사다리게임의 각 층(라인)에 대한 클래스*/
    private static final String HEADER_HORIZON_LINE = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String NEW_LINE = "\n";
    private static final String NO_HORIZON_LINE = "     ";
    private static final String HORIZON_LINE = "-----";
    private static final String HORIZON_LINE_DUPLICATION_ERROR = "가로선 중복 오류";

    private List<Boolean> horizons;

    public Line(int tagsNumber) {
        horizons = new ArrayList<>();
        makeRandomHorizons(tagsNumber);
    }

    public Line(List<Boolean> horizon) {
        checkDuplicateHorizon(horizon);
        this.horizons = horizon;
    }

    private void makeRandomHorizons(int tagsNumber) {
        Random random = new Random();
        horizons.add(random.nextBoolean());
        for (int index = 1; index < tagsNumber - 1; index++) {
            makeProperHorizon(index, random.nextBoolean());
        }
    }

    private void makeProperHorizon(int currentIndex, Boolean randomBoolean) {
        if (!horizons.get(currentIndex - 1)) {
            horizons.add(randomBoolean);
            return;
        }
        horizons.add(false);
    }

    private void checkDuplicateHorizon(List<Boolean> horizon) {
        for (int index = 0; index < horizon.size() - 1; index++) {
            checkOneDuplicationHorizon(horizon, index);
        }
    }

    private void checkOneDuplicationHorizon(List<Boolean> horizon, int index) {
        if (horizon.get(index) && horizon.get(index + 1)) {
            throw new IllegalArgumentException(HORIZON_LINE_DUPLICATION_ERROR);
        }
    }

    public List<Boolean> getHorizon() {
        return horizons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER_HORIZON_LINE);
        for (Boolean horizon : horizons) {
            sb.append(VERTICAL_LINE)
                    .append(toStringEachHorLine(horizon));
        }
        sb.append(VERTICAL_LINE)
                .append(NEW_LINE);
        return sb.toString();
    }

    private String toStringEachHorLine(Boolean horizon) {
        if (horizon) {
            return HORIZON_LINE;
        }
        return NO_HORIZON_LINE;
    }

    public int getIndexAfterMovingHorizon(int index) {
        if (index > 0 && horizons.get(index - 1)) {
            return --index;
        }
        if (index < horizons.size() && horizons.get(index)) {
            return ++index;
        }
        return index;
    }
}
