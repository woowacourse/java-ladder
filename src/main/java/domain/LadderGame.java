package domain;

import java.util.stream.Collectors;

public class LadderGame {
    private final Names names;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(Names names, Ladder ladder, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
    }

    public Result getResultOf(String inputName) {
        validateExistName(inputName);
        int startPosition = names.getPositionOf(inputName);
        int resultPosition = ladder.getResultPositionOf(startPosition);
        return results.get(resultPosition);
    }

    private void validateExistName(String inputName) {
        names.stream()
                .filter(name -> name.value().equals(inputName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자 이름입니다."));
    }

    public Results getAllResult() {
        return new Results(names.stream()
                .map(name -> getResultOf(name.value()))
                .collect(Collectors.toList()),
                names.size());
    }
}
