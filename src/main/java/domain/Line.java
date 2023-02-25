package domain;

import java.util.List;

import static exception.ErrorMessage.NON_VALID_LINE_EXCEPTION;

public class Line {

    private final List<Link> links;

    Line(final List<Link> links) {
        validateLinks(links);
        this.links = links;
    }

    public static Line of(final int personCount, final BooleanGenerator booleanGenerator) {
        LinksGenerator linksGenerator = new LinksGenerator(booleanGenerator);

        List<Link> links = linksGenerator.generate(personCount);
        validateLinks(links);
        return new Line(links);
    }

    public List<Link> getLine() {
        return List.copyOf(links);
    }

    private static void validateLinks(final List<Link> line) {
        Link leftLink = Link.UNLINKED;
        for (final Link rightLink : line) {
            leftLink = compareLeftLinkAndRightLink(leftLink, rightLink);
        }
    }

    private static Link compareLeftLinkAndRightLink(final Link leftLink, final Link rightLink) {
        if (rightLink.isLink() && leftLink.isLink()) {
            throw new IllegalArgumentException(NON_VALID_LINE_EXCEPTION.getMessage());
        }
        return rightLink;
    }
}
