package util;

import domain.Direction;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {

    // -1 ~ 1까지 생성하기 위해 bound를 3으로 설정
    private static final int MAXIMUM_BOUND = 3;

    private final Random random = new Random();

    @Override
    public Direction generate() {
        int number = random.nextInt(MAXIMUM_BOUND) - 1;

        return Direction.getDirectionByValue(number);
    }
}
