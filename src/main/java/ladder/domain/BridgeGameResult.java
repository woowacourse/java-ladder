package ladder.domain;

import ladder.dto.BridgeGameResultDto;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {
    private static final String NOT_EXITING_ERROR_MESSAGE = "해당 유저는 존재하지 않습니다,";
    private final Map<User, String> userAndReward;
    private final BridgeGameResultDto resultDto;

    public BridgeGameResult(Map<User, String> rewardData) {
        this.userAndReward = rewardData;
        this.resultDto = makeGameResultDto();
    }

    private BridgeGameResultDto makeGameResultDto() {
        final HashMap<String, String> bridgeGameDto = new HashMap<>();
        for (User user : userAndReward.keySet()) {
            bridgeGameDto.put(user.getName(), userAndReward.get(user));
        }
        return new BridgeGameResultDto(bridgeGameDto);
    }

    public Map<User, String> getUserAndReward() {
        return new HashMap<>(userAndReward);
    }

    public String getRewardOf(final String userName) {
        final User targetUser = userAndReward.keySet().stream()
                .filter((user) -> user.isNameOf(userName))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(NOT_EXITING_ERROR_MESSAGE);
                });
        return userAndReward.get(targetUser);
    }

    public BridgeGameResultDto getBridgeGameResultDto() {
        return resultDto;
    }
}
