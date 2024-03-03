package ladder.domain.game;

import java.util.HashMap;
import java.util.LinkedHashMap;
import ladder.domain.resource.prize.Prize;
import ladder.domain.resource.user.User;

public class GameResult {

    private final HashMap<User, Prize> result;

    public GameResult() {
        this.result = new LinkedHashMap<>();
    }

    public void save(User user, Prize prize) {
        validateUserToSave(user);
        validatePrizeToSave(prize);
        result.put(user, prize);
    }

    public Prize getUserResult(User user) {
        validateUserResultExist(user);
        return result.get(user);
    }

    public HashMap<User, Prize> getAllResult() {
        validateResultNotNull();
        return result;
    }

    private void validateUserToSave(User userToSave) {
        validateResourceNotNull(userToSave, GameResource.RESOURCE_NAME_USERS);
    }

    private void validatePrizeToSave(Prize prizeToSave) {
        validateResourceNotNull(prizeToSave, GameResource.RESOURCE_NAME_PRIZES);
        validatePrizeAlreadyExistsToOtherUser(prizeToSave);
    }

    private void validateResourceNotNull(Object valueToAdd, String resourceName) {
        if (valueToAdd == null) {
            String errorMessage = String.format("[ERROR] 게임 결과에에 저장할 %s가(이) 존재하지 않습니다.", resourceName);
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
