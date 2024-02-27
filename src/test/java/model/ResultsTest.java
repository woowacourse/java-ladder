package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    void 사다리_결과가_중복되는_인덱스는_없다() {
        Layer firstLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));
        Layer secondLayer = new Layer(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));
        Layer thirdLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
        Ladder ladder = new Ladder(List.of(firstLayer, secondLayer, thirdLayer));
        Participants participants = new Participants(List.of("릴리", "엘라", "애쉬", "다온"));
        Results results = new Results(ladder, participants);

        assertThat(results.getResultIndexes()).contains(0, 1, 2, 3);
    }

}
