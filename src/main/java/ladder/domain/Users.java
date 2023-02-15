package ladder.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<String> userNames) {

        List<User> collect = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
        this.users = new ArrayList<>(collect);
    }

    public List<User> getUsers() {
        return users;
    }
}
