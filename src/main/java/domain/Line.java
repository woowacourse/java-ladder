package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points){
        this.points = points;
    }

    public static Line create(final int personCount, final PointGenerator pointGenerator) {
        List<Boolean> points = new ArrayList<>();
        while(points.size()!=personCount - 1){
            final boolean point = pointGenerator.generate();
            if(points.size()==0) {
                points.add(point);
                continue;
            }
            if(!point){
                points.add(point);
                continue;
            }
            if(!points.get(points.size()-1)){
                points.add(point);
            }
        }
        return new Line(points);
    }


    public List<Boolean> getPoints() {
        return points;
    }

}
