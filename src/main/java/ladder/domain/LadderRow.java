package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LadderRow {
    private static final int MIN_LENTH = 2;
    private static final int NEXT_NEIGHBOR = 1;
    private static final int FIRST_POINT_INDEX = 0;
    private static final double RATE_OF_EMPTY_CROSSBARS = 0.5;
    private static final int NUM_OF_OUTER_CROSSPOINT = 2;

    private List<Crosspoint> crosspoints;

    LadderRow(List<Crosspoint> crosspoints) {
        validateOutsideCrossbarEmpty(crosspoints);
        validateNotSameHandNeighborCrossbar(crosspoints);
        this.crosspoints = crosspoints;
    }

    private void validateOutsideCrossbarEmpty(List<Crosspoint> crosspoints) {
        Crosspoint firstCrosspoint = crosspoints.get(FIRST_POINT_INDEX);
        Crosspoint lastCrosspoint = crosspoints.get(crosspoints.size() - 1);

        if (firstCrosspoint.hasLeftSideCrossbar() || lastCrosspoint.hasRightSideCrossbar()) {
            throw new IllegalArgumentException("첫번째와 마지막 Crosspoint는 각각 왼쪽, 오른쪽이 비어있어야 합니다.");
        }
    }

    private void validateNotSameHandNeighborCrossbar(List<Crosspoint> crosspoints) {
        for (int i = FIRST_POINT_INDEX; i < crosspoints.size() - 1; i++) {
            validateNotSameHandNeighborAt(crosspoints, i);
        }
    }

    private void validateNotSameHandNeighborAt(List<Crosspoint> crosspoints, int i) {
        Crosspoint checkedCrosspoint = crosspoints.get(i);
        if (checkedCrosspoint.hasCrossbar() &&
                crosspoints.get(i).equals(crosspoints.get(i + NEXT_NEIGHBOR))) {
            throw new IllegalArgumentException("사다리 가로막대는 연속해서 있을 수 없습니다.");
        }
    }

    static LadderRow of(int numberOfPeople) {
        LinkedList<Crosspoint> crosspoints = new LinkedList<>();
        Crosspoint firstCrosspoint = new Crosspoint(false, randomGenerateBoolean());

        crosspoints.add(firstCrosspoint);
        addInnerCrosspointsInto(crosspoints, numberOfPeople - NUM_OF_OUTER_CROSSPOINT);
        crosspoints.add(generateLastCrosspointBy(crosspoints.getLast()));

        return new LadderRow(crosspoints);
    }

    private static boolean randomGenerateBoolean() {
        return Math.random() > RATE_OF_EMPTY_CROSSBARS;
    }

    private static void addInnerCrosspointsInto(LinkedList<Crosspoint> crosspoints, int numberOfInnerCrosspoint) {
        for (int i = 0; i < numberOfInnerCrosspoint; i++) {
            crosspoints.add(generateNewCrosspointBy(crosspoints.getLast()));
        }
    }

    private static Crosspoint generateNewCrosspointBy(Crosspoint lastGenerated) {
        Crosspoint leftHandCrosspoint = new Crosspoint(true, false);
        Crosspoint randomCrosspointWithoutLeftHand = new Crosspoint(false, randomGenerateBoolean());

        return lastGenerated.hasRightSideCrossbar() ? leftHandCrosspoint : randomCrosspointWithoutLeftHand;
    }

    private static Crosspoint generateLastCrosspointBy(Crosspoint lastGenerated) {
        Crosspoint leftHandCrosspoint = new Crosspoint(true, false);
        Crosspoint downwardCrosspoint = new Crosspoint(false, false);

        return lastGenerated.hasRightSideCrossbar() ? leftHandCrosspoint : downwardCrosspoint;
    }

    int answerResultIndexOf(int positionOfPlayer) {
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

    int width() {
        return crosspoints.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRow that = (LadderRow) o;
        return Objects.equals(crosspoints, that.crosspoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crosspoints);
    }
}
