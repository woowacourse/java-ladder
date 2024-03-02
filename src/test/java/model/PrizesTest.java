package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.prize.Prizes;
import org.junit.jupiter.api.Test;

public class PrizesTest {
    @Test
    void 결과_이름_목록의_크기가_참여자수와_다르면_예외가_발생한다() {
        int numberOfParticipants = 5;
        List<String> invalidPrizeNames = List.of("꽝", "1000", "2000", "꽝");

        assertThatThrownBy(() -> new Prizes(invalidPrizeNames, numberOfParticipants)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 결과_이름_목록의_크기가_참여자수와_같으면_예외가_발생하지_않는다() {
        int numberOfParticipants = 5;
        List<String> invalidPrizeNames = List.of("꽝", "1000", "2000", "꽝", "꽝");

        assertThatCode(() -> new Prizes(invalidPrizeNames, numberOfParticipants)).doesNotThrowAnyException();
    }
}
