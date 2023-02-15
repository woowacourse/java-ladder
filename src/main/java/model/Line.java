package model;

import util.Generator;
import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public Generator generator = new LineGenerator();
    private List<Boolean> points = new ArrayList<>();

    public Line (int personCount) {
        for(int index=0; index<personCount; index++) {
            points.add(generator.generate());
        }
    }
}
