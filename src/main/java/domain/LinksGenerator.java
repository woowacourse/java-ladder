package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LinksGenerator {

    private final BooleanGenerator booleanGenerator;

    public LinksGenerator(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public List<Link> generate(final int personCount) {
        final Deque<Link> links = new LinkedList<>();
        if (personCount != 1) {
            links.add(Link.from(booleanGenerator.generate()));
        }
        for (int index = 1; index < personCount - 1; index++) {
            addValidateLink(links);
        }
        return List.copyOf(links);
    }

    private void addValidateLink(final Deque<Link> links) {
        if (links.getLast() == Link.LINKED) {
            links.add(Link.UNLINKED);
            return;
        }
        links.add(Link.from(booleanGenerator.generate()));
    }
}
