package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final Supplier<Boolean> generator;
    private final List<StepStatus> stepStatuses;

    public Line(final Supplier<Boolean> generator, final int userCount) {
        this.generator = generator;
        this.stepStatuses = initStepStatuses(userCount);
    }

    private List<StepStatus> initStepStatuses(final int userCount) {
        final List<StepStatus> stepStatuses = new ArrayList<>(userCount - 1);
        for (int i = 0; i < userCount - 1; i++) {
            stepStatuses.add(generateStepStatus(stepStatuses, i));
        }
        return stepStatuses;
    }

    private StepStatus generateStepStatus(final List<StepStatus> stepStatuses, final int index) {
        if (index > 0 && stepStatuses.get(index - 1).isExist()) {
            return StepStatus.getStepStatus(false);
        }
        return StepStatus.getStepStatus(generator.get());
    }

    public List<StepStatus> getStepStatuses() {
        return unmodifiableList(stepStatuses);
    }
}
