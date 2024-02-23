package model;

public class Height {
    private final int height;

    public Height(final String heightText) {
        validateNaturalNumber(heightText);
        this.height = Integer.parseInt(heightText);
    }

    public int getHeight() {
        return height;
    }

    private void validateNaturalNumber(String inputData) {
        if (Integer.parseInt(inputData) <= 0) {
            throw new IllegalArgumentException("자연수만 입력해주세요.");
        }
    }
}
