package domain.game;

import domain.db.Name;
import domain.db.Names;
import domain.db.Prize;
import domain.db.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class JudgeTest {

    @Test
    @DisplayName("그대로인 경우에 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_sequence_is_same_as_initial() {
        Names names = new Names(new String[]{"mang", "cho", "pobi"});
        Prizes prizes = new Prizes(new String[]{"1000", "500", "30000"});
        PathMapper pathMapper = new PathMapper(List.of(0, 1, 2));

        Judge judge = new Judge(names, prizes, pathMapper);
        Map<Name, Prize> totalResult = judge.search("all");

        assertSoftly(softly -> {
                    softly.assertThat(totalResult.get(new Name("mang"))).isEqualTo(new Prize("1000"));
                    softly.assertThat(totalResult.get(new Name("cho"))).isEqualTo(new Prize("500"));
                    softly.assertThat(totalResult.get(new Name("pobi"))).isEqualTo(new Prize("30000"));
                }
        );
    }

    @Test
    @DisplayName("반대로 뒤집히는 경우에 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_sequence_reversed() {
        Names names = new Names(new String[]{"mang", "cho", "pobi"});
        Prizes prizes = new Prizes(new String[]{"1000", "500", "30000"});
        PathMapper pathMapper = new PathMapper(List.of(2, 1, 0));

        Judge judge = new Judge(names, prizes, pathMapper);
        Map<Name, Prize> totalResult = judge.search("all");

        assertSoftly(softly -> {
                    softly.assertThat(totalResult.get(new Name("mang"))).isEqualTo(new Prize("30000"));
                    softly.assertThat(totalResult.get(new Name("cho"))).isEqualTo(new Prize("500"));
                    softly.assertThat(totalResult.get(new Name("pobi"))).isEqualTo(new Prize("1000"));
                }
        );
    }

    @Test
    @DisplayName("존재하지 않는 이름에 대한 상품을 요구하면 예외가 발생하는가")
    void throws_exception_when_require_prize_for_non_exist_name() {
        Names names = new Names(new String[]{"mang", "cho", "pobi"});
        Prizes prizes = new Prizes(new String[]{"1000", "500", "30000"});
        PathMapper pathMapper = new PathMapper(List.of(2, 1, 0));

        Judge judge = new Judge(names, prizes, pathMapper);

        assertThatThrownBy(() -> judge.search("none"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다.");
    }
}
