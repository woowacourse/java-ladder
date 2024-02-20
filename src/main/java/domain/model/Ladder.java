package domain.model;

public class Ladder {
    int height;

    public Ladder(final String height) {
        validateNaturalNumber(height);
    }

    public int getHeight() {
        return height;
    }

    private void validateNaturalNumber(String inputData){
        this.height = Integer.parseInt(inputData);
        if (this.height <= 0){
            throw new IllegalArgumentException();
        }
    }
}
