package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "aaaaa"})
    @DisplayName("유저 정상 생성 테스트")
    void makeValidUserTest(String value) {
        assertThatCode(() ->
                new User(value)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "aaaaaa"})
    @DisplayName("유저 생성 예외 메시지 테스트")
    void makeInvalidUserNameLengthMessageTest(String value) {
        assertThatThrownBy(() -> new User(value))
                .hasMessageContaining("유저 이름 길이는 공백이거나 6 이상일 수 없습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("해당 이름을 갖고 있는 User인지 확인하는 메서드 테스트")
    void checkUserNameTest() {
        final User testUser = new User("a");
        assertThat(testUser.isNameOf("a")).isTrue();
    }

}
