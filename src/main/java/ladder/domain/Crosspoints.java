package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crosspoints {
    private List<Crosspoint> crosspoints;

    public Crosspoints(Crossbar crossbar) {
        crosspoints = crossbar.getCrosspoints();
    }

    public int answerResultIndexOf(int positionOfPlayer) {
        return crosspoints.get(positionOfPlayer)
                .answerResultPositionOf(positionOfPlayer);
    }

    public List<Boolean> getRightSideCrossbars() {
        List<Boolean> rightCrossbars = new ArrayList<>();

        for (Crosspoint crosspoint : crosspoints) {
            rightCrossbars.add(crosspoint.hasRightSideCrossbar());
        }
        return rightCrossbars;
    }

    public int width() {
        return crosspoints.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crosspoints that = (Crosspoints) o;
        return Objects.equals(crosspoints, that.crosspoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crosspoints);
    }
}
