package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void 참가자가_정상적으로_생성된다() {
        final Player player = new Player("name", Position.valueOf(0));

        assertThat(player.getName()).isEqualTo("name");
    }

    @ParameterizedTest(name = "입력받은 위치와 같은 위치인지 확인한다. 위치: {0}, 결과 {1}")
    @CsvSource({"0,true", "1,false"})
    void 입력받은_위치와_같은_위치인지_확인한다(final int position, final boolean result) {
        final Player player = new Player("item", Position.valueOf(0));

        assertThat(player.isSamePosition(Position.valueOf(position))).isEqualTo(result);
    }
}
