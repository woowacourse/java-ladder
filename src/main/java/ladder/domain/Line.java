package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final Supplier<Boolean> randomBooleanGenerator;
    private final List<StepStatus> stepStatuses;

    public Line(final Supplier<Boolean> randomBooleanGenerator, final int userCount) {
        this.randomBooleanGenerator = randomBooleanGenerator;
        this.stepStatuses = initStepStatuses(userCount);
    }

    private List<StepStatus> initStepStatuses(final int userCount) {
        int totalStepStatusesSize = userCount - 1;
        final List<StepStatus> stepStatuses = new ArrayList<>(totalStepStatusesSize);
        for (int i = 0; i < totalStepStatusesSize; i++) {
            stepStatuses.add(generateStepStatus(stepStatuses, i));
        }
        return stepStatuses;
    }

    private StepStatus generateStepStatus(final List<StepStatus> stepStatuses, final int index) {
        if (index > 0 && stepStatuses.get(index - 1).isExist()) {
            return StepStatus.getStepStatus(false);
        }
        return StepStatus.getStepStatus(randomBooleanGenerator.get());
    }

    public List<StepStatus> getStepStatuses() {
        return unmodifiableList(stepStatuses);
    }
}
