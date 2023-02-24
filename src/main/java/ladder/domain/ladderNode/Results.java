package ladder.domain.ladderNode;

import ladder.dto.ResultDto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(List<String> results, int playerCount) {
        this.results = new ArrayList<>();
        IntStream.range(0, results.size())
                .forEach(i -> this.results.add(new Result(results.get(i), i)));
        validateCount(results, playerCount);
    }

    public List<ResultDto> getResultsByPosition(Map<Position, String> playerPosition) {
        List<ResultDto> results = new ArrayList<>();
        Set<Position> positions = playerPosition.keySet();

        for (Position position : positions) {
            results.add(new ResultDto(playerPosition.get(position), getResultByPosition(position)));
        }
        return Collections.unmodifiableList(results);
    }

    public String getResultByPosition(Position position) {
        return results.stream()
                .filter(result -> result.isMappedPosition(position))
                .findFirst()
                .map(Result::getResult).orElseThrow(() -> new IllegalArgumentException("사다리에 존재하지 않는 위치입니다."));
    }

    private void validateCount(List<String> results, int playerCount) {
        if (results.size() != playerCount) {
            throw new IllegalArgumentException("실행 결과의 개수는 참여자의 개수와 같아야 합니다.");
        }
    }

    public List<String> getResults() {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.toUnmodifiableList());
    }
}
