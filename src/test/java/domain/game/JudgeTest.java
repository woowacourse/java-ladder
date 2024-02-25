package domain.game;

import domain.Names;
import domain.Prize;
import domain.Prizes;
import domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class JudgeTest {

    @Test
    @DisplayName("그대로인 경우에 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_sequence_is_same_as_initial() {
        Names names = new Names(new String[]{"mang", "cho", "pobi"});
        Prizes prizes = new Prizes(new String[]{"1000", "500", "30000"});
        Result result = new Result(List.of(0, 1, 2), List.of(0, 1, 2));

        Judge judge = new Judge(names, prizes, result);

        assertSoftly(softly -> {
                    softly.assertThat(judge.getPrize("mang")).isEqualTo(new Prize("1000"));
                    softly.assertThat(judge.getPrize("cho")).isEqualTo(new Prize("500"));
                    softly.assertThat(judge.getPrize("pobi")).isEqualTo(new Prize("30000"));
                }
        );
    }

    @Test
    @DisplayName("반대로 뒤집히는 경우에 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_sequence_reversed() {
        Names names = new Names(new String[]{"mang", "cho", "pobi"});
        Prizes prizes = new Prizes(new String[]{"1000", "500", "30000"});
        Result result = new Result(List.of(0, 1, 2), List.of(2, 1, 0));

        Judge judge = new Judge(names, prizes, result);

        assertSoftly(softly -> {
                    softly.assertThat(judge.getPrize("mang")).isEqualTo(new Prize("30000"));
                    softly.assertThat(judge.getPrize("cho")).isEqualTo(new Prize("500"));
                    softly.assertThat(judge.getPrize("pobi")).isEqualTo(new Prize("1000"));
                }
        );
    }

}
