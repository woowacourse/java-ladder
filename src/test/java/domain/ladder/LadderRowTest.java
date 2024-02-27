package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import support.ConnectedLadderRungGenerator;
import support.DisconnectedLadderRungGenerator;
import support.FixedLadderRungGenerator;

@TestInstance(Lifecycle.PER_CLASS)
public class LadderRowTest {
    @Test
    void 주어진_너비만큼_가로대를_생성한다() {
        // given
        final int width = 5;

        // when
        LadderRow ladderRow = LadderRow.create(width, new ConnectedLadderRungGenerator());

        // then
        assertThat(ladderRow.getRungs()).hasSize(width);
    }

    @Test
    void 이전_가로대가_연결되어_있으면_가로대를_연속해서_놓을_수_없다() {
        // given
        LadderRungGenerator connectedLadderRungGenerator = new ConnectedLadderRungGenerator();

        // when
        LadderRow ladderRow = LadderRow.create(4, connectedLadderRungGenerator);

        // then
        List<LadderRung> rungs = ladderRow.getRungs();
        assertAll(
                () -> assertThat(rungs.get(0).isConnected()).isTrue(),
                () -> assertThat(rungs.get(1).isConnected()).isFalse(),
                () -> assertThat(rungs.get(2).isConnected()).isTrue(),
                () -> assertThat(rungs.get(3).isConnected()).isFalse()
        );
    }

    @Test
    void 가로대가_연결되어_있으면_타고_이동한다() {
        // given
        LadderRungGenerator connectedLadderRungGenerator = new ConnectedLadderRungGenerator();
        List<String> names = new ArrayList<>(List.of("프린", "땡이", "포비", "토미"));

        // when
        LadderRow ladderRow = LadderRow.create(names.size() - 1, connectedLadderRungGenerator);
        ladderRow.crossRungs(names);

        // then
        assertThat(names).containsExactly("땡이", "프린", "토미", "포비");
    }

    @Test
    void 가로대가_연결되어_있지_않으면_타고_이동하지_않는다() {
        // given
        LadderRungGenerator disconnectedLadderRungGenerator = new DisconnectedLadderRungGenerator();
        List<String> names = new ArrayList<>(List.of("프린", "땡이", "포비", "토미"));

        // when
        LadderRow ladderRow = LadderRow.create(names.size() - 1, disconnectedLadderRungGenerator);
        ladderRow.crossRungs(names);

        // then
        assertThat(names).containsExactly("프린", "땡이", "포비", "토미");
    }

    @ParameterizedTest
    @MethodSource("provideRungConnections")
    void 주어진_가로대_연결정보로_타고_이동한다(List<LadderRung> ladderRungs, List<String> result) {
        // given
        LadderRungGenerator fixedLadderRungGenerator = new FixedLadderRungGenerator(ladderRungs);
        List<String> names = new ArrayList<>(List.of("프린", "땡이", "포비", "토미"));

        // when
        LadderRow ladderRow = LadderRow.create(names.size() - 1, fixedLadderRungGenerator);
        ladderRow.crossRungs(names);

        // then
        assertThat(names).containsExactlyElementsOf(result);
    }

    private Stream<Arguments> provideRungConnections() {
        return Stream.of(
                Arguments.of(
                        List.of(LadderRung.DISCONNECTED, LadderRung.DISCONNECTED, LadderRung.CONNECTED),
                        List.of("프린", "땡이", "토미", "포비")),
                Arguments.of(
                        List.of(LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.DISCONNECTED),
                        List.of("땡이", "프린", "포비", "토미")),
                Arguments.of(
                        List.of(LadderRung.DISCONNECTED, LadderRung.CONNECTED, LadderRung.DISCONNECTED),
                        List.of("프린", "포비", "땡이", "토미")),
                Arguments.of(
                        List.of(LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.CONNECTED),
                        List.of("땡이", "프린", "토미", "포비"))
        );
    }
}
