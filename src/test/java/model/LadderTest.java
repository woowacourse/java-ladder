package model;

import java.util.ArrayList;
import java.util.List;
import model.strategy.NothingBuildStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 높이가 사다리 객체의 크기가 된다.")
    void createLadderWithHeight() {
        // given
        Height height = new Height(5);
        int personCount = 7;

        // when
        Ladder ladder = Ladder.of(height, personCount);

        // when
        Assertions.assertThat(ladder.size()).isEqualTo(height.getValue());
    }

    @Test
    @DisplayName("사다리 모양의 객체를 반환한다.")
    void createFormattedLadder() {
        //given
        int personCount = 5;
        var height = new Height(4);

        List<String> expected = List.of("|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |");

        //when
        Ladder ladder = createNothingBuildLadder(height, personCount);

        //then
        Assertions.assertThat(ladder.getFormattedLines()).isEqualTo(expected);
    }

    @Test
    @DisplayName("원하는 참여자의 결과를 확인한다.")
    void createFindByPlayerName() {
        //given
        Height height = new Height(5);
        int personCount = 3;
        Ladder ladder = createNothingBuildLadder(height, personCount);

        List<String> names = List.of("레디", "안나", "브라운");
        Players players = new Players(names);

        List<String> prizes = List.of("당첨", "꽝", "꽝");

        Result result = Result.of(prizes, personCount);

        //when
        Prize expected = new Prize("당첨");
        Player target = new Player("레디");

        //then
        Assertions.assertThat(ladder.findResult(players, target, result.getPrizes())).isEqualTo(expected);
    }



    static Ladder createNothingBuildLadder(Height height, int personCount) {
        var buildStrategy = new NothingBuildStrategy();

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(personCount, buildStrategy));
        }

        return new Ladder(lines);
    }
}
