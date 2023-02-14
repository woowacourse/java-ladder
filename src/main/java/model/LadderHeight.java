package model;

public class LadderHeight {

    private static final int MINIMUM_LADDER_HEIGHT = 1;
    private final int height;

    public LadderHeight(int height){
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if(height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }
}
