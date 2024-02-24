package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UsersTest {
    @Test
    @DisplayName("사용자가 두명 이상 있어야 한다.")
    void createOnlyUsers() {
        String userNames = "pobi";

        assertThatThrownBy(() -> new Users(List.of(userNames.split(","))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자는 최대 50명이다")
    void maxUsers() {
        List<String> userNames = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            userNames.add(String.valueOf(i));
        }
        userNames.add("51");

        assertThatThrownBy(() -> new Users(userNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("존재하지 않는 이름이 주어지면 에러를 발생시킨다")
    void nameNotExist() {
        Users users = new Users(List.of("pobi", "rush", "jonge"));

        assertThatThrownBy(() -> users.findPostionByName("brown")).isInstanceOf(IllegalArgumentException.class);
    }
}
