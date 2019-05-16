package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    RandomGenerator randomGenerator;
    private List<Integer> row;
    private int width;

    public LadderRow() {
        this(0);
    }

    public LadderRow(int width) {
        row = new ArrayList<>();
        this.width = width;
    }

    public LadderRow(List<Integer> numbers) {
        this.row = numbers;
    }

    public LadderRow(int width, RandomGenerator randomGenerator) {
        row = new ArrayList<>();
        this.width = width;
        this.randomGenerator = randomGenerator;
    }


    public int draw(boolean isDraw) {
        if (isDraw) {
            row.add(1);
            row.add(-1);
            return 2;
        }
        row.add(0);
        return 1;
    }


    public List<Integer> status() {
        return row;
    }

    public void makeRow() {
        while (this.width > 0) {
            makeLine();
        }
    }

    public LadderRow getRow() {
        makeRow();
        return this;
    }

    private void makeLine() {
        if (this.width == 1) {
            this.width -= draw(false);
            return;
        }
        this.width -= draw(getRandomFlag());
    }

    public void setRandomGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    private boolean getRandomFlag() {
//        Random random = new Random();
//        String a = randomGenerator.getElement();
//        return a.equals("1");
//        return random.nextInt(2) == 1;
        return randomGenerator.getElement() == 1;
    }
}
