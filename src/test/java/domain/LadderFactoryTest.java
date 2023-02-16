package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("LadderFactory 는")
public class LadderFactoryTest {

    @Test
    void LadderFactory는_가로와_세로를_받아_사다리를_생성한다() {
        // given
        int width = 5;
        int height = 10;
        LadderFactory factory = new LadderFactory(() -> Scaffold.NONE);

        // when & then
        assertDoesNotThrow(() -> factory.createLadder(width, height));
    }

    @Test
    void createLadder_를_통해_생성된_Ladder_는_높이가_height_이다() {
        // given
        int width = 5;
        int height = 10;
        LadderFactory factory = new LadderFactory(() -> Scaffold.NONE);

        // when
        Ladder ladder = factory.createLadder(width, height);

        // then
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @Test
    void createLadder_를_통해_생성된_Ladder_는_너비가_width_이다() {
        // given
        int width = 5;
        int height = 10;
        LadderFactory factory = new LadderFactory(() -> Scaffold.NONE);

        // when
        Ladder ladder = factory.createLadder(width, height);

        // then

        assertThat(ladder.getWidth()).isEqualTo(width);
    }

    @ParameterizedTest(name = "createLadder 시 ScaffoldGenerator 가 생성해준 값으로 생성한다")
    @MethodSource("scaffolds")
    void createLadder시_ScaffoldGenerator가_생성해준_값으로_생성한다(final List<Scaffold> scaffolds) {
        // given
        int width = 2;
        int height = 2;
        ArrayList<Scaffold> assertScaffolds = new ArrayList<>(scaffolds);
        LadderFactory factory = new LadderFactory(() -> scaffolds.remove(0));

        // when
        Ladder ladder = factory.createLadder(width, height);

        // then
        for (int i = 0; i < ladder.getHeight(); i++) {
            for (int j = 0; j < ladder.getWidth(); j++) {
                Scaffold scaffold = ladder.getLines().get(i)
                        .getScaffolds().get(j);
                Scaffold assertScaffold = assertScaffolds.remove(0);
                Assertions.assertThat(scaffold).isEqualTo(assertScaffold);
            }
        }
    }

    static Stream<Arguments> scaffolds() {
        List<Scaffold> scaffolds1 = List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE);
        List<Scaffold> scaffolds2 = List.of(Scaffold.NONE, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE);
        List<Scaffold> scaffolds3 = List.of(Scaffold.NONE, Scaffold.NONE, Scaffold.NONE, Scaffold.NONE);
        List<Scaffold> scaffolds4 = List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST);

        return Stream.of(
                Arguments.of(new ArrayList<>(scaffolds1)),
                Arguments.of(new ArrayList<>(scaffolds2)),
                Arguments.of(new ArrayList<>(scaffolds3)),
                Arguments.of(new ArrayList<>(scaffolds4))
        );
    }

    @DisplayName("createLadder 시 ScaffoldGenerator 가 연속으로 EXIST를 생성할 경우, 나중에 생성된 값이 NONE으로 설정된다")
    @Test
    void createLadder_consist_test() {
        // given
        int width = 2;
        int height = 2;
        List<Scaffold> scaffolds = new ArrayList<>(List.of(Scaffold.EXIST, Scaffold.EXIST, Scaffold.EXIST, Scaffold.EXIST));
        List<Scaffold> assertScaffolds = new ArrayList<>(List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE));

        LadderFactory factory = new LadderFactory(() -> scaffolds.remove(0));

        // when
        Ladder ladder = factory.createLadder(width, height);

        // then
        for (int i = 0; i < ladder.getHeight(); i++) {
            for (int j = 0; j < ladder.getWidth(); j++) {
                Scaffold scaffold = ladder.getLines().get(i).getScaffolds().get(j);
                Scaffold assertScaffold = assertScaffolds.remove(0);
                Assertions.assertThat(scaffold).isEqualTo(assertScaffold);
            }
        }
    }
}
