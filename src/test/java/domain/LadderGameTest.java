package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomValueGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void init() {
        ladderGame = new LadderGame();
    }

    @DisplayName("이름을 입력 받았을 때 People 객체가 생성되어야 한다.")
    @Test
    void PEOPLE_객체_생성() {
        List<String> names = List.of("p1", "p2", "p3");
        People people = ladderGame.createPeople(names);

        Assertions.assertAll(
                () -> {
                    for (int i = 0; i < names.size(); i++) {
                        assertEquals(people.getPeople().get(i).getName().getPersonName(), names.get(i));
                    }
                }
        );
    }

    @DisplayName("중복죈 이름을 입력 받았을 때 예외처리")
    @Test
    void PEOPLE_중복이름_예외_테스트() {
        List<String> names = List.of("p", "p", "p");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    ladderGame.createPeople(names);
                }
        );
    }

    @DisplayName("라인들을 받았을 때 Lines 객체가 생성되어야 한다.")
    @Test
    void LINES_객체_생성() {
        final int height = 3;
        final int width = 3;
        Lines lines = ladderGame.createLines(width, height);

        Assertions.assertAll(
                () -> {
                    assertEquals(lines.getClass(), Lines.class);
                    assertEquals(lines.getLines().size(), height);
                }
        );
    }

    @DisplayName("Person과 Line을 주고 이동 테스트")
    @Test
    void Person_이동_테스트() {
        People people = new People(Arrays.asList(new Person("aa", 0), new Person("bb", 1)));
        Lines lines = new Lines(Arrays.asList(Line.newInstanceWithPersonCount(people.getPeople().size(),
                new TestFlapValueBooleanGenerator())));
        ladderGame.processResult(people, lines);

        Assertions.assertEquals(1, people.getPeople().get(0).getPosition());
        Assertions.assertEquals(0, people.getPeople().get(1).getPosition());
    }

    class TestFlapValueBooleanGenerator implements RandomValueGenerator {

        boolean flag = false;

        @Override
        public boolean generate() {
            flag = !flag;
            return flag;
        }
    }
}
