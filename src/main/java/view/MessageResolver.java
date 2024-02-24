package view;

import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Point;
import java.util.List;

public class MessageResolver {

    public static final int MAX_NAME_LENGTH = 5;

    public String resolveMembers(Members members) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : members.getNames()) {
            stringBuilder.append(String.format("%" + MAX_NAME_LENGTH + "s ", name));
        }
        return stringBuilder.toString();
    }

    public String resolveLines(Lines ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            stringBuilder.append(resolveLine(line));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String resolveLine(Line line) {
        List<Point> points = line.getPoints();
        StringBuilder stringBuilder = new StringBuilder(" ".repeat(MAX_NAME_LENGTH - 1));
        for (Point point : points) {
            stringBuilder.append("|");
            stringBuilder.append(resolvePoint(point));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private String resolvePoint(Point point) {
        return point.getDisplayCharacter().repeat(MAX_NAME_LENGTH);
    }
}
