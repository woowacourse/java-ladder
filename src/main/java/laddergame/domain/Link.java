package laddergame.domain;

public enum Link {
    CONNECTION(true),
    DISCONNECTION(false),
    ;

    private final boolean isLink;

    Link(final boolean isLink) {
        this.isLink = isLink;
    }

    public boolean isLink() {
        return isLink;
    }

    public static Link from(boolean isLink) {
        if (isLink) {
            return CONNECTION;
        }
        return DISCONNECTION;
    }
}
