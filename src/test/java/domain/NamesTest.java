package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @DisplayName("사다리 게임 참여자의 이름이 하나라도 잘못 입력된 경우 예외를 발생시킨다.")
    @Test
    void validateTest() {
        List<String> names = List.of("odo", "odo27", "kong", "konghana");
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("사다리 게임 참여자의 이름이 정상적으로 입력된 경우 참여자들을 생성한다.")
    @Test
    void validateTest2() {
        List<String> names = List.of("odo", "odo27", "kong", "ko ng", "  ko    ");
        assertThatCode(() -> new Names(names))
                .doesNotThrowAnyException();
    }
}
