package domain;

public enum Point {
    LINKED_POINT(true),
    EMPTY_POINT(false);

    private final boolean link;

    Point(final boolean link) {
        this.link = link;
    }

    public static Point from(boolean link) {
        if (link) {
            return LINKED_POINT;
        }
        return EMPTY_POINT;
    }

    public boolean isLink() {
        return link;
    }
}
