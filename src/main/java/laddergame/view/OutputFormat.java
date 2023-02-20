package laddergame.view;

import laddergame.domain.Link;

public enum OutputFormat {
    BLANK(" "),
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-");

    private final String ladderElement;

    OutputFormat(final String ladderElement) {
        this.ladderElement = ladderElement;
    }

    public static String convertFormat(final Link link) {
        if (link.isLink()) {
            return HORIZONTAL_LINE.ladderElement;
        }
        return BLANK.ladderElement;
    }

    public String getLadderElement() {
        return ladderElement;
    }
}
