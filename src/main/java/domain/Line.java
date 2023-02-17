package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.generator.FootholdGenerator;

public class Line {

    private final List<Boolean> footholds;

    public Line(final int numberOfPlayer, final FootholdGenerator footholdGenerator) {
        footholds = makeFootholds(numberOfPlayer, footholdGenerator);
    }

    private List<Boolean> makeFootholds(final int numberOfPlayer, final FootholdGenerator footholdGenerator) {
        List<Boolean> footholds = new ArrayList<>();
        int numberOfFoothold = numberOfPlayer - 1;

        footholds.add(footholdGenerator.generate());
        makeOtherFootholds(footholdGenerator, footholds, numberOfFoothold);

        return footholds;
    }

    private void makeOtherFootholds(final FootholdGenerator footholdGenerator, final List<Boolean> footholds,
                                    final int numberOfPoint) {
        for (int i = 1; i < numberOfPoint; i++) {
            boolean random = footholdGenerator.generate();
            makeFootholdWithoutFirst(footholds, i, random);
        }
    }

    private void makeFootholdWithoutFirst(final List<Boolean> footholds, final int index, final boolean isExisting) {
        if (isContinuousFoothold(footholds, index, isExisting)) {
            footholds.add(false);
            return;
        }
        footholds.add(isExisting);
    }

    private boolean isContinuousFoothold(final List<Boolean> footholds, final int index, final boolean random) {
        return footholds.get(index-1) && random;
    }

    public List<Boolean> getFootholds() {
        return Collections.unmodifiableList(this.footholds);
    }
}
