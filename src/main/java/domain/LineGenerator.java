package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final SecureRandom secureRandom = new SecureRandom();

    public Line generate(final int personCount) {
        final List<Link> line = new ArrayList<>();
        Link previousLink = Link.UNLINKED;
        for (int i = 0; i < personCount; i++) {
            addValidatedLink(line, previousLink);
            previousLink = line.get(i);
        }
        return new Line(line);
    }

    private void addValidatedLink(final List<Link> line, final Link previousLink) {
        if (previousLink.isLink()) {
            line.add(Link.UNLINKED);
            return;
        }
        line.add(Link.from(secureRandom.nextBoolean()));
    }
}
