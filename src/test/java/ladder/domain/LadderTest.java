package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private final PointGenerator pointGenerator = new RandomPointGenerator();

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest() {

        assertThatThrownBy(() -> new Ladder(0, new Users(List.of("1", "2")), pointGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ladder 생성시 1이상의 height를 입력하면 정상 생성된다..")
    void checkValidLadderSizeTest() {

        var users = new Users(List.of("1", "2"));
        var ladder = new Ladder(1, users, pointGenerator);

        assertThat(ladder.getFloors().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Ladder 생성시 users보다 1작은 width로 생성된다.")
    void checkLadderWidthTest() {
        //given
        var users = new Users(List.of("1", "2", "3"));
        //when
        var ladder = new Ladder(3, users, pointGenerator);
        List<Floor> floors = ladder.getFloors();

        //then
        assertThat(floors)
                .map(Floor::getPoints)
                .map(List::size)
                .containsExactlyElementsOf(List.of(2, 2, 2));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    @DisplayName("사다리 결과 도출 로직 테스트")
    void getResultAllTrueTest(int start, int end) {
        //given
        Users users = new Users(List.of("0", "1", "2", "3"));
        Ladder ladder = new Ladder(3, users, () -> true);
        //when
        int result = ladder.getResult(start);
        //then
        assertThat(result).isEqualTo(end);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("사다리 결과 도출 로직 테스트")
    void getResultAllFalseTest(int start, int end) {
        //given
        Users users = new Users(List.of("0", "1", "2", "3"));
        Ladder ladder = new Ladder(3, users, () -> false);
        //when
        int result = ladder.getResult(start);
        //then
        assertThat(result).isEqualTo(end);
    }
}
