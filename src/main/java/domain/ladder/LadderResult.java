package domain.ladder;

import static java.util.stream.Collectors.toMap;

import domain.player.Name;
import domain.prize.Prize;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private static final String NOT_EXISTING_PLAYER_EXCEPTION_MESSAGE = "[ERROR] 잘못된 참가자명: %s - 존재하지 않는 참가자입니다.";

    private final Map<Name, Prize> results;

    public LadderResult(Map<Name, Prize> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public String findPrizeByName(String playerName) {
        Name name = new Name(playerName);
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_PLAYER_EXCEPTION_MESSAGE, name.getValue())
            );
        }

        return results.get(name).getName();
    }

    public Map<String, String> getAllResults() {
        return results.entrySet()
                .stream()
                .collect(toMap(e -> e.getKey().getValue(),
                        e -> e.getValue().getName(),
                        (a, b) -> b,
                        LinkedHashMap::new));
    }
}
