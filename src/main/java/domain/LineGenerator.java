package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LineGenerator {

    private final BooleanGenerator booleanGenerator;

    public LineGenerator(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Line generate(final int personCount) {
        final Deque<Link> links = new LinkedList<>();
        if (personCount != 1) {
            links.add(Link.from(booleanGenerator.generate()));
        }
        for (int index = 1; index < personCount - 1; index++) {
            addValidateLink(links);
        }
        return new Line(List.copyOf(links));
    }

    private void addValidateLink(final Deque<Link> line) {
        if (line.getLast() == Link.LINKED) {
            line.add(Link.UNLINKED);
            return;
        }
        line.add(Link.from(booleanGenerator.generate()));
    }
}
