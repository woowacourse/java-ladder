package laddergame.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.stream.Collectors.toList;

public class TestLinkGenerator implements LinkGenerator {

    private final Queue<Link> links;

    public TestLinkGenerator(final List<Boolean> testBooleans) {
        final List<Link> testLinks = testBooleans.stream().map(element -> Link.from(element))
                .collect(toList());
        this.links = new LinkedList<>(testLinks);
    }

    @Override
    public Link pick() {
        return links.remove();
    }
}
