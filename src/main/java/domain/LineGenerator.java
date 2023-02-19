package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LineGenerator {
    private final LinkGenerator linkGenerator;

    public LineGenerator(final LinkGenerator linkGenerator) {
        this.linkGenerator = linkGenerator;
    }

    public Line generate(final int personCount) {
        final Deque<Link> line = new LinkedList<>();
        if (personCount != 1) {
            line.add(linkGenerator.generate());
        }
        for (int index = 1; index < personCount - 1; index++) {
            addValidatedLink(line);
        }
        return new Line(List.copyOf(line));
    }

    private void addValidatedLink(final Deque<Link> line) {
        if (line.getLast() == Link.LINKED) {
            line.add(Link.UNLINKED);
            return;
        }
        line.add(linkGenerator.generate());
    }
}
