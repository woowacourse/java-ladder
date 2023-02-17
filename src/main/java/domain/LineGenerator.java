package domain;

import java.security.SecureRandom;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LineGenerator {
    private final SecureRandom secureRandom = new SecureRandom();

    public Line generate(final int personCount) {
        Deque<Link> line = new LinkedList<>();
        line.add(Link.from(secureRandom.nextBoolean()));
        for (int index = 1; index < personCount; index++) {
            addValidateLink(line);
        }
        return new Line(List.copyOf(line));
    }

    private void addValidateLink(final Deque<Link> line) {
        if (line.getLast() == Link.LINKED) {
            line.add(Link.UNLINKED);
            return;
        }
        line.add(Link.from(secureRandom.nextBoolean()));
    }
}
