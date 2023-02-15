package ladder.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<String> userNames) {
        int inputNamesSize = userNames.size();
        long unDuplicationNamesSize = userNames.stream().distinct().count();
        if(inputNamesSize != unDuplicationNamesSize){
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }

        if (userNames.size() <= 1){
            throw new IllegalArgumentException("유저는 한명보다 많아야 합니다.");
        }
        List<User> collect = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
        this.users = new ArrayList<>(collect);
    }

    public List<User> getUsers() {
        return users;
    }
}
