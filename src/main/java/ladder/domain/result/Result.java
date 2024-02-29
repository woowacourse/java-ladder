package ladder.domain.result;

import ladder.domain.position.Position;
import ladder.domain.position.Positions;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Result {

    private final Map<String, String> result;

    public Result(List<String> userNames, List<String> prizeNames, List<Position> endPositions) {
        this.result = createResult(userNames, prizeNames, endPositions);
    }

    private Map<String, String> createResult(List<String> userNames, List<String> prizeNames, List<Position> endPositions) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < userNames.size(); i++) {
            Position endPosition = endPositions.get(i);
            result.put(userNames.get(i),
                    prizeNames.get(endPosition.getPosition()));
        }
        return result;
    }

    public String getPrizeByUser(String userName) {
        return result.get(userName);
    }
}
