package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Link> links;

    public Line(final List<Link> links) {
        validateLine(links);
        this.links = links;
    }

    public List<Link> getLinks() {
        return new ArrayList<>(links);
    }

    private void validateLine(final List<Link> line) {
        Link state = Link.UNLINKED;
        for (final Link link : line) {
            state = comparePastPointAndPresentPoint(state, link);
        }
    }

    private Link comparePastPointAndPresentPoint(Link pastLink, final Link link) {
        if (link.isLink() && pastLink.isLink()) {
            throw new IllegalArgumentException();
        }
        pastLink = link;
        return pastLink;
    }
}
