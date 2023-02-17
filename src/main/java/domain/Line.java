package domain;

import java.util.List;

public class Line {
    private final List<Link> links;

    public Line(final List<Link> links) {
        this.links = links;
    }

    public List<Link> getLinks() {
        return List.copyOf(links);
    }
}
