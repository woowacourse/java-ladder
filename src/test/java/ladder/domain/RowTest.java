package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @Test
    public void 연속_발판이면_예외_던지기(){
        assertThatThrownBy(() -> Row.of(List.of(true, true), 2))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @CsvSource({"true,false", "false,false"})
    public void Row_정상_생성 (boolean first, boolean second){
        assertThatNoException()
                .isThrownBy(() -> Row.of(List.of(first, second), 2));
    }

    @Test
    public void Row_사이즈와_사람수가_불일치하면_예외던지기() {
        assertThatThrownBy(() -> Row.of(List.of(false, false, true), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}