package domain;

import java.util.HashMap;

public class Result {
    private final HashMap<User, Item> result;
    private final Users users;
    private final Items items;
    private final Ladders ladders;


    public Result(Users users, Items items, Ladders ladders) {
        this.result = new HashMap<>();
        this.users = users;
        this.items = items;
        this.ladders = ladders;
    }

    public String getItem(User user) {
        if (!result.containsKey(user)) {
            int index = ladders.getResult(users.getUsers().indexOf(user));
            result.put(user, items.getItems().get(index));
        }
        return result.get(user).getItem();
    }
}
