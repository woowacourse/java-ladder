package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.FixedPassGenerator;


class LadderMakerTest {

    private final LadderMaker ladderMaker = new LadderMaker(new FixedPassGenerator(false));

    @Test
    void initLadder_메소드는_Height와_참가자_수를_입력하면_Ladder를_초기화_한다() {
        assertThatCode(() -> ladderMaker.initLadder(new Height(3), 5)).doesNotThrowAnyException();
    }

    @Test
    void getLadder_메소드는_ladder를_반환한다() {
        Height height = new Height(3);
        ladderMaker.initLadder(height, 5);

        Ladder ladder = ladderMaker.getLadder();
        List<Line> lines = ladder.getLines();

        assertThat(lines.size()).isSameAs(3);
        assertThat(lines.get(0).getLine().size()).isSameAs(4);
    }

    @Test
    void generateNames_메소드는_컬렉션_내의_이름_수만큼_NAME을_만들어_NAMES를_생성한다() {
        Names names = ladderMaker.generateNames(List.of("pobi", "crong", "honux", "jk"));

        assertThat(names.getTotalParticipantSize()).isSameAs(4);
    }

    @Test
    void 컬렉션_내_사람이름이_5글자_초과면_예외가_발생한다() {
        assertThatThrownBy(() -> ladderMaker.generateNames(List.of("pobiaaa")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자까지만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","   ","         "})
    void 컬렉션_내_참가자_이름이_공백이면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> ladderMaker.generateNames(List.of(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백일 수 없습니다.");
    }
}