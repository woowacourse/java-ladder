package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LinesTest {

    @DisplayName("사다리의 높이와 사람 수만큼 라인을 생성한다")
    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "2, 10",
            "3, 5",
    })
    void ladder_test(int personCount, int maxHeight) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            list.add("hi" + i);
        }
        Players players = new Players(list);
        Results results = new Results(list);
        Lines lines = new RandomLadderGenerator().generate(players, maxHeight);
        Ladder ladder = new Ladder(players, results, lines);

        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);
        assertThat(ladder.getHeight()).isEqualTo(maxHeight);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {0, 11})
    void ladder_height_test(int height) {
        Players players = new Players(List.of("a", "b", "c"));
        assertThatThrownBy(() -> new RandomLadderGenerator()
                .generate(players, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상 10 이하여야 합니다.");
    }

    @DisplayName("실행 결과의 수가 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "꽝,5000:user1,user2,user3",
            "꽝,5000,꽝:user1,user2,user3,user4",
            "꽝,5000,꽝,3000:user1,user2,user3",
    }, delimiter = ':')
    void fail(String results, String people) {
        List<String> names = Arrays.stream(people.split(",")).collect(Collectors.toList());
        List<String> resultList = Arrays.stream(results.split(",")).collect(Collectors.toList());
        Lines lines = new RandomLadderGenerator().generate(new Players(names), 5);

        assertThatThrownBy(() -> new Ladder(new Players(names), new Results(resultList), lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 사람 수와 같아야 합니다.");
    }
}
