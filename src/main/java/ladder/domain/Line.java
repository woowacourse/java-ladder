package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final Supplier<Boolean> randomBooleanGenerator;
    private final List<PathStatus> pathStatuses;

    public Line(final Supplier<Boolean> randomBooleanGenerator, final int userCount) {
        this.randomBooleanGenerator = randomBooleanGenerator;
        this.pathStatuses = initStepStatuses(userCount);
    }

    private List<PathStatus> initStepStatuses(final int userCount) {
        int totalStepStatusesSize = userCount - 1;
        final List<PathStatus> pathStatuses = new ArrayList<>(totalStepStatusesSize);
        for (int i = 0; i < totalStepStatusesSize; i++) {
            pathStatuses.add(generateStepStatus(pathStatuses, i));
        }
        return pathStatuses;
    }

    private PathStatus generateStepStatus(final List<PathStatus> pathStatuses, final int index) {
        int prevStepStatusIndex = index - 1;
        if (index > 0 && pathStatuses.get(prevStepStatusIndex).isExist()) {
            return PathStatus.getStepStatus(false);
        }
        return PathStatus.getStepStatus(randomBooleanGenerator.get());
    }

    public List<PathStatus> getStepStatuses() {
        return unmodifiableList(pathStatuses);
    }
}
