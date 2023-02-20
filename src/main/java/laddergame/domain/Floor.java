package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Floor {

    private static final int MIN_LINK_COUNT = 1;
    private static final int FIRST_INDEX_OF_LINK = 0;
    private static final int LINK_COUNT = 1;

    private final List<Link> floor;
    private final PickStrategy strategy;

    private Floor(final int playerCount, final PickStrategy pickStrategy) {
        this.strategy = pickStrategy;
        int linkCount = playerCount - 1;
        validateLinkCount(linkCount);
        this.floor = createFloor(linkCount);
    }

    public static Floor from(final int playerCount) {
        return new Floor(playerCount, new LinkPicker());
    }

    public static Floor of(final int playerCount, final PickStrategy pickStrategy) {
        return new Floor(playerCount, pickStrategy);
    }

    public List<Link> getFloor() {
        return new ArrayList<>(floor);
    }

    private List<Link> createFloor(final int isExistenceCount) {
        List<Link> floor = new ArrayList<>();
        for (int i = 0; i < isExistenceCount; i++) {
            floor.add(checkLink(floor, i));
        }
        if (isAllFalse(isExistenceCount, floor)) {
            return createFloor(isExistenceCount);
        }
        return floor;
    }

    private static boolean isAllFalse(final int isExistenceCount, final List<Link> floor) {
        return new HashSet<>(floor).size() == LINK_COUNT && isExistenceCount > MIN_LINK_COUNT;
    }

    private Link checkLink(final List<Link> floor, final int index) {
        final boolean pick = strategy.pick();

        if (index == FIRST_INDEX_OF_LINK) {
            return Link.from(pick);
        }

        if (isOverlap(floor, pick)) {
            return Link.DISCONNECTION;
        }

        return Link.from(pick);
    }

    private static boolean isOverlap(final List<Link> floor, final boolean pick) {
        int lastIndex = floor.size() - 1;
        return floor.get(lastIndex).isLink() && pick;
    }

    private void validateLinkCount(final int numberOfExistences) {
        if (numberOfExistences < MIN_LINK_COUNT) {
            throw new IllegalStateException(String.format("Floor의 길이는 %d보다 작을 수 없습니다.", MIN_LINK_COUNT));
        }
    }
}
