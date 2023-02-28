package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.generator.ExistConnectionGenerator;
import domain.generator.NonExistConnectionGenerator;
import domain.generator.RandomConnectionGenerator;

public class LinesTest {

    @ParameterizedTest
    @CsvSource({"4, 5", "3, 3", "5, 3"})
    @DisplayName("n명의 플레이어와 m의 높이가 주어졌을 때, Lines 생성을 확인한다.")
    void returns_lines(int numberOfPlayers, int height) {
        // given
        int expectedLadderWidth = numberOfPlayers - 1;

        // when
        Lines lines = new Lines(numberOfPlayers, height, new RandomConnectionGenerator());

        // then

        assertSoftly(softly -> {
            softly.assertThat(lines.getLines().get(0).getConnections().size()).isEqualTo(expectedLadderWidth);
            softly.assertThat(lines.getLines().size()).isEqualTo(height);
        });
    }

    @DisplayName("goDown 메서드는 Connection이 없는 사다리에서 이름의 위치를 받았을 때 같은 위치에 있는 결과 값을 반환한다.")
    @Test
    void returns_result_at_same_index_when_ladder_has_not_connection() {
        // given
        int namePosition = 0;
        List<String> givenNames = List.of("pobi", "honux", "crong", "jk");

        Names names = new Names(givenNames);
        Lines lines = new Lines(names.getNames().size(), 5, new NonExistConnectionGenerator());

        // when
        int finalPosition = lines.goDown(namePosition);

        // then
        assertThat(givenNames.get(finalPosition)).isEqualTo(givenNames.get(namePosition));
    }

    @DisplayName("goDown 메서드는 사다리에서 이름의 위치를 받았을 때 결과 값의 위치를 반환한다.")
    @Test
    void returns_result_index_when_name_index_given() {
        // given
        int namePosition = 0;
        List<String> givenNames = List.of("pobi", "honux", "crong", "jk");

        Names names = new Names(givenNames);
        Lines lines = new Lines(names.getNames().size(), 5, new ExistConnectionGenerator());

        // when
        int finalPosition = lines.goDown(namePosition);

        // then
        assertThat(givenNames.get(finalPosition)).isEqualTo(givenNames.get(1));
    }
}
