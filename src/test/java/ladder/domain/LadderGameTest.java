package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    private LadderGame ladderGame;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Line line1 = new Line(Arrays.asList(true, false));
        Line line2 = new Line(Arrays.asList(false, false));
        Line line3 = new Line(Arrays.asList(true, false));
        ladder = new Ladder(Arrays.asList(line1, line2, line3));
        ladderGame = new LadderGame(Arrays.asList("pobi","crong","zino"), Arrays.asList("짜장", "짬뽕","탕수육"), ladder);
        ladderGame.play();
    }

    @Test
    void 참여_인원과_결과의_수_동일_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderGame(Arrays.asList("pobi","crong","zino"), Arrays.asList("짜장", "짬뽕"), ladder));
    }

    @Test
    void 전체_결과_출력_테스트() {
        assertThat(ladderGame.play().getResult("all")).isEqualTo("zino : 탕수육\n" +
                "pobi : 짜장\n" +
                "crong : 짬뽕\n");
    }

    @Test
    void 플레이어_결과_출력_테스트() {
        assertThat(ladderGame.play().getResult("zino")).isEqualTo("zino : 탕수육\n" +
                "pobi : 짜장\n" +
                "crong : 짬뽕\n");
    }

    @Test
    void 존재하지_않는_플레이어_결과_출력_테스트() {
        assertThrows(IllegalArgumentException.class, () -> ladderGame.play().getResult("mino"));
    }
}
