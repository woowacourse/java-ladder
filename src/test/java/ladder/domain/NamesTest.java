package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class NamesTest {

    @Test
    @DisplayName("사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다.")
    void createNames() {
        assertThatCode(() -> new Names("pobi,honux,crong,jk"))
                .doesNotThrowAnyException();
    }

}