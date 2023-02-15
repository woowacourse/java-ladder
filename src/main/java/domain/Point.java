package domain;

public enum Point {
    LINKED_POINT(true),
    EMPTY_POINT(false);

    private final boolean link;

    Point(final boolean link) {
        this.link = link;
    }

    public boolean isLink() {
        return link;
    }
}
