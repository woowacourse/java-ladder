package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.dto.ResultDto;

public class LadderGame {

    private final Map<Name, Name> ladderResult;

    public LadderGame(Names players, Ladder ladder, Names rewards) {
        ladderResult = new HashMap<>();
        for (int i = 0; i < players.findNamesCount(); i++) {
            ladderResult.put(
                players.findNameByIndex(i),
                rewards.findNameByIndex(ladder.followLadder(i)));
        }
    }

    public String getReward(Name name) {
        return ladderResult.get(name).toDto();
    }

    public ResultDto toDto() {
        return new ResultDto(ladderResult.entrySet().stream()
            .collect(Collectors
                .toMap(
                    e -> e.getKey().toDto(),
                    e -> e.getValue().toDto()
                )));
    }
}
