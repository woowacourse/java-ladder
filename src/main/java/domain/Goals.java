package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Goals {
    public static final String DIFFERENT_FROM_PARTICIPANTS_SIZE_ERROR_MESSAGE = "참가자 숫자와 동일한 수만큼 입력해주세요.";
    private final List<Goal> goals;

    private Goals(List<Goal> goals) {
        this.goals = goals;
    }

    public static Goals of(int participantsSize, List<String> goalNames) {
        if (goalNames.size() != participantsSize) {
            throw new IllegalArgumentException(DIFFERENT_FROM_PARTICIPANTS_SIZE_ERROR_MESSAGE);
        }

        List<Goal> goals = goalNames.stream()
                .map(Goal::of)
                .collect(Collectors.toList());

        return new Goals(goals);
    }
}
