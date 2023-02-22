package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Line {

    private static final int MIN_LINK_COUNT = 1;
    private static final int FIRST_INDEX_OF_LINK = 0;
    private static final int LINK_COUNT = 1;

    private final List<Link> line;

    private Line(final int playerCount, final PickStrategy pickStrategy) {
        int linkCount = playerCount - 1;
        validateLinkCount(linkCount);
        this.line = createFloor(linkCount, pickStrategy);
    }

    public static Line from(final int playerCount) {
        return new Line(playerCount, new LinkPicker());
    }

    public static Line of(final int playerCount, final PickStrategy pickStrategy) {
        return new Line(playerCount, pickStrategy);
    }

    public List<Link> getLine() {
        return new ArrayList<>(line);
    }

    private List<Link> createFloor(final int linkCount, final PickStrategy pickStrategy) {
        List<Link> line = new ArrayList<>();
        for (int i = 0; i < linkCount; i++) {
            line.add(checkLink(line, i, pickStrategy.pick()));
        }
        if (isAllFalse(linkCount, line)) {
            return createFloor(linkCount, pickStrategy);
        }
        return line;
    }

    private static boolean isAllFalse(final int linkCount, final List<Link> line) {
        return new HashSet<>(line).size() == LINK_COUNT && linkCount > MIN_LINK_COUNT;
    }

    private Link checkLink(final List<Link> line, final int index, final boolean pick) {

        if (index == FIRST_INDEX_OF_LINK) {
            return Link.from(pick);
        }

        if (isOverlap(line, pick)) {
            return Link.DISCONNECTION;
        }

        return Link.from(pick);
    }

    private static boolean isOverlap(final List<Link> line, final boolean pick) {
        int lastIndex = line.size() - 1;
        return line.get(lastIndex).isLink() && pick;
    }

    private void validateLinkCount(final int linkCount) {
        if (linkCount < MIN_LINK_COUNT) {
            throw new IllegalStateException(String.format("Floor의 길이는 %d보다 작을 수 없습니다.", MIN_LINK_COUNT));
        }
    }
}
