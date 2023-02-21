package ladder.domain;

import java.util.Objects;

public class Direction {
    private final Bar leftBar;
    private final Bar rightBar;
    
    private Direction(Bar leftBar, Bar rightBar) {
        this.leftBar = leftBar;
        this.rightBar = rightBar;
    }
    
    public static Direction createFirst(BarGenerator barGenerator) {
        return new Direction(Bar.FALSE, barGenerator.createBar());
    }
    
    public Direction createNext(BarGenerator barGenerator) {
        if (rightBar.isExistBar()) {
            return new Direction(rightBar, Bar.FALSE);
        }
        
        return new Direction(rightBar, barGenerator.createBar());
    }
    
    public Direction createLast() {
        return new Direction(rightBar, Bar.FALSE);
    }
    
    public int getMovedPosition(int beforePosition) {
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
    
    public Bar getLeftBar() {
        return leftBar;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return leftBar == direction.leftBar && rightBar == direction.rightBar;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(leftBar, rightBar);
    }
}
