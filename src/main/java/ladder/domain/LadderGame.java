package ladder.domain;

public class LadderGame {
    private static final int RANDOM_NUMBER_RANGE = 10;

    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder build(int height, int countOfPerson) {
        for (int i = 0; i < height; i++) {
            roundLine(countOfPerson, i);
        }

        return ladder;
    }

    private void roundLine(int countOfPerson, int i) {
        for (int j = 0; j < countOfPerson; j++) {
            isAvailableToConnect(i, j);
        }
    }

    private void isAvailableToConnect(int i, int j) {
        if (ladder.isAvailableToConnect(i, j)) {
            ladder.connect(i, j, makeRandomNumber());
        }
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
    }
}
