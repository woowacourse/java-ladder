package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.ladder.Ladder;
import model.ladder.Layer;
import model.ladder.Step;
import model.participant.Participants;
import model.prize.Prize;
import model.prize.Prizes;
import model.result.GameResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderTest {
    private Ladder ladder;

    /*
     * 테스트용 사다리 형태
     * |-----|     |-----|
     * |     |-----|     |
     * |_____|     |     |
     *
     * 사다리 결과 (인덱스 기준)
     * 0 -> 2
     * 1 -> 1
     * 2 -> 3
     * 3 -> 0
     */
    @BeforeEach
    void setUp() {
        Layer firstLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));
        Layer secondLayer = new Layer(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));
        Layer thirdLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
        ladder = new Ladder(List.of(firstLayer, secondLayer, thirdLayer));
    }

    @Test
    void 모든_당첨_결과는_각_참여자에게_중복없이_한개씩_배정된다() {
        Participants participants = new Participants(List.of("릴리", "엘라", "애쉬", "다온"));
        Prizes prizes = new Prizes(List.of("당첨1", "당첨2", "당첨3", "당첨4"), 4);
        GameResults results = ladder.climbDownAll(participants, prizes);

        assertThat(results.getGameResults().values().stream().map(Prize::getPrizeName))
                .containsOnly("당첨1", "당첨2", "당첨3", "당첨4");
    }
}
