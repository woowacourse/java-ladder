package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public int gerPersonCount() {
        return users.size();
    }

    public Users(String userNames) {
        List<String> names = Arrays.stream(userNames.split(",")).map(String::trim).toList();
        users = names.stream()
                .map(name -> new User(new UserName(name)))
                .toList();
        validate();
    }

    private void validate() {
        if (users.size() == 1) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 두명 이상이여야 합니다.", users.size()));
        }
        if (users.size() > 50) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최대 50명입니다.", users.size()));
        }
    }
}
