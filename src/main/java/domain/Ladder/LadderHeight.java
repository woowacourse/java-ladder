package domain.Ladder;

public class LadderHeight {
    private static final String HEIGHT_ERROR_MSG = "사다리의 높이는 1 이상이어야 합니다.";
    
    private final int height;
    
    private LadderHeight( final int number ) {
        this.height = number;
    }
    
    public static LadderHeight from( final int height ) {
        validateHeight(height);
        return new LadderHeight(height);
    }
    
    private static void validateHeight( final int height ) {
        if ( height < 1 ) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MSG);
        }
    }
    
    public int getHeight() {
        return this.height;
    }
}
