package laddergame.model.laddergame;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.exception.BaseException;
import laddergame.model.generator.LineConnectionDecisionGenerator;
import laddergame.model.participants.Participants;

public class LadderGameGenerator {
    private final List<List<LineConnectionDecision>> doublyBooleans;

    public LadderGameGenerator(LadderHeight ladderHeight, Participants participants,
                               LineConnectionDecisionGenerator generator) {
        List<List<LineConnectionDecision>> doublyBooleans = generator.generate(ladderHeight, participants);
        validateBooleans(doublyBooleans);
        this.doublyBooleans = doublyBooleans;
    }

    private void validateBooleans(List<List<LineConnectionDecision>> doublyBooleans) {
        if (doublyBooleans == null || doublyBooleans.isEmpty() || checkBooleansSameSize(doublyBooleans)) {
            throw new BaseException("유효하지 않는 값으로 사다리 게임 생성기를 만들 수 없습니다.");
        }
    }

    private boolean checkBooleansSameSize(List<List<LineConnectionDecision>> doublyBooleans) {
        return doublyBooleans.stream()
                .anyMatch(booleans -> booleans.size() != doublyBooleans.get(0).size());
    }

    public LadderGame getLadderGame() {
        return doublyBooleans.stream()
                .map(LineGenerator::new)
                .map(LineGenerator::generate)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderGame::new));
    }
}
