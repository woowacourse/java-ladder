package util;

import domain.Line;

import java.util.Iterator;

public class LineString {

    private LineString() {}

    public static String from(Line line) {
        Iterator<Boolean> iterator = line.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(layer(iterator.next()));
        }
        return stringBuilder.toString();
    }

    private static String layer(boolean input) {
        if (input) {
            return "-----|";
        }
        return "     |";
    }
}
