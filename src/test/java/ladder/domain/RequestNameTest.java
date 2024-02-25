package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RequestNameTest {
    @DisplayName("입력 받은 결과를 보고 싶은 사람이 all 혹은 참여자가 아니면 예외를 던진다.")
    @Test
    void createRequestNameByInvalidMessage() {
        UserNames userNames = UserNames.from(List.of("a", "b"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RequestName("c", userNames))
                .withMessage("존재하지 않는 참여자입니다.");
    }

    @DisplayName("입력 받은 이름이 `all`이면 true를 아니면 false를 반환한다.")
    @CsvSource(value = {"all:true", "a:false"}, delimiter = ':')
    @ParameterizedTest
    void isAll(String inputName, boolean expected) {
        UserNames userNames = UserNames.from(List.of("a", "b"));
        RequestName requestName = new RequestName(inputName, userNames);

        assertThat(requestName.isAll()).isEqualTo(expected);
    }
}
