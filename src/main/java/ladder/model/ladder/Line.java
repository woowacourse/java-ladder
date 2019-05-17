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
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class Line {
    /*사다리게임의 각 층(라인)에 대한 클래스*/
    private static final String HORIZON_LINE_DUPLICATION_ERROR = "가로선 중복 오류";

    private List<Boolean> horizons;

    public List<Boolean> getHorizons() {
        return horizons;
    }

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
