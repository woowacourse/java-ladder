package laddergame.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.GameResult;

public class ResultsDto {

    private final List<String> results;

    public ResultsDto(List<GameResult> gameResults) {
        results = gameResults.stream()
                .map(GameResult::getResult)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getResults() {
        return results;
    }
}
