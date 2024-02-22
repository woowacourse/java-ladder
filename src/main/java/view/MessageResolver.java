package view;

import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Point;

public class MessageResolver {

    public static final int MAX_NAME_LENGTH = 5;

    public String resolveMembers(Members members) {
        String result = "";
        for (String name : members.getNames()) {
            result += String.format("%" + MAX_NAME_LENGTH + "s ", name);
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
        String result = " ".repeat(MAX_NAME_LENGTH - 1);
        for (Point point : line.getPoints()) {
            result += "|";
            result += resolvePoint(point);
        }
        result += "|";
        return result;
    }

    private String resolvePoint(Point point) {
        return point.getDisplayCharacter().repeat(MAX_NAME_LENGTH);
    }
}
