package domain;

import domain.name.Names;

import java.util.List;

public class NonDecidedResults {

    private final List<String> NonDecidedResults;

    public NonDecidedResults(Names names, List<String> results) {
        validateSameNumbers(names, results);
        this.NonDecidedResults = results;
    }

    private void validateSameNumbers(Names names, List<String> results) {
        if (names.getNameCount() != results.size()) {
            throw new IllegalArgumentException("[ERROR] 결과의 수는 참여자 수와 일치해야 합니다.");
        }
    }

    public List<String> getNonDecidedResults() {
        return List.copyOf(NonDecidedResults);
    }
}
