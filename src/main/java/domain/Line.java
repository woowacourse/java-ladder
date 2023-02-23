package domain;

import java.util.List;

import static exception.ErrorMessage.NON_VALID_LINE_EXCEPTION;

public class Line {

    private final List<Link> links;

    public Line(final List<Link> links) {
        validateLine(links);
        this.links = links;
    }

    public List<Link> getLinks() {
        return List.copyOf(links);
    }

    private void validateLine(final List<Link> line) {
        Link state = Link.UNLINKED;
        for (final Link link : line) {
            state = comparePastPointAndPresentPoint(state, link);
        }
    }

    private Link comparePastPointAndPresentPoint(Link pastLink, final Link link) {
        if (link.isLink() && pastLink.isLink()) {
            throw new IllegalArgumentException(NON_VALID_LINE_EXCEPTION.getMessage());
        }
        pastLink = link;
        return pastLink;
    }
}
