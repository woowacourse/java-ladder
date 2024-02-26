package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {


    @ParameterizedTest
    @MethodSource("provideConnectionAndBridge")
    @DisplayName("true or false가 주어졌을 때 그에 맞는 enum 객체를 반환한다")
    void findByHasLine(boolean connection, Bridge bridge) {
        assertThat(Bridge.findByConnection(connection)).isEqualTo(bridge);
    }

    public static Stream<Arguments> provideConnectionAndBridge() {
        return Stream.of(Arguments.of(true, Bridge.BRIDGE), Arguments.of(false, Bridge.NON_BRIDGE));
    }
}
