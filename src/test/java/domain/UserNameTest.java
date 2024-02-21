package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserNameTest {
    @Test
    @DisplayName("이름을 갖는 사용자를 생성한다.")
    void userNameTest() {
        //given
        String userName = "pobia";
        //when
        //then
        assertThatCode(() -> new User(new UserName(userName)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자 이름은 5글자 이하이다.")
    void userNameLengthTest() {
        //given
        String userName = "rushrush";
        //when
        //then
        assertThatThrownBy(() -> new User(new UserName(userName))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 이름은 비어 있을 수 없다")
    void userNameEmptyTest() {
        //given
        String userName = "";
        //when
        //then
        assertThatThrownBy(() -> new User(new UserName(userName))).isInstanceOf(IllegalArgumentException.class);
    }

}