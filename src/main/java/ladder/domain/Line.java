package ladder.domain;

import java.util.stream.IntStream;
import ladder.dto.LineResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final List<StepStatus> stepStatuses;

    public Line(Supplier<Boolean> generator, final int userCount) {
        this.stepStatuses = createStepStatuses(generator, userCount);
    }

    private List<StepStatus> createStepStatuses(Supplier<Boolean> generator, final int userCount) {
        final List<StepStatus> stepStatuses = new ArrayList<>(userCount - 1);
        for (int i = 0; i < userCount - 1; i++) {
            stepStatuses.add(generateStepStatus(generator, stepStatuses, i));
        }
        return stepStatuses;
    }

    private StepStatus generateStepStatus(
            Supplier<Boolean> generator,
            final List<StepStatus> stepStatuses,
            final int index) {
        if (index > 0 && stepStatuses.get(index - 1).isExist()) {
            return StepStatus.getStepStatus(false);
        }
        return StepStatus.getStepStatus(generator.get());
    }

    public LineResult getLineResult() {
        return new LineResult(unmodifiableList(stepStatuses));
    }
}
