package domain.prize;

import domain.Position;
import domain.user.Users;
import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                    ErrorMessage.PRIZES_SIZE_IS_NOT_EQUAL_USERS_SIZE_EXCEPTION.getMessage());
        }
    }

    public Prize getPrizeBy(final Position position) {
        return prizes.get(position.getValue());
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
