package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"seong,0", "io,1", "odo,2", "jay,3"})
    @DisplayName("이름과 시작 인덱스로 참여자가 생성된다.")
    void generatePlayerTest(String name, int startIndex) {
        Assertions.assertDoesNotThrow(() -> new Player(new Name(name), new StartIndex(startIndex)));
    }

    @Test
    @DisplayName("이름을 받아서 같은 이름인지 판별한다.")
    void isSameNameTest() {
        String name = "seong";
        Player player = new Player(new Name(name), new StartIndex(0));

        assertThat(player.isSameName(name)).isTrue();
        assertThat(player.isSameName(name + "1")).isFalse();
    }
}
