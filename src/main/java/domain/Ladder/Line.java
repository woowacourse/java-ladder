package domain.Ladder;

import domain.util.PointGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    
    private final List<Point> points;
    
    private Line( List<Point> points ) {
        this.points = points;
    }
    
    public static Line create( LadderWidth ladderWidth, PointGenerator pointGenerator ) {
        List<Point> line = new ArrayList<>();
        while ( ladderWidth.getWidth() > line.size() ) {
            Point point = pointGenerator.generate();
            line.add(point);
            addAbsenceIfPresenceIsAdded(line, point, ladderWidth.getWidth());
        }
        return new Line(line);
    }
    
    private static void addAbsenceIfPresenceIsAdded( List<Point> line, Point point, int ladderWidth ) {
        if ( line.size() == ladderWidth ) return;
        if ( point.isPresent() ) {
            line.add(Point.ABSENCE);
        }
    }
    
    public List<Integer> getPresentIndexes() {
        ArrayList<Integer> indexes = new ArrayList<>();
        for ( int i = 0; i < this.points.size(); i++ ) {
            this.addIndexIfPresent(indexes, i);
        }
        return indexes;
    }
    
    private void addIndexIfPresent( ArrayList<Integer> indexes, int i ) {
        if ( this.points.get(i).isPresent() ) {
            indexes.add(i);
        }
    }
    
    
    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
    }
}
