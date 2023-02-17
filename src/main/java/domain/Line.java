package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> links;

    public Line(final List<Link> links) {
        this.links = links;
    }

    public Line(final int personCount) {
        LineGenerator lineGenerator = new LineGenerator();
        links = lineGenerator.generate(personCount);
    }

    public List<Link> getPoints() {
        return new ArrayList<>(links);
    }
}
