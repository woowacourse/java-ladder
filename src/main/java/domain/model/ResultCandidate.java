package domain.model;

import java.util.List;

public class ResultCandidate {
    private final List<String> results;

    public ResultCandidate(List<String> results,int numberOfPeople) {
        validateSize(results,numberOfPeople);
        this.results = results;
    }
    private void validateSize(List<String> results,int numberOfPeople){
        if(results.size()!=numberOfPeople) {
            throw new IllegalArgumentException("결과는 사람 수와 일치해야 합니다.");
        }
    }
}
