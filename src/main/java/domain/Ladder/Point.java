package domain.Ladder;

public enum Point {
    
    PRESENCE(true),
    ABSENCE(false);
    
    private final boolean presence;
    
    Point( boolean presence ) {
        this.presence = presence;
    }
    
    public static Point from( boolean present ) {
        if ( present ) {
            return Point.PRESENCE;
        }
        return Point.ABSENCE;
    }
    
    public boolean isPresent() {
        return this.presence;
    }
    
}
