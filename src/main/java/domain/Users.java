package domain;

import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {

    //TODO: User에서도 이 상수에 접근 가능해야 함 protected? public?.
    private static final String ALL_USERS = "all";

    private final List<User> users = new ArrayList<>();

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        for (final String userName : userNames) {
            users.add(new User(userName));
        }
    }

    private void validateUserNamesEmpty(final List<String> userNames) {
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    public List<String> getUserNames() {
        final List<String> usersName = new ArrayList<>();
        for (final User user : users) {
            usersName.add(user.getName());
        }
        return usersName;
    }

    public int size() {
        return users.size();
    }

    //TODO: 하나로 합칠 수 없는 지 고민해보기. private도
    public void validateParticipateUser(final String userName) {
        final Optional<User> findUser = users.stream()
                .filter(user -> user.isSameName(userName))
                .findFirst();
        if (findUser.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USER_NOT_FOUND_EXCEPTION.getMessage());
        }
    }

    public int getIndexByUserName(final String userName) {
        validateParticipateUser(userName);
        return users.indexOf(new User(userName));
    }

    public void swapUserByLine(final Line line) {
        final List<Integer> linkedIndexes = line.getLinkedIndexes();
        linkedIndexes.forEach(index -> Collections.swap(users, index, index + 1));
    }

    public Map<String, String> getPrizeAndUserName(final String userName, final Prizes prizes) {
        if (userName.equals(ALL_USERS)) {
            return getAllUsersAndPrizes(prizes);
        }
        return users.stream()
                .filter(user -> user.isSameName(userName))
                .collect(Collectors.toUnmodifiableMap(User::getName,
                        (User user) -> getPrizeByUserName(prizes, userName).getName()));
    }

    private Prize getPrizeByUserName(final Prizes prizes, final String userName) {
        final int userIndex = getIndexByUserName(userName);
        return prizes.getPrizeBy(userIndex);
    }

    private Map<String, String> getAllUsersAndPrizes(final Prizes prizes) {
        return users.stream()
                .collect(Collectors.toUnmodifiableMap(User::getName,
                        (User user) -> getPrizeByUserName(prizes, user.getName()).getName()));
    }
}
