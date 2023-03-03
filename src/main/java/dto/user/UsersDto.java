package dto.user;

import domain.user.Users;
import java.util.List;

public class UsersDto {
    private final List<String> userNames;

    private UsersDto(List<String> userNames) {
        this.userNames = userNames;
    }

    public static UsersDto from(Users users) {
        return new UsersDto(users.getUserNames());
    }

    public List<String> getUserNames() {
        return userNames;
    }
}
