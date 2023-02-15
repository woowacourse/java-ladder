package ladder.model;

public class Ladder {

    public Ladder(int height) {
        validateHeight(height);
    }

    private void validateHeight(int height) {
        if (height < ConstantNumber.MIN_HEIGHT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private enum ConstantNumber {

        MIN_HEIGHT(2);

        private final int number;

        ConstantNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }


    }
}
