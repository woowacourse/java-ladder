package model;

import exception.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderResult { //TODO: 개인적으로 이름이 마음에 안듦

    // TODO: 뷰에 전달할 때, String, String 형태의 dto를 반환하여야 할까?
    // 아니면 객체를 활용해야 하나
    private final Map<String, String> result; // TODO: result 라는 이름도 구려 수정 필요

    public LadderResult(final Map<String, String> result) {
        this.result = result;
    }

    public static LadderResult of(List<String> playerNames, List<String> prizes) {
        Map<String, String> result = new LinkedHashMap<>();
        // TODO: players와 prizes의 사이즈가 다르게 온다면?
        // 예외 던지기
        // 이전에 한번 검증을 하지만 public 으로 열려있기 때문에 누가 언제 어디서 사용할 지 모름
        for (int i = 0; i < playerNames.size(); i++) {
            result.put(playerNames.get(i), prizes.get(i));
        }
        return new LadderResult(result);
    }

    public String getPrize(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_NAME_ERROR.getMessage());
        }
        return result.get(name);
    }

    public Map<String, String> getResult() {
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LadderResult ladderResult)) {
            return false;
        }
        return Objects.equals(result, ladderResult.result);
    }
}
