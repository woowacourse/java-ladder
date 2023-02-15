package utils;

import java.util.Random;

// TODO: 클래스명 변경
public class RandomNumberMaker implements NumberMaker {


    private final Random random;

    public RandomNumberMaker() {
        this.random = new Random();
    }

    @Override
    public boolean generateNumber(int bound) {
        return random.nextInt(bound) == 1;
    }
}
