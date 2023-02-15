package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

class RowsTest {
    @ParameterizedTest
    @MethodSource("로우_리스트")
    public void 생성(List<Row> rows){
        assertThatNoException()
                .isThrownBy(() -> new Rows(rows));
    }

    static Stream<Arguments> 로우_리스트(){
        return Stream.of(
            Arguments.of(List.of(
                    Row.of(List.of(true, false), 2),
                    Row.of(List.of(false, true), 2)
            ))
        );
    }
}