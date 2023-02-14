package utils;

import java.util.ArrayList;
import java.util.List;

import domain.Line;

public class LineGenerator {

    public static Line generate(Line previousLine) {
        List<Boolean> pL = previousLine.getLine();
        List<Boolean> ret = new ArrayList<>();
        for (boolean b : pL) {
            if (b) {
                ret.add(false);
            }
        }
        return new Line(ret);
    }
}
