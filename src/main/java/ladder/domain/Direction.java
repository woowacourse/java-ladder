package ladder.domain;

public class Direction {
    private final Bar leftBar;
    private final Bar rightBar;
    
    private Direction(boolean isExistLeftBar, BooleanGenerator booleanGenerator) {
        this(new Bar(isExistLeftBar), new Bar(booleanGenerator));
    }
    
    private Direction(Bar leftBar, Bar rightBar) {
        this.leftBar = leftBar;
        this.rightBar = rightBar;
    }
    
    public static Direction createFirst(BooleanGenerator booleanGenerator) {
        return new Direction(false, booleanGenerator);
    }
    
    public Direction createNext(BooleanGenerator booleanGenerator) {
        if (rightBar.isExistBar()) {
            return new Direction(rightBar, new Bar(false));
        }
        
        return new Direction(rightBar, new Bar(booleanGenerator));
    }
    
    public Direction createLast() {
        return new Direction(rightBar, new Bar(false));
    }
    
    public int getAdjustedPosition(int beforePosition) {
        if (leftBar.isExistBar()) {
            return minusPosition(beforePosition);
        }
        
        if (rightBar.isExistBar()) {
            return plusPosition(beforePosition);
        }
        
        return beforePosition;
    }
    
    private int plusPosition(int beforePosition) {
        return beforePosition + 1;
    }
    
    private int minusPosition(int beforePosition) {
        return beforePosition - 1;
    }
}
