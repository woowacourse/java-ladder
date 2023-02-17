package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final SecureRandom secureRandom = new SecureRandom();
    private List<Link> line;

    public List<Link> generate(int personCount) {
        personCount--;
        line = new ArrayList<>();
        Link pastLink = Link.UNLINKED;
        while (personCount-- > 0) {
            boolean randomPoint = secureRandom.nextBoolean();
            addValidatePoint(randomPoint, pastLink);
            pastLink = Link.from(randomPoint);
        }
        return line;
    }

    private void addValidatePoint(final Boolean isLink, final Link pastLink) {
        if (pastLink == Link.LINKED) {
            line.add(Link.UNLINKED);
            return;
        }
        line.add(Link.from(isLink));
    }
}
