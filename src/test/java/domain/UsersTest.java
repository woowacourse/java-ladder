package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UsersTest {

    @Test
    @DisplayName("User 리스트를 갖는 Users를 생성한다.")
    void createUsersByNames() {
        //given
        String userNames = "pobi,honux,crong,jk";
        //when
        //then
        assertThatCode(() -> new Users(List.of(userNames.split(","))))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자가 두명 이상 있어야 한다.")
    void createOnlyUsers() {
        //given
        String userNames = "pobi";
        //when
        //then
        assertThatThrownBy(() -> new Users(List.of(userNames.split(","))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자는 최대 50명이다")
    void maxUsers() {
        //given
        List<String> userNames = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            userNames.add(String.valueOf(i));
        }
        userNames.add("51");
        //when
        //then
        assertThatThrownBy(() -> new Users(userNames)).isInstanceOf(IllegalArgumentException.class);
    }
}
