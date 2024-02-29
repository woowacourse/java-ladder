package ladder.dto;

import java.util.Map;
import java.util.stream.Collectors;
import ladder.domain.LadderGameResult;

public record LadderGameResultDto(Map<String, String> playerToProduct) {

    public static LadderGameResultDto from(LadderGameResult result) {
        Map<String, String> playerToProduct = result.getResults().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        entry -> entry.getValue().getName()
                ));
        return new LadderGameResultDto(playerToProduct);
    }
}
