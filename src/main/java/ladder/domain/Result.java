package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<Bet> result;

    public Result(Names names, List<String> bets) {
        validate(names, bets);

        this.result = bets.stream()
                .map(Bet::new)
                .collect(Collectors.toList());
    }

    private void validate(Names names, List<String> bets) {
        if (names.size() != bets.size())
            throw new IllegalArgumentException(ErrorMessage.DIFFERENT_PARTICIPANTS_AND_BETS_COUNT.getMessage());
    }

    public void perform(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            changeResultIndex(line);
        }
    }

    private void changeResultIndex(Line line) {
        for (int i = 0; i < line.size(); i++) {
            trySwapResultAtNextIndex(i, line.isExistLineAtCell(i));
        }
    }

    private void trySwapResultAtNextIndex(int index, boolean exist) {
        if (exist) {
            Collections.swap(result, index, index + 1);
        }
    }

    public List<Bet> getResult() {
        return Collections.unmodifiableList(result);
    }

    public int size() {
        return result.size();
    }

}
