package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    @DisplayName("높이가 1이상이면 List<Line>이 생성된다.")
    void givenOverOneHeight_thenSuccess(int input) {
        //given
        final Height height = new Height(input);
        final Ladder ladder = Ladder.of(height, 3, new RandomLinkGenerator());

        //then
        assertThat(ladder.getLadder()).hasSize(height.getHeight());
    }
}
