package domain;

import helper.AbstractTestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest extends AbstractTestFixture {

    @ParameterizedTest(name = "사다리의 높이는 양수만 가능하다")
    @ValueSource(ints = {1, 999})
    void test_ladder_height_success(int height) {
        //given
        List<Line> lines = createLines(height);
        People defaultPerson = createDefaultPerson();
        List<String> resultCandidates = createResultCandidates(defaultPerson.getParticipantsSize());

        //when
        Ladder ladder = new Ladder(defaultPerson, lines, resultCandidates);

        //then
        assertEquals(ladder.getLines().size(), height);
    }

    @Test
    @DisplayName("사다리의 높이가 양수가 아니면 IllegalArgumentException를 던진다")
    void test_ladder_height_throws() {
        //given
        People people = createDefaultPerson();

        //when & then
        assertThatThrownBy(() -> new Ladder(people, createLines(0),
                                            createResultCandidates(people.getParticipantsSize())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line들로 Ladder를 생성한다")
    void test_createLadder_with_lines() {
        // given
        List<Line> lines = List.of(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true))
        );

        // when & then
        assertThatNoException().isThrownBy(() -> new Ladder(createDefaultPerson(),
                                                            lines,
                                                            createResultCandidates(2))
        );
    }

    @Test
    @DisplayName("People 객체는 immutable 하다.")
    void test_immutable_person() throws Exception {
        //given
        List<Person> person = new ArrayList<>();
        person.add(new Person("aaa"));
        person.add(new Person("bbb"));

        List<Line> lines = List.of(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true))
        );

        People people = new People(person);

        Ladder ladder = new Ladder(people, lines, createResultCandidates(people.getParticipantsSize()));

        int beforePeopleSize = people.getParticipantsSize();

        //when

        person.remove(0);

        int afterPeopleSize = ladder.getParticipantNames().size();

        //then
        assertEquals(beforePeopleSize, afterPeopleSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5, 6})
    @DisplayName("실행 결과의 개수는 참가자 수와 같지 않으면 IllegalArgumentException 를 던진다.")
    void test_equalsResultSizeAndPeopleSize_IllegalArgumentException(int size) throws Exception {
        //given
        List<Line> lines = createLines(5);

        People people = new People(
                List.of(new Person("aa"),
                        new Person("bb"),
                        new Person("cc"),
                        new Person("dd"))
        );

        List<String> resultCandidates = createResultCandidates(size);

        //when & then
        assertThatThrownBy(() -> new Ladder(people, lines, resultCandidates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 개수는 참가자 수와 같아야합니다.");
    }

    @Test
    @DisplayName("사다리 게임 시작하면 각 참여자의 결과를 알 수 있다")
    void start_ladder1() throws Exception {
        //given
        People people = new People(List.of(new Person("pobi"),
                                           new Person("honux"),
                                           new Person("crong"),
                                           new Person("jk")));

        List<Line> lines = List.of(
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, false, false))
        );

        List<String> resultCandidate = List.of("꽝", "5000", "1000", "3000");

        //when

        Ladder ladder = new Ladder(people, lines, resultCandidate);

        Map<String, String> result = ladder.getLadderMatchingResult();

        //then

//          pobi  honux crong jk
//          |     |-----|     |
//          |-----|     |-----|
//          |     |-----|     |
//          |-----|     |-----|
//          |     |     |     |
//          꽝    5000  1000    3000

        assertAll(
                () -> assertEquals(result.get("pobi"), "3000"),
                () -> assertEquals(result.get("honux"), "1000"),
                () -> assertEquals(result.get("crong"), "5000"),
                () -> assertEquals(result.get("jk"), "꽝")
        );
    }

    @Test
    @DisplayName("사다리 게임 시작하면 각 참여자의 결과를 알 수 있다")
    void start_ladder2() throws Exception {
        //given
        People people = new People(List.of(new Person("pobi"),
                                           new Person("honux"),
                                           new Person("crong"),
                                           new Person("jk")));

        List<Line> lines = List.of(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, false)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true))
        );

        List<String> resultCandidate = List.of("꽝", "5000", "꽝", "3000");

        //when

        Ladder ladder = new Ladder(people, lines, resultCandidate);

        Map<String, String> result = ladder.getLadderMatchingResult();

        //then

//      pobi  honux crong jk
//      |-----|     |-----|
//      |     |-----|     |
//      |-----|     |     |
//      |     |-----|     |
//      |-----|     |-----|
//      꽝    5000  꽝    3000

        assertAll(
                () -> assertEquals(result.get("pobi"), "꽝"),
                () -> assertEquals(result.get("honux"), "3000"),
                () -> assertEquals(result.get("crong"), "꽝"),
                () -> assertEquals(result.get("jk"), "5000")
        );


    }
}
