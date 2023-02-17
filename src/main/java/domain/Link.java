package domain;

public enum Link {
    LINKED(true),
    UNLINKED(false);

    private final boolean link;

    Link(final boolean link) {
        this.link = link;
    }

    public static Link from(boolean link) {
        if (link) {
            return LINKED;
        }
        return UNLINKED;
    }

    public boolean isLink() {
        return link;
    }
}
