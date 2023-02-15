package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.util.StringSplitter;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    void 글자를_쉼표를_기준으로_쪼갠다() {
        assertThat(StringSplitter.split("aaa,aa,a", ",")).containsExactly("aaa", "aa", "a");
    }

    @Test
    void 글자에_null_입력시_에러() {
        assertThrows(IllegalArgumentException.class, () -> StringSplitter.split(null, ","));
    }
}