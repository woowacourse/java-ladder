package laddergame.util;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Point;
import laddergame.domain.Tag;

import java.util.List;
import java.util.Map;

public class LadderGameViewMaker {

    public static String makeTagsView(List<String> names) {
        StringBuilder namesView = new StringBuilder();

        for (String name : names) {
            namesView.append(makeNameView(name));
        }
        return namesView.toString();
    }

    public static String makeLadderView(Ladder ladder) {
        StringBuilder ladderView = new StringBuilder();

        for (Line line : ladder.getLines()) {
            ladderView.append(makeLineView(line));
        }
        return ladderView.toString();
    }

    public static String makeGameResult(Map<Tag, Tag> allPrizes) {
        StringBuilder result = new StringBuilder();

        for (Tag member : allPrizes.keySet()) {
            result.append(member.getName())
                    .append(" : ")
                    .append(allPrizes.get(member).getName())
                    .append('\n');
        }
        return result.toString();
    }

    private static StringBuilder makeNameView(String name) {
        StringBuilder nameView = new StringBuilder(makeTagBlank());
        int nameStart = Math.round(Tag.TAG_LENGTH_BOUND / 2) - (name.length() / 2);
        int nameEnd = nameStart + name.length();

        nameView.replace(nameStart, nameEnd, name);
        return nameView;
    }

    private static StringBuilder makeLineView(Line line) {
        StringBuilder lineView = new StringBuilder(makeLadderBlank());

        for (Point point : line.getPoints()) {
            lineView.append('|')
                    .append(makePointView(point));
        }
        lineView.append('\n');
        return lineView;
    }

    private static String makePointView(Point point) {
        return point.equals(Point.RIGHT) ? makeConnectPoint() : makeBlankPoint();
    }

    private static String makeTagBlank() {
        return makeLadderView(Tag.TAG_LENGTH_BOUND + 2, ' ');
    }

    private static String makeLadderBlank() {
        return makeLadderView(Tag.TAG_LENGTH_BOUND / 2, ' ');
    }

    private static String makeConnectPoint() {
        return makeLadderView(Tag.TAG_LENGTH_BOUND + 1, '-');
    }

    private static String makeBlankPoint() {
        return makeLadderView(Tag.TAG_LENGTH_BOUND + 1, ' ');
    }

    private static String makeLadderView(int size, char delimiter) {
        StringBuilder connectPoint = new StringBuilder();

        for (int i = 0; i < size; i++) {
            connectPoint.append(delimiter);
        }
        return connectPoint.toString();
    }

}
