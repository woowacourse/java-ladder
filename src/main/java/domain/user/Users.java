package domain.user;

import domain.Position;
import domain.ladder.Line;
import domain.prize.Prizes;
import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Users {

    protected static final String ALL_USERS = "all";

    private final List<User> users = new ArrayList<>();

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        validateDuplicateName(userNames);
        for (final String userName : userNames) {
            users.add(new User(userName));
        }
    }

    private void validateUserNamesEmpty(final List<String> userNames) {
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicateName(final List<String> userNames) {
        if (userNames.stream().distinct().count() != userNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.USERS_NAME_HAS_DUPLICATE.getMessage());
        }
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return users.size();
    }

    public void swapUserByLine(final Line line) {
        final List<Position> linkedIndexes = line.getLinkedPositions();
        linkedIndexes.forEach(position -> Collections.swap(users, position.getValue(), position.getValue() + 1));
    }

    public Map<String, String> getPrizeAndUserName(final String userName, final Prizes prizes) {
        if (userName.equals(ALL_USERS)) {
            return getAllUsersAndPrizes(prizes);
        }
        validateParticipateUser(userName);
        return Map.of(userName, getPrizeNameByUserName(prizes, userName));
    }

    private void validateParticipateUser(final String userName) {
        if (!users.contains(new User(userName))) {
            throw new IllegalArgumentException(ErrorMessage.USER_NOT_FOUND_EXCEPTION.getMessage());
        }
    }

    private Map<String, String> getAllUsersAndPrizes(final Prizes prizes) {
        return users.stream()
                .collect(Collectors.toUnmodifiableMap(User::getName,
                        (User user) -> getPrizeNameByUserName(prizes, user.getName())));
    }

    private String getPrizeNameByUserName(final Prizes prizes, final String userName) {
        final int userIndex = users.indexOf(new User(userName));
        return prizes.getPrizeBy(new Position(userIndex)).getName();
    }
}
