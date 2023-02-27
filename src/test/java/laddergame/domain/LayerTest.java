package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LayerTest {

    @Nested
    static class CreateLayerTest {

        @ParameterizedTest
        @DisplayName("Players가 두 명 이상이면 Layer이 생성된다.")
        @ValueSource(ints = {2, 5, 10})
        void givenTwoMorePlayers_thenCreateLine(final int numberOfPlayers) {
            assertThatCode(() -> Layer.of(numberOfPlayers, new RandomLinkGenerator()))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("Layer의 길이가 1보다 작으면 예외가 발생한다.")
        void givenTwoLessPlayers_thenFail() {

            final int minLinkCount = 1;

            assertThatThrownBy(() -> Layer.of(minLinkCount, new RandomLinkGenerator()))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(String.format("Layer의 길이는 %d보다 작을 수 없습니다.", minLinkCount));
        }

        @Test
        @DisplayName("Layer가 생성되면 List<Link>이 생성된다.")
        void givenLine_thenCreateBooleanList() {
            //given
            final List<Boolean> statuses = List.of(true, false, false);

            //when
            final Layer layer = Layer.of(statuses.size(), new TestLinkGenerator(statuses));

            //then
            assertThat(layer)
                    .extracting(Layer::getLayer)
                    .isEqualTo(List.of(Link.CONNECTION, Link.DISCONNECTION));
        }
    }

    @Test
    @DisplayName("Layer가 겹치지 않는다.")
    void givenLine_thenNotOverLap() {
        //given
        final List<Boolean> statuses = List.of(true, true, false);
        final Layer layer = Layer.of(statuses.size(), new TestLinkGenerator(statuses));

        //then
        assertThat(layer)
                .extracting(Layer::getLayer)
                .isEqualTo(List.of(Link.CONNECTION, Link.DISCONNECTION));
    }

}
