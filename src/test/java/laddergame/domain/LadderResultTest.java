package laddergame.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultTest {
    @DisplayName("참여자와 크기가 다를 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesSizeIsNotEqualToParticipants() {
        // given
        PersonalNames personalNames = new PersonalNames(List.of("hi", "oh", "bye"));
        List<String> resultItemNames = List.of("꽝");

        // when, then
        Assertions.assertThatThrownBy(() -> LadderResult.of(personalNames, resultItemNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성했던 이름들을 반환한다.")
    @Test
    void getNames() {
        // given
        PersonalNames personalNames = new PersonalNames(List.of("hi", "bye"));
        LadderResult ladderResult = LadderResult.of(personalNames, List.of("꽝", "10000"));

        //when
        List<String> itemNames = ladderResult.getItemNames();

        //then
        Assertions.assertThat(itemNames).containsExactly("꽝", "10000");
    }
}
