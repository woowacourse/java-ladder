package domain.reward;


import java.util.List;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {this.results = results;}

    public static Results from(List<String> rewards, int playerSize) {
        validateSize(rewards, playerSize);
        return new Results(rewards.stream()
                                  .map(Result::new)
                                  .toList());
    }

    private static void validateSize(List<String> rewards, int playerSize) {
        if (rewards.size() != playerSize) {
            throw new IllegalArgumentException("플레이어 수와 보상의 수가 다릅니다.");
        }
    }

    public Result getRewardAt(int index) {
        return results.get(index);
    }

    public List<Result> getValue() {
        return results;
    }
}
