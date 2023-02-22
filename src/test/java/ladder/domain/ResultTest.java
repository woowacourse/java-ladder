package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 검색할_이름_입력_시_해당_결과를_반환한다() {
        Players players = new Players(List.of("name1", "name2"));
        Result result = new Result(players, List.of("꽝", "우승"));

        assertThat(result.resultByName("name1")).containsValue("꽝");
        assertThat(result.resultByName("name2")).containsValue("우승");
    }

    @Test
    void all_입력_시_전체_결과를_반환한다() {
        Players players = new Players(List.of("name1", "name2", "name3"));
        Result result = new Result(players, List.of("꽝", "우승", "꽝"));

        assertThat(result.resultByName("all")).containsValues("꽝", "꽝", "우승");
    }
}
