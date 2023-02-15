package model;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator{

    private Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }

}
