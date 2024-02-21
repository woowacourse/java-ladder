package domain.model;

public class Height {
    int height;

    public Height(final String height) {
        validateNaturalNumber(height);
    }

    public int getHeight() {
        return height;
    }

    private void validateNaturalNumber(String inputData) {
        this.height = Integer.parseInt(inputData);
        if (this.height <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
