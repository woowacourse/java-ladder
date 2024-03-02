package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import support.FixedBooleanGenerator;
import support.TrueOnlyGenerator;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FloorTest {
    @Test
    void 주어진_너비만큼_커넥션을_생성한다() {
        // given
        int width = 5;

        // when
        Floor floor = Floor.create(width, new TrueOnlyGenerator());

        // then
        assertThat(floor.getConnections()).hasSize(width);
    }

    @ParameterizedTest
    @MethodSource("provideConnections")
    void 주어진_커넥션대로_사다리_층을_생성한다(List<Boolean> connections, List<Connection> expected) {
        // when
        Floor floor = Floor.create(connections.size(), new FixedBooleanGenerator(connections));

        // then
        List<Connection> result = floor.getConnections();
        assertThat(result).isEqualTo(expected);
    }

    Stream<Arguments> provideConnections() {
        return Stream.of(Arguments.of(
                        // |---|   |   |---|
                        List.of(true, true, false, true, true),
                        List.of(Connection.RIGHT, Connection.LEFT, Connection.DISCONNECTED, Connection.RIGHT,
                                Connection.LEFT)
                ), Arguments.of(
                        // |   |---|   |---|
                        List.of(false, true, true, true, true),
                        List.of(Connection.DISCONNECTED, Connection.RIGHT, Connection.LEFT, Connection.RIGHT,
                                Connection.LEFT)
                )
        );
    }

    @Test
    void 커넥션에_따라_인덱스를_이동한다() {
        // |   |---|   |---|   |
        // given
        List<Boolean> connections = List.of(false, true, true, true, true, false);

        // when
        Floor floor = Floor.create(connections.size(), new FixedBooleanGenerator(connections));

        // then
        assertAll(
                () -> assertThat(floor.crossConnection(0)).isEqualTo(0),
                () -> assertThat(floor.crossConnection(1)).isEqualTo(2),
                () -> assertThat(floor.crossConnection(2)).isEqualTo(1),
                () -> assertThat(floor.crossConnection(3)).isEqualTo(4),
                () -> assertThat(floor.crossConnection(4)).isEqualTo(3),
                () -> assertThat(floor.crossConnection(5)).isEqualTo(5)
        );
    }
}
