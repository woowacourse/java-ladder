package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.prize.Prize;
import ladder.domain.user.User;

public class GameResult {

    private final Map<User, Prize> result;

    public GameResult() {
        this.result = new LinkedHashMap<>();
    }

    public void save(User user, Prize prize) {
        validateResourceNotNull(user, GameResource.RESOURCE_NAME_USERS);
        validateResourceNotNull(prize, GameResource.RESOURCE_NAME_PRIZES);
        validatePrizeAlreadyExistsToOtherUser(prize);
        result.put(user, prize);
    }

    public Prize getUserResult(User user) {
        validateUserResultExist(user);
        return result.get(user);
    }

    public Map<User, Prize> getAllResult() {
        validateResultNotNull();
        return result;
    }

    private void validateResourceNotNull(Object valueToAdd, String resourceName) {
        if (valueToAdd == null) {
            String errorMessage = String.format("[ERROR] 게임 결과에 저장할 %s가(이) 존재하지 않습니다.", resourceName);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validatePrizeAlreadyExistsToOtherUser(Prize prize) {
        if (result.containsValue(prize)) {
            throw new IllegalArgumentException("[ERROR] 해당 당첨품은 다른 사용자의 결과로 저장되어 있습니다.");
        }
    }

    private void validateUserResultExist(User user) {
        if (!result.containsKey(user)) {
            throw new IllegalArgumentException("[ERROR] 사용자의 결과를 조회할 수 없습니다.");
        }
    }

    private void validateResultNotNull() {
        if (result.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 반환할 결과가 없습니다.");
        }
    }
}
