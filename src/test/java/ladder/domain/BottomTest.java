package ladder.domain;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author 우가
 * @version 1.0.0
 * @Created by 우가 on 2023/02/23
 */
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BottomTest {

    @Test
    void 사다리_실행결과는_참가자수와_다른경우_예외를_던진다() {
        Players players = new Players(of("wuga", "dino"));
        assertThatThrownBy(() -> new Bottom(of("꽝", "당첨", "꽝"), players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과수와 참가자수가 같아야합니다.");
    }
}
