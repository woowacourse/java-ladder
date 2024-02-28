package model;

import static org.assertj.core.api.Assertions.assertThat;

import dto.PrizeName;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    void 모든_당첨_결과는_각_참여자에게_중복없이_한개씩_배정된다() {
        Layer firstLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));
        Layer secondLayer = new Layer(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));
        Layer thirdLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
        Ladder ladder = new Ladder(List.of(firstLayer, secondLayer, thirdLayer));
        Participants participants = new Participants(List.of("릴리", "엘라", "애쉬", "다온"));
        Prizes prizes = new Prizes(List.of("당첨1", "당첨2", "당첨3", "당첨4"), 4);
        GameResults results = new GameResults(ladder, participants, prizes);

        assertThat(results.getGameResults().values().stream().map(PrizeName::prizeName))
                .containsOnly("당첨1", "당첨2", "당첨3", "당첨4");
    }
}
