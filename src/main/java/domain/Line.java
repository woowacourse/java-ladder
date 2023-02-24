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
        Link leftLink = Link.UNLINKED;
        for (final Link rightLink : line) {
            leftLink = compareLeftLinkAndRightLink(leftLink, rightLink);
        }
    }

    private Link compareLeftLinkAndRightLink(final Link leftLink, final Link rightLink) {
        if (rightLink.isLink() && leftLink.isLink()) {
            throw new IllegalArgumentException(NON_VALID_LINE_EXCEPTION.getMessage());
        }
        return rightLink;
    }
}
