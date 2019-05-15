package ladder;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        checkZero(countOfPerson);

    }

    private void checkZero(int countOfPerson) {
        if (countOfPerson <= 0){
            throw new IllegalArgumentException();
        }
    }

    private boolean getNextStep(boolean before) {
        return before ? false : new Random().nextBoolean();
    }
}