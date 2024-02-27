package domain;

import domain.name.Names;

import java.util.List;

public class UndecidedResults {

    private final List<String> UndecidedResults;

    public UndecidedResults(Names names, List<String> UndecidedResults) {
        validateSameNumbers(names, UndecidedResults);
        this.UndecidedResults = UndecidedResults;
    }

    private void validateSameNumbers(Names names, List<String> UndecidedResults) {
        if (names.getNameCount() != UndecidedResults.size()) {
            throw new IllegalArgumentException("[ERROR] 결과의 수는 참여자 수와 일치해야 합니다.");
        }
    }

    public List<String> getUndecidedResults() {
        return List.copyOf(UndecidedResults);
    }
}
