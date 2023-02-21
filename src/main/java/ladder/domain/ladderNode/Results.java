package ladder.domain.ladderNode;

import ladder.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = new ArrayList<>();
        IntStream.range(0, results.size())
                .forEach(i -> this.results.add(new Result(results.get(i), i)));
    }

    public List<ResultDto> getResultsByPosition(Map<Position, String> playerPosition) {
        List<ResultDto> results = new ArrayList<>();
        Set<Position> positions = playerPosition.keySet();

        for (Position position : positions) {
            results.add(new ResultDto(playerPosition.get(position), getResultByPosition(position)));
        }
        return results;
    }

    public String getResultByPosition(Position position) {
        return results.stream()
                .filter(result -> result.isMappedPosition(position))
                .findFirst()
                .map(Result::getResult).orElseThrow(() -> new IllegalArgumentException("사다리에 존재하지 않는 위치입니다."));
    }

    public List<String> getResults() {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.toUnmodifiableList());
    }
}
