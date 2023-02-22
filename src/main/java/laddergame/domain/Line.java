package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Line {

    private static final int MIN_LINK_COUNT = 1;
    private static final int FIRST_INDEX_OF_LINK = 0;
    private static final int LINK_COUNT = 1;

    private final List<Link> line;

    private Line(final int playerCount, final LinkGenerator linkGenerator) {
        int linkCount = playerCount - 1;
        validateLinkCount(linkCount);
        this.line = createFloor(linkCount, linkGenerator);
    }

    public static Line from(final int playerCount) {
        return new Line(playerCount, new RandomLinkGenerator());
    }

    public static Line of(final int playerCount, final LinkGenerator linkGenerator) {
        return new Line(playerCount, linkGenerator);
    }

    public List<Link> getLine() {
        return new ArrayList<>(line);
    }

    private List<Link> createFloor(final int linkCount, final LinkGenerator linkGenerator) {
        List<Link> line = new ArrayList<>();
        for (int i = 0; i < linkCount; i++) {
            line.add(checkLink(line, i, linkGenerator.pick()));
        }
        if (isAllFalse(linkCount, line)) {
            return createFloor(linkCount, linkGenerator);
        }
        return line;
    }

    private static boolean isAllFalse(final int linkCount, final List<Link> line) {
        return new HashSet<>(line).size() == LINK_COUNT && linkCount > MIN_LINK_COUNT;
    }

    private Link checkLink(final List<Link> line, final int index, final Link link) {

        if (index == FIRST_INDEX_OF_LINK) {
            return link;
        }

        if (isOverlap(line, link)) {
            return Link.DISCONNECTION;
        }

        return link;
    }

    private static boolean isOverlap(final List<Link> line, final Link link) {
        int lastIndex = line.size() - 1;
        return line.get(lastIndex).isLink() && link.isLink();
    }

    private void validateLinkCount(final int linkCount) {
        if (linkCount < MIN_LINK_COUNT) {
            throw new IllegalStateException(String.format("Floor의 길이는 %d보다 작을 수 없습니다.", MIN_LINK_COUNT));
        }
    }
}
