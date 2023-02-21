package ladder.domain;

import ladder.domain.strategy.linestrategy.Result;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> inputResults, int playerCount) {
        validateCount(inputResults.size(), playerCount);
        this.results = inputResults.stream()
                .map(inputResult -> new Result(inputResult))
                .collect(Collectors.toList());
    }

    private void validateCount(int resultCount, int playerCount) {
        if (resultCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 입력된 결과의 수가 인원 수와 다를 수 없습니다.");
        }
    }

    public String findResult(List<Line> ladder, int position) {
        for (int i = 0; i < ladder.size(); i++) {
            Line line = ladder.get(i);
            List<Step> steps = line.getSteps();

            if (position == 0) {
                if (steps.get(position) == Step.EXIST) {
                    position++;
                    continue;
                }
                break;
            }
            if (position == steps.size()) {
                if (steps.get(steps.size() - 1) == Step.EXIST) {
                    position--;
                    continue;
                }
                break;
            }
            if (steps.get(position - 1) == Step.EXIST) {
                position--;
                continue;
            }
            if (steps.get(position) == Step.EXIST) {
                position++;
            }
        }

        return results.get(position).getResult();
    }
}
