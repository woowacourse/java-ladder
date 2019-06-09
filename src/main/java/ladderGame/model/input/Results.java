package ladderGame.model.input;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private List<Result> results;

    public Results(List<String> splittedInputs, int playersSize) {
        results = new ArrayList();

        checkResultsLengthIsEqualTo(splittedInputs, playersSize);
        for (String splittedInput : splittedInputs) {
            results.add(new Result(splittedInput));
        }
    }

    private void checkResultsLengthIsEqualTo(List<String> splittedInputs, int playersSize) {
        if (splittedInputs.size() != playersSize) {
            throw new IllegalStateException("결과 수는 플레이어 수와 같아야 합니다.");
        }
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Result result : results) {
            names.add(result.getName());
        }
        return names;
    }
}
