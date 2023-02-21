package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public Line generate(int personCount) {
        final List<Link> links = new ArrayList<>();
        Link pastLink = Link.UNLINKED;
        for (int count = 1; count < personCount; count++) {
            boolean randomPoint = SECURE_RANDOM.nextBoolean();
            links.add(generateValidatePoint(randomPoint, pastLink));
            pastLink = Link.from(randomPoint);
        }
        return new Line(links);
    }

    private Link generateValidatePoint(final boolean isLink, final Link pastLink) {
        if (pastLink == Link.LINKED) {
            return Link.UNLINKED;
        }
        return Link.from(isLink);
    }
}
