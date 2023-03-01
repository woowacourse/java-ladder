package ladder.dto;

import java.util.Map;

public class BridgeGameResultDto {
    private final Map<String, String> userAndReward;

    public BridgeGameResultDto(Map<String,String> dtoData){
        this.userAndReward = dtoData;
    }

    public Map<String, String> getUserAndReward() {
        return userAndReward;
    }
}
