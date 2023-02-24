package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final static int FIRST_LINE = 0;

    private final List<Result> results;

    public Results(String[] inputResults, int playerCount) {
        validateCount(inputResults.length, playerCount);
        this.results = Arrays.stream(inputResults)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validateCount(int resultCount, int playerCount) {
        if (resultCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 입력된 결과의 수가 인원 수와 같아야 합니다.");
        }
    }

    public String findResult(List<Line> ladder, int position) {
        for (Line line : ladder) {
            List<Step> steps = line.getSteps();
            position = move(steps, position);
        }
        return results.get(position).getResult();
    }

    private int move(List<Step> steps, int position) {
        if (canMoveLeft(steps, position)) {
            return position - 1;
        }
        if (canMoveRight(steps, position)) {
            return position + 1;
        }
        return position;
    }

    private boolean canMoveLeft(List<Step> steps, int position) {
        int left = position - 1;
        return position != FIRST_LINE && steps.get(left) == Step.EXIST;
    }

    private boolean canMoveRight(List<Step> steps, int position) {
        int right = position;
        return position != steps.size() && steps.get(right) == Step.EXIST;
    }

    public List<String> findAllResult(List<Line> ladder) {
        return IntStream.range(0, results.size())
                .mapToObj(x -> findResult(ladder, x))
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
