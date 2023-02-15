package domain;

public class Ladder {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;

    public Ladder(final int height) {
        validateLadderHeight(height);
    }

    public Ladder(){

    }

    private static void validateLadderHeight(final int height) {
//        validateMinHeight(height);
//        validateMaxHeight(height);
        if(height < 2 || height > 10){
            throw new IllegalArgumentException("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }

    private static void validateMaxHeight(final int height) {
        if (MAX_HEIGHT < height) {
            throw new IllegalArgumentException("사다리 높이는 10 이하여야 합니다.");
        }
    }

    private static void validateMinHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.");
        }
    }

    public void build(final int height){
        validateLadderHeight(height);
    }

    public int getLineHeight(){
        return 5;
    }
}
