package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Names names;
    private final Results results;

    private LadderGame(Names names, Results results) {
        this.names = names;
        this.results = results;
    }

    public static LadderGame of(Names names, Ladder ladder, Results unsortedResults) {
        List<Result> results = IntStream.range(0, names.size())
                .mapToObj(startPosition -> unsortedResults.get(ladder.getResultPositionOf(startPosition)))
                .collect(Collectors.toList());
        return new LadderGame(names, new Results(results, names));
    }

    public Result getResultOf(String inputName) {
        validateExistName(inputName);
        int position = names.getPositionOf(inputName);
        return results.get(position);
    }

    private void validateExistName(String inputName) {
        names.stream()
                .filter(name -> name.value().equals(inputName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자 이름입니다."));
    }

    public Names getAllNames() {
        return this.names;
    }

    public Results getAllResults() {
        return this.results;
    }

}
