package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinesTest {
    @Test
    @DisplayName("높이 값 만큼 Line을 생성한다.")
    void createLines() {
        int height = 5;
        int personCount = 4;
        LineGenerator lineGenerator = new LineGenerator(personCount, new RandomBooleanGenerator());
        Lines lines = new Lines(height, lineGenerator);

        assertEquals(height, lines.getLines().size());
    }

    @Test
    @DisplayName("참가자들의 사다리 게임 결과를 반환한다.(참가자2명, 높이3)")
    void playGameWith2namesAnd3heights() {
        int testHeight = 3;
        int testPersonCount = 2;

        BooleanGenerator booleanGenerator = new PlayersTest.FixedBooleanGenerator(true);
        LineGenerator lineGenerator = new LineGenerator(testPersonCount, booleanGenerator);
        Lines lines = new Lines(testHeight, lineGenerator);
        // 사다리 생성 결과
        // pobi  tebah
        //     |-----|
        //     |-----|
        //     |-----|

        Names names = new Names(List.of("pobi", "tebah"));
        Map<Name, Integer> gameResult = lines.playGame(names);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, gameResult.get(new Name("pobi"))),
                () -> Assertions.assertEquals(0, gameResult.get(new Name("tebah")))
        );
    }

    @Test
    @DisplayName("참가자들의 사다리 게임 결과를 반환한다.(참가자4명, 높이3)")
    void playGameWith3namesAnd4heights() {
        int testHeight = 3;
        int testPersonCount = 4;

        BooleanGenerator booleanGenerator = new PlayersTest.FixedBooleanGenerator(true);
        LineGenerator lineGenerator = new LineGenerator(testPersonCount, booleanGenerator);
        Lines lines = new Lines(testHeight, lineGenerator);
        // 사다리 생성 결과
        // pobi  tebah  honux  crong
        //       |-----|     |-----|
        //       |-----|     |-----|
        //       |-----|     |-----|

        Names names = new Names(List.of("pobi", "tebah", "honux", "crong"));
        Map<Name, Integer> gameResult = lines.playGame(names);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, gameResult.get(new Name("pobi"))),
                () -> Assertions.assertEquals(0, gameResult.get(new Name("tebah"))),
                () -> Assertions.assertEquals(3, gameResult.get(new Name("honux"))),
                () -> Assertions.assertEquals(2, gameResult.get(new Name("crong")))
        );
    }
}
