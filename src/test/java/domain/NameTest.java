package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사용자의 이름은 ")
class NameTest {

    @DisplayName("1자 이상 5자 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"j", "joy", "pobi", "crong"})
    public void nameTest_success(String name) {
        Assertions.assertDoesNotThrow(
            () -> new Name(name));
    }

    @DisplayName("1자 미만이거나 6자 이상이면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "joy kim"})
    public void nameTest_fail(String name) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
                () -> new Name(name));
    }

    @DisplayName("처음이나 끝에 공백이 있으면 공백을 제거한다")
    @ParameterizedTest
    @ValueSource(strings = {" joy", " joy ", "joy "})
    public void trimNameTest(String name) {
        Assertions.assertEquals(new Name(name).getName(), name.trim());
    }
}