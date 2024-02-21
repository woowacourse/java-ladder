package ladder.domain;

import java.util.stream.IntStream;
import ladder.dto.LineResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final Supplier<Boolean> generator;
    private final List<StepStatus> stepStatuses;

    public Line(final Supplier<Boolean> generator, final int userCount) {
        this.generator = generator;
        this.stepStatuses = createStepStatuses(userCount);
    }

    private List<StepStatus> createStepStatuses(final int userCount) {
        final List<StepStatus> stepStatuses = new ArrayList<>(userCount - 1);
        IntStream.range(0, userCount - 1)
                .forEach(i -> stepStatuses.add(generateStepStatus(stepStatuses, i)));
        return stepStatuses;
    }

    private StepStatus generateStepStatus(final List<StepStatus> stepStatuses, final int index) {
        if (index > 0 && stepStatuses.get(index - 1).isExist()) {
            return StepStatus.getStepStatus(false);
        }
        return StepStatus.getStepStatus(generator.get());
    }

    public LineResult getLineResult() {
        return new LineResult(unmodifiableList(stepStatuses));
    }
}
