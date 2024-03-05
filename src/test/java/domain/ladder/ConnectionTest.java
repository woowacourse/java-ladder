package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class ConnectionTest {
    @Nested
    class 첫_번째_커넥션 {
        @Test
        void 연결_여부가_true면_항상_오른쪽으로_연결된다() {
            // given
            boolean isConnected = true;

            // when
            Connection connection = Connection.first(isConnected);

            // then
            assertThat(connection).isEqualTo(Connection.RIGHT);
        }

        @Test
        void 연결_여부가_false면_연결되지_않는다() {
            // given
            boolean isConnected = false;

            // when
            Connection connection = Connection.first(isConnected);

            // then
            assertThat(connection).isEqualTo(Connection.DISCONNECTED);
        }
    }

    @Nested
    class 마지막_커넥션 {
        @Test
        void 오른쪽으로_연결되어_있으면_연결되지_않은_커넥션으로_만든다() {
            // given
            Connection lastConnection = Connection.RIGHT;

            // when
            Connection changedLastConnection = lastConnection.makeLastConnection();

            // then
            assertThat(changedLastConnection).isEqualTo(Connection.DISCONNECTED);
        }

        @ParameterizedTest
        @EnumSource(value = Connection.class, names = {"LEFT", "DISCONNECTED"})
        void 왼쪽으로_연결되어_있거나_연결되지_않았으면_그대로_리턴한다(Connection lastConnection) {
            // when
            Connection changedLastConnection = lastConnection.makeLastConnection();

            // then
            assertThat(changedLastConnection).isEqualTo(lastConnection);
        }
    }

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class 나머지_커넥션 {
        @Test
        void 현재_커넥션이_오른쪽으로_연결되어_있을_때_다음_커넥션은_항상_왼쪽으로_연결된다() {
            // given
            Connection currentConnection = Connection.RIGHT;

            // when
            Connection nextConnection = currentConnection.next(false);

            // then
            assertThat(nextConnection).isEqualTo(Connection.LEFT);
        }

        @ParameterizedTest
        @MethodSource("provideExpectedConnectionOfLeft")
        void 현재_커넥션이_왼쪽으로_연결되어_있을_때_다음_커넥션은_연결_여부에_따라_달라진다(boolean isConnected, Connection expected) {
            // given
            Connection currentConnection = Connection.LEFT;

            // when
            Connection nextConnection = currentConnection.next(isConnected);

            // then
            assertThat(nextConnection).isEqualTo(expected);
        }

        Stream<Arguments> provideExpectedConnectionOfLeft() {
            return Stream.of(
                    Arguments.of(true, Connection.RIGHT),
                    Arguments.of(false, Connection.DISCONNECTED)
            );
        }

        @ParameterizedTest
        @MethodSource("provideExpectedConnectionOfDisconnected")
        void 현재_커넥션이_연결되지_않았을_때_다음_커넥션은_연결_여부에_따라_달라진다(boolean isConnected, Connection expected) {
            // given
            Connection currentConnection = Connection.DISCONNECTED;

            // when
            Connection nextConnection = currentConnection.next(isConnected);

            // then
            assertThat(nextConnection).isEqualTo(expected);
        }

        Stream<Arguments> provideExpectedConnectionOfDisconnected() {
            return Stream.of(
                    Arguments.of(true, Connection.RIGHT),
                    Arguments.of(false, Connection.DISCONNECTED)
            );
        }
    }

    @Nested
    class 커넥션_이동 {
        @Test
        void 왼쪽으로_이동한다() {
            // given
            Connection connection = Connection.LEFT;
            int currentIndex = 1;

            // when
            int movedIndex = connection.moveToNextIndex(currentIndex);

            // then
            assertThat(movedIndex).isEqualTo(0);
        }

        @Test
        void 오른쪽으로_이동한다() {
            // given
            Connection connection = Connection.RIGHT;
            int currentIndex = 1;

            // when
            int movedIndex = connection.moveToNextIndex(currentIndex);

            // then
            assertThat(movedIndex).isEqualTo(2);
        }

        @Test
        void 이동하지_않는다() {
            // given
            Connection connection = Connection.DISCONNECTED;
            int currentIndex = 1;

            // when
            int movedIndex = connection.moveToNextIndex(currentIndex);

            // then
            assertThat(movedIndex).isEqualTo(1);
        }
    }
}
