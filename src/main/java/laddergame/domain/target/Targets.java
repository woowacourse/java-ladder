package laddergame.domain.target;

import laddergame.domain.result.Trace;
import laddergame.util.InputValidator;

import javax.xml.validation.Validator;
import java.util.List;

public class Targets {
    private List<Target> targets;

    public Targets(final List<String> input, final int size) {
        validateSize(input, size);
        this.targets = convertToTargets(input);
    }

    public Target convertToTarget(final Trace trace) {
        int position = trace.getPosition();

        return targets.get(position);
    }

    public List<Target> getTargets() {
        return targets;
    }

    private void validateSize(final List<String> input, final int size) {
        if (input.size() != size) {
            throw new IllegalArgumentException("[ERROR] 실행 결과와 참여자 수가 같지 않습니다.");
        }
    }

    private List<Target> convertToTargets(final List<String> input) {
        return input.stream()
                .map(laddergame.domain.target.Target::new)
                .toList();
    }
}
