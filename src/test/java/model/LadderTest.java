package model;

import java.util.ArrayList;
import java.util.List;
import model.strategy.NothingBuildStrategy;
import model.strategy.ZigZagStartFalseBuildStrategy;
import model.strategy.ZigZagStartTrueBuildStrategy;
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
        Assertions.assertThat(ladder.size()).isEqualTo(height.value());
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
    @DisplayName("원하는 참여자의 결과를 확인한다. 사다리가 빈 경우")
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

        LadderResult ladderResult = ladder.findResult(players, result.getPrizes());

        //then
        Assertions.assertThat(ladderResult.getPrize(target.getName())).isEqualTo(expected.value());
    }


    @Test
    @DisplayName("원하는 참여자의 결과를 확인한다. 사다리가 지그재그 인 경우")
        // TODO: 이름 변경 필요
    void createFindByNameZigZag() {
        //given
        Height height = new Height(5);
        int personCount = 4;
        Ladder ladder = createZigZagBuildLadder(height, personCount);

        List<String> names = List.of("레디", "안나", "브라운", "레나");
        Players players = new Players(names);

        List<String> prizes = List.of("당첨", "꽝1", "꽝2", "꽝3");

        Result result = Result.of(prizes, personCount);

        //when
        LadderResult target = ladder.findResult(players, result.getPrizes());

        for (String formattedLine : ladder.getFormattedLines()) {
            System.out.println(formattedLine);
        }

        LadderResult expected = LadderResult.of(names, List.of("꽝2", "꽝3", "당첨", "꽝1"));

        //then
        Assertions.assertThat(target).isEqualTo(expected);

    }

    static Ladder createNothingBuildLadder(Height height, int personCount) {
        var buildStrategy = new NothingBuildStrategy();

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(personCount, buildStrategy));
        }

        return new Ladder(lines);
    }

    static Ladder createZigZagBuildLadder(Height height, int personCount) {
        var evenBuildStrategy = new ZigZagStartTrueBuildStrategy();
        var oddBuildStrategy = new ZigZagStartFalseBuildStrategy();

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.value(); i++) {
            if (i % 2 == 0) {
                lines.add(new Line(personCount, evenBuildStrategy));
                continue;
            }
            lines.add(new Line(personCount, oddBuildStrategy));
        }

        return new Ladder(lines);
    }
}
