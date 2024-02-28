package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import controller.LadderDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    private final Names names = new Names(List.of("pobi", "gugu", "neo"));
    private final Lines lines = new Lines(5, 3, new RandomPointGenerator());
    private final Results results = new Results(List.of("꽝", "5000", "꽝"), 3);

    @Test
    @DisplayName("사다리에 필요한 요소들을 조합한다.")
    void buildLadder() {
        Names names = new Names(List.of("pobi", "gugu", "neo"));
        Lines lines = new Lines(5, 3, new RandomPointGenerator());
        Results results = new Results(List.of("꽝", "5000", "꽝"), 3);

        Ladder ladder = new Ladder()
                .names(names)
                .lines(lines)
                .results(results)
                .build();

        assertAll(
                () -> assertThat(ladder.names()).isEqualTo(names),
                () -> assertThat(ladder.lines()).isEqualTo(lines),
                () -> assertThat(ladder.results()).isEqualTo(results)
        );
    }

    @Test
    @DisplayName("사다리를 DTO로 변환한다.")
    void toDto() {
        Ladder ladder = new Ladder()
                .names(names)
                .lines(lines)
                .results(results)
                .build();

        LadderDto ladderDto = ladder.toDto();

        assertAll(
                () -> assertThat(ladderDto.getNames()).isEqualTo(names.getAll()),
                () -> assertThat(ladderDto.getLines()).isEqualTo(getLines()),
                () -> assertThat(ladderDto.getResults()).isEqualTo(results.getAll())
        );
    }

    private List<List<Boolean>> getLines() {
        return lines.getLines().stream()
                .map(Line::getMovableLinePoints)
                .toList();
    }
}
