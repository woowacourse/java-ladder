package util;

import domain.ladder.attirbute.Direction;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {
    private final Random random = new Random();
    @Override
    public Direction generate(){
        boolean flag = random.nextBoolean();
        if(flag){
            return Direction.DOWN;
        }
        return Direction.RIGHT;
    }
}
