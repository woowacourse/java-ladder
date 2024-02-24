package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("존재하지 않는 이름이 주어지면 예외를 발생시킨다")
    void nameNotExist() {
        Users users = new Users(List.of("pobi", "rush", "jonge"));

        assertThatThrownBy(() -> users.findPositionByName("brown")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,0","rush,1","jonge,2"})
    @DisplayName("사용자 이름이 주어지면 그 위치를 반환한다")
    void findPositionByName(String name, int position) {
        Users users = new Users(List.of("pobi", "rush", "jonge"));

        assertThat(users.findPositionByName(name)).isEqualTo(position);
    }
}
