package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.MadeLineDto;

public class Line {

    private static final boolean DEFAULT_NO_DUPLICATED_STEP = false;

    private final List<Step> steps;

    public Line(final int stepSpaceCount) {
        this.steps = makeSteps(stepSpaceCount);
    }

    public MadeLineDto getSteps() {
        return new MadeLineDto(steps);
    }

    public void buildSteps(int position) {
        validateNotNegativePosition(position);
        steps.get(position).build();
    }

    public boolean isStepDuplicatedWithBeforeStep(int nowPosition) {
        validateNotNegativePosition(nowPosition);

        if (nowPosition > 0) {
            Step step = steps.get(nowPosition - 1);
            return step.getBuildStatus();
        }
        return DEFAULT_NO_DUPLICATED_STEP;
    }

    private List<Step> makeSteps(int stepCount) {
        List<Step> steps = new ArrayList<>();

        for (int currentStep = 0; currentStep < stepCount; currentStep++) {
            steps.add(new Step());
        }
        return steps;
    }

    private void validateNotNegativePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("중복 확인 발판의 위치는 음수일 수 없습니다.");
        }
    }
}
