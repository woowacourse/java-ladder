package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RequestNameTest {
    private UserNames userNames;

    @BeforeEach
    void init() {
        userNames = UserNames.from(List.of("a", "b"));
    }

    @DisplayName("입력 받은 결과가 all이나 참여자이면 인스턴스가 생성된다.")
    @ValueSource(strings = {"all", "a"})
    @ParameterizedTest
    void createRequestName(String name) {
        assertThat(new RequestName(name, userNames).getRequestName())
                .isEqualTo(name);
    }

    @DisplayName("입력 받은 결과를 보고 싶은 사람이 all 혹은 참여자가 아니면 예외를 던진다.")
    @Test
    void createRequestNameByInvalidMessage() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RequestName("c", userNames))
                .withMessage("존재하지 않는 참여자입니다.");
    }

    @DisplayName("입력 받은 이름이 `all`이면 false를 아니면 true를 반환한다.")
    @CsvSource(value = {"all:false", "a:true"}, delimiter = ':')
    @ParameterizedTest
    void isAll(String inputName, boolean expected) {
        RequestName requestName = new RequestName(inputName, userNames);

        assertThat(requestName.isNotAll()).isEqualTo(expected);
    }
}
