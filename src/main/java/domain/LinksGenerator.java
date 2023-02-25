package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

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
        IntStream.range(1, personCount - 1)
                .forEach(it -> addValidateLink(links));

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
