package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private static final String INVALID_USER_MESSAGE = "참가자가 존재하지 않습니다.";
    private final HashMap<User, Item> result;
    private final Users users;
    private final Items items;
    private final Ladders ladders;

    public Result(Users users, Items items, Ladders ladders) {
        this.result = new LinkedHashMap<>();
        this.users = users;
        this.items = items;
        this.ladders = ladders;
    }

    public HashMap<User, Item> getItem(User user) {
        generateResult(user);
        return new LinkedHashMap<>(Map.of(user, result.get(user)));
    }

    public HashMap<User, Item> getItemsALL() {
        users.getUsers().forEach(this::generateResult);
        return new LinkedHashMap<>(result);
    }

    private void generateResult(User user) {
        validateUserExists(user);

        if (!result.containsKey(user)) {
            int index = ladders.getResult(users.getUsers().indexOf(user));
            result.put(user, items.getItems().get(index));
        }
    }

    private void validateUserExists(User user) {
        if (isUserExists(user)) {
            throw new IllegalArgumentException(INVALID_USER_MESSAGE);
        }
    }

    public boolean isUserExists(User user) {
        return !users.getUsers()
                .contains(user);
    }
}
