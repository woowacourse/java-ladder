package ladderGame.model.input;

public class RowInput {
    private int row;

    public RowInput(String input) throws IllegalArgumentException {
        int row = Integer.parseInt(input);
        if (row <= 0) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해야 합니다.");
        }
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }
}
