package domain;

import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes = new ArrayList<>();

    public Prizes(final List<String> prizeNames, final Users users) {
        validateSize(prizeNames, users);
        for (final String prizeName : prizeNames) {
            prizes.add(new Prize(prizeName));
        }
    }

    private static void validateSize(final List<String> prizeNames, final Users users) {
        if (users.size() != prizeNames.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.PRIZES_COUNT_IS_NOT_EQUAL_USERS_SIZE_EXCEPTION.getMessage());
        }
    }

    //TODO: 나중에 position 을 Position으로 포장할지 고민
    public Prize getPrizeBy(final int position) {
        return prizes.get(position);
    }
}
