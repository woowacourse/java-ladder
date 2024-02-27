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
        validateNotEmptyUser(user);
        validateNotEmptyPrize(prize);
        validateAlreadyExistsPrize(prize);
        result.put(user, prize);
    }

    public Prize getUserResult(User user) {
        validateUserMatch(user);
        return result.get(user);
    }

    public HashMap<User, Prize> getAllResult() {
        validateNotEmptyResult();
        return result;
    }

    private void validateNotEmptyUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("[ERROR] 저장하려는 사용자가 존재하지 않습니다.");
        }
    }

    private void validateNotEmptyPrize(Prize prize) {
        if (prize == null) {
            throw new IllegalArgumentException("[ERROR] 저장하려는 당첨품이 존재하지 않습니다.");
        }
    }

    private void validateAlreadyExistsPrize(Prize prize) {
        if (result.containsValue(prize)) {
            throw new IllegalArgumentException("[ERROR] 해당 당첨품은 다른 사용자의 결과로 저장되어 있습니다.");
        }
    }

    private void validateUserMatch(User user) {
        if (!result.containsKey(user)) {
            throw new IllegalArgumentException("[ERROR] 사용자의 결과를 조회할 수 없습니다.");
        }
    }

    private void validateNotEmptyResult() {
        if (result.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 반환할 결과가 없습니다.");
        }
    }
}
