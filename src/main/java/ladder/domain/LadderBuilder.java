package ladder.domain;

public class LadderBuilder {
    private static final int RANDOM_NUMBER_RANGE = 10;

    private Ladder ladder;

    public LadderBuilder(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder build() {
        int height = ladder.getHeight();
        int numberOfPeople = ladder.getNumberOfPeople();

        for (int row = 0; row < height; row++) {
            roundLine(numberOfPeople, row);
        }

        return ladder;
    }

    private void roundLine(int numberOfPeople, int row) {
        for (int column = 0; column < numberOfPeople; column++) {
            isAvailableToConnect(row, column);
        }
    }

    private void isAvailableToConnect(int row, int column) {
        if (ladder.isAvailableToConnect(row, column)) {
            ladder.connect(row, column, makeRandomNumber());
        }
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
    }
}
