package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Targets {
    private final List<Target> targets;

    private Targets(List<Target> targets, PlayerCount playerCount) {
        validate(targets, playerCount);
        this.targets = targets;
    }

    public static Targets from(List<String> results, PlayerCount playerCount) {
        return new Targets(convertToResult(results), playerCount);
    }

    private void validate(List<Target> targets, PlayerCount playerCount) {
        if (!playerCount.isSameWith(targets.size())) {
            throw new IllegalArgumentException("참여자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
    }

    private static List<Target> convertToResult(List<String> results) {
        return results.stream()
                .map(Target::new)
                .collect(Collectors.toList());
    }
}
