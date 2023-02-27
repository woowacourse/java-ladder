package domain.Ladder;

public class LadderWidth {
    private static final String LADDER_WIDTH_NUMBER_ERROR_MSG = "너비는 1 이상이여야 합니다.";
    private final int width;
    
    private LadderWidth( final int number ) {
        this.width = number;
    }
    
    public static LadderWidth from( final int number ) {
        validateWidth(number);
        return new LadderWidth(number);
    }
    
    private static void validateWidth( final int number ) {
        if ( number <= 0 ) {
            throw new IllegalArgumentException(LADDER_WIDTH_NUMBER_ERROR_MSG);
        }
    }
    
    public int getWidth() {
        return this.width;
    }
}
