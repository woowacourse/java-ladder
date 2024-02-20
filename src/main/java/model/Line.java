package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Boolean> paths;

    public Line(int personCount) {
        validatePersonCount(personCount);
        paths = generatePaths(personCount - 1);
    }

    // TODO : 끝내주는 이름 생각하기
    private List<Boolean> generatePaths(int pathsSize) {
        int index = 0;
        Random random = new Random();
        List<Boolean> paths = new ArrayList<>();
        IntStream.range(0, pathsSize).forEach((i) -> paths.add(false));

        while (index < pathsSize) {
            if (random.nextBoolean()) {
                paths.set(index, true);
                index += 2;
                continue;
            }
            index++;
        }
        return paths;
    }

    private void validatePersonCount(int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("참여할 사람은 최소 2명이어야 합니다.");
        }
    }

    public int getSize() {
        return paths.size();
    }

    public boolean get(int index) {
        return paths.get(index);
    }
}
