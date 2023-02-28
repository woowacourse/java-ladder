package laddergame.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.User;

public class UsersNameDto {
    private final List<String> names;

    public UsersNameDto(List<User> users) {
        names = users.stream()
                .map(User::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNames() {
        return names;
    }
}
