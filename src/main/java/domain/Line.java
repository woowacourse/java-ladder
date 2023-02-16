package domain;

import java.util.ArrayList;
import java.util.List;
import utils.FootholdGenerator;

public class Line {

    private final List<Boolean> footholds;

    public Line(final int numberOfPlayer, final FootholdGenerator footholdGenerator) {
        footholds = makePoint(numberOfPlayer, footholdGenerator);
    }

    private List<Boolean> makePoint(final int numberOfPlayer, final FootholdGenerator footholdGenerator) {
        List<Boolean> points = new ArrayList<>();
        int numberOfPoint = numberOfPlayer - 1;

        points.add(footholdGenerator.generate());
        for (int i = 1; i < numberOfPoint; i++) {
            boolean random = footholdGenerator.generate();
            if (points.get(i - 1) == true && random == true) {
                points.add(false);
                continue;
            }
            points.add(random);
        }

        return points;
    }

    public List<Boolean> getFootholds() {
        return footholds;
    }
}
