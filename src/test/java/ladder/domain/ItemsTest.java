package ladder.domain;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemsTest {

    @Test
    void 실행결과는_참가인원과_동일한_개수가_아니라면_예외를_던진다() {
        assertThatThrownBy(() -> Items.from(of("item1", "item2"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가인원과 동일한 개수의 실행결과를 입력해야 합니다.");
    }

}
