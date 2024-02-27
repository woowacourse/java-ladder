package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ResultNameTest {
    @DisplayName("이름 목록에 있는 이름이거나 'all' 을 입력하면 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"all", "1", "2"})
    void validateNameTest(String name) {
        List<String> names = List.of("1", "2");
        Players players = new Players(names);
        Assertions.assertThatCode(() -> new ResultName(name, players)).doesNotThrowAnyException();
    }
}
