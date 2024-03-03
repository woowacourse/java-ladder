package model;

import java.util.ArrayList;
import java.util.List;
import model.strategy.BuildStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("원하는 참여자의 결과를 확인한다. 사다리가 빈 경우")
    void findPrizesInEmptyLadder() {
        //given
        Height height = new Height(5);

        List<String> playerNames = List.of("reddy", "anna", "brown");
        Players players = new Players(playerNames);

        List<String> prizeNames = List.of("당첨", "꽝", "꽝");
        Prizes prizes = Prizes.of(prizeNames, players.size());

        Ladder ladder = createNothingBuildLadder(height, players, prizes);

        //when
        Prize expected = new Prize("당첨");
        Player target = new Player("reddy");

        LadderGameResult ladderGameResult = ladder.findResult();

        //then
        Assertions.assertThat(ladderGameResult.getPrize(target.name())).isEqualTo(expected.value());
    }


    @Test
    @DisplayName("원하는 참여자의 결과를 확인한다. 사다리가 지그재그 인 경우")
    void findPrizesInZigZagLadder() {
        //given
        Height height = new Height(5);

        List<String> names = List.of("reddy", "anna", "brown", "teba");
        Players players = new Players(names);

        List<String> prizeNames = List.of("당첨", "꽝1", "꽝2", "꽝3");
        Prizes prizes = Prizes.of(prizeNames, players.size());

        Ladder ladder = createZigZagBuildLadder(height, players, prizes);

        //when
        LadderGameResult target = ladder.findResult();
        LadderGameResult expected = LadderGameResult.of(names, List.of("꽝2", "꽝3", "당첨", "꽝1"));

        //then
        Assertions.assertThat(target).isEqualTo(expected);

    }

    static Ladder createNothingBuildLadder(Height height, Players players, Prizes prizes) {
        BuildStrategy<LadderStatus> buildStrategy = new NothingBuildStrategy();

        List<Line> lines = new ArrayList<>();
        int width = players.size() - 1;
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(width, buildStrategy));
        }

        return new Ladder(lines, players, prizes);
    }

    static Ladder createZigZagBuildLadder(Height height, Players players, Prizes prizes) {
        BuildStrategy<LadderStatus> evenBuildStrategy = new ZigZagStartTrueBuildStrategy();
        BuildStrategy<LadderStatus> oddBuildStrategy = new ZigZagStartFalseBuildStrategy();

        List<Line> lines = new ArrayList<>();
        int width = players.size() - 1;
        for (int i = 0; i < height.value(); i++) {
            if (i % 2 == 0) {
                lines.add(new Line(width, evenBuildStrategy));
                continue;
            }
            lines.add(new Line(width, oddBuildStrategy));
        }

        return new Ladder(lines, players, prizes);
    }

    @Test
    @DisplayName("사다리 결과 요청이 참가자의 전체 결과 요청인지 확인한다.")
    void createAllPlayerResultRequest() {
        //given
        Height height = new Height(5);
        List<String> names = List.of("reddy", "anna", "brown", "teba");
        Players players = new Players(names);

        List<String> prizeNames = List.of("당첨", "꽝1", "꽝2", "꽝3");
        Prizes prizes = Prizes.of(prizeNames, players.size());

        Ladder ladder = createNothingBuildLadder(height, players, prizes);

        //when & then
        String allResultRequest = "all";
        Assertions.assertThat(ladder.isAllResultRequest(allResultRequest)).isTrue();
    }
}
