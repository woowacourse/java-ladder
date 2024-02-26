package model;

import exception.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public record LadderResultDto(Map<String, String> playersPrizeResults) {

    public static LadderResultDto of(List<String> playerNames, List<String> prizes) {
        Map<String, String> result = new LinkedHashMap<>();
        // TODO: players와 prizes의 사이즈가 다르게 온다면?
        // 예외 던지기
        // 이전에 한번 검증을 하지만 public 으로 열려있기 때문에 누가 언제 어디서 사용할 지 모름
        for (int i = 0; i < playerNames.size(); i++) {
            result.put(playerNames.get(i), prizes.get(i));
        }
        return new LadderResultDto(result);
    }

    public String getPrize(String name) {
        if (!playersPrizeResults.containsKey(name)) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_NAME_ERROR.getMessage());
        }
        return playersPrizeResults.get(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LadderResultDto ladderResultDto)) {
            return false;
        }
        return Objects.equals(playersPrizeResults, ladderResultDto.playersPrizeResults);
    }
}
