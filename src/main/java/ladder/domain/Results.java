package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(String[] inputResults, int playerCount) {
        validateCount(inputResults.length, playerCount);
        this.results = Arrays.stream(inputResults)
                .map(Result::new)
                .collect(Collectors.toList());;
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

            position = move(position, steps);
        }

        return results.get(position).getResult();
    }

    private int move(int position, List<Step> steps) {
        if (canMoveLeft(position, steps)) {
            return --position;
        }
        if (canMoveRight(position, steps)) {
            return ++position;
        }
        return position;
    }

    private boolean canMoveRight(int position, List<Step> steps) {
        return position != steps.size() && steps.get(position) == Step.EXIST;
    }

    private boolean canMoveLeft(int position, List<Step> steps) {
        return position != 0 && steps.get(position - 1) == Step.EXIST;
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
