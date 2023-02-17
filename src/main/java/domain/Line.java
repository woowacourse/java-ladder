package domain;

import java.util.ArrayList;
import java.util.List;
import utils.FootholdGenerator;

public class Line {

    private final List<Boolean> footholds;

    public Line(final int numberOfPlayer, final FootholdGenerator footholdGenerator) {
        footholds = makeFootholds(numberOfPlayer, footholdGenerator);
    }

    private List<Boolean> makeFootholds(final int numberOfPlayer, final FootholdGenerator footholdGenerator) {
        List<Boolean> footholds = new ArrayList<>();

        generateFootholds(footholdGenerator, footholds, numberOfPlayer);

        return footholds;
    }

    private void generateFootholds(final FootholdGenerator footholdGenerator, final List<Boolean> footholds,
                                   final int numberOfPlayer) {
        int numberOfPoint = numberOfPlayer - 1;

        createFirstFoothold(footholds, footholdGenerator);
        createOtherFootholds(footholdGenerator, footholds, numberOfPoint);
    }

    private void createFirstFoothold(final List<Boolean> points, final FootholdGenerator footholdGenerator) {
        points.add(footholdGenerator.generate());
    }

    private void createOtherFootholds(final FootholdGenerator footholdGenerator, final List<Boolean> footholds,
                                      final int numberOfPoint) {
        for (int i = 1; i < numberOfPoint; i++) {
            boolean isExistFoothold = footholdGenerator.generate();
            createFootholdWithoutFirst(footholds, i, isExistFoothold);
        }
    }

    private void createFootholdWithoutFirst(final List<Boolean> points, final int index, final boolean isExistFoothold) {
        if (isConsecutiveExistingFoothold(points, index, isExistFoothold)) {
            points.add(false);
            return;
        }
        points.add(isExistFoothold);
    }

    private boolean isConsecutiveExistingFoothold(final List<Boolean> points, final int index, final boolean random) {
        return points.get(index - 1) && random;
    }

    public List<Boolean> getFootholds() {
        return footholds;
    }
}
