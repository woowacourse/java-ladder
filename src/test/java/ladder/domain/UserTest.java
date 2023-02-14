package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"a","aaaaa"})
    @DisplayName("유저 정상 생성 테스트")
    void makeValidUserTest(String value) {
        assertThatCode(()->
            new User(value)
        ).doesNotThrowAnyException();
    }
}
