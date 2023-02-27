package ladder.domain.ladder;

import ladder.domain.rule.StoolGenerator;

import java.util.List;
import java.util.Stack;

public class Line {

    private final StoolGenerator stoolGenerator;
    private final List<Stool> stools;

    public Line(final int playerNumber, final StoolGenerator stoolGenerator) {
        this.stoolGenerator = stoolGenerator;
        this.stools = makeStools(playerNumber - 1);
    }

    private List<Stool> makeStools(final int blockCount) {
        Stack<Stool> temporaryStools = new Stack<>();
        temporaryStools.push(stoolGenerator.generate());
        while (temporaryStools.size() != blockCount) {
            Stool stool = generateStools(temporaryStools.peek());
            temporaryStools.push(stool);
        }
        return List.copyOf(temporaryStools);
    }

    private Stool generateStools(final Stool previousStool) {
        if (previousStool.isExistStool()) {
            return Stool.EMPTY;
        }
        return stoolGenerator.generate();
    }

    public int goDownAndGetLocation(final int currentLocation) {
        int newLocation = currentLocation;
        if (hasWayToGo(currentLocation)) {
            newLocation = getUpdatedLocation(currentLocation);
        }
        return newLocation;
    }

    private boolean hasWayToGo(final int location) {
        return isStoolExistAt(location - 1) || isStoolExistAt(location);
    }

    private boolean isStoolExistAt(final int location) {
        if (location < 0 || location >= stools.size()) {
            return false;
        }
        return stools.get(location) == Stool.EXIST;
    }

    private int getUpdatedLocation(final int location) {
        if (isStoolExistAt(location)) {
            return location + 1;
        }
        return location - 1;
    }

    public List<Stool> getStools() {
        return List.copyOf(stools);
    }
}
