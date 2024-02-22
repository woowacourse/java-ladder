package view;

import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Point;

public class MessageResolver {

    public String resolveMembers(Members members) {
        String result = "";
        for (String name : members.getNames()) {
            result += String.format("%5s ", name);
        }
        return result;
    }

    public String resolveLines(Lines lines) {
        String result = "";

        for (int i = 0; i < lines.getLines().size(); i++) {
            result += resolveLine(lines.getLines().get(i));
            result += "\n";
        }

        return result;
    }

    private String resolveLine(Line line) {
        String result = " ".repeat(4);
        for (Point point : line.getPoints()) {
            result += "|";
            result += resolvePoint(point);
        }
        result += "|";
        return result;
    }

    private String resolvePoint(Point point) {
        return point.getDisplayCharacter().repeat(5);
    }
}
