package util;

import domain.Line;

import java.util.Iterator;

public class LineString {

    private LineString() {}

    public static String from(Line line) {
        Iterator<Connection> iterator = line.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().getBridge());
        }
        return stringBuilder.toString();
    }
}
