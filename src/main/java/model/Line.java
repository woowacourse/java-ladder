package model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Boolean> points;

    public Line(int personCount) {
        // TODO 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가 (???)
        validatePersonCount(personCount);
        // TODO: 우리 코드의 의미를 이해 가능??
        points = new ArrayList<>(personCount - 1);
        for (int i= 0; i < personCount - 1; i++) {
            points.add(true);
        }
    }

    private void validatePersonCount(int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("참여할 사람은 최소 2명이어야 합니다.");
        }
    }

    public int getSize() {
        return points.size();
    }
}
