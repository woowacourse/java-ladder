package domain;

public class Ladder {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;

    public Ladder(){

    }

    private static void validateLadderHeight(final int height) {
        if(height < MIN_HEIGHT || height > MAX_HEIGHT){
            throw new IllegalArgumentException("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }

    public void build(final int height){
        validateLadderHeight(height);
    }

    public int getLineHeight(){
        return 5;
    }
}
