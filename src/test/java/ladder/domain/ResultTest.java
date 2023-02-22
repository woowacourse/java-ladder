package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author 우가
 * @version 1.0.0
 * @Created by 우가 on 2023/02/22
 */
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ResultTest {

    @Test
    void 실행결과의_수가_참여자수보다_작을경우_예외를_던진다() {
        Players players = new Players(List.of("name1", "name2"));
        assertThatThrownBy(() -> new Result(players, List.of("꽝")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행결과의_수가_참여자수보다_큰경우_예외를_던진다() {
        Players players = new Players(List.of("name1", "name2"));
        assertThatThrownBy(() -> new Result(players, List.of("꽝", "꽝", "꽝")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
