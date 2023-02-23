package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.dto.ResultDto;

public class LadderGame {

    /**
     * 해당 클래스를 사용해서 게임 결과 정보를 계산하고 저장하는데, 멤버변수가 너무 많은 것 같습니다. 하지만 구현할 수 있는 다른 방법을 떠올리지 못해서 이렇게
     * 남겨뒀는데, 혹시 개선할 수 있는 방법이 있을까요?
     */
    private Names players;
    private Rows rows;
    private Names rewards;
    private Map<Name, Name> resultMap;

    public LadderGame(Names players, Rows rows, Names rewards) {
        this.players = players;
        this.rows = rows;
        this.rewards = rewards;
        resultMap = new HashMap<>();
    }

    public void makeResultMap() {
        for (int i = 0; i < players.getCount(); i++) {
            resultMap.put(players.getElement(i), rewards.getElement(rows.followLadder(i)));
        }
    }

    public String getReward(Name name) {
        return resultMap.get(name).toDto();
    }

    public ResultDto toDto() {
        return new ResultDto(resultMap.entrySet().stream()
            .collect(Collectors
                .toMap(
                    e -> e.getKey().toDto(),
                    e -> e.getValue().toDto()
                )));
    }
}
