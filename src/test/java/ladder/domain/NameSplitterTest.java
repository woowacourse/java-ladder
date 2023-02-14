package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NameSplitterTest {

    @Test
    void 글자를_쉼표를_기준으로_쪼갠다() {
        NameSplitter nameSplit = new NameSplitter("aaa,aa,a");
        assertThat(nameSplit.split()).containsExactly("aaa", "aa", "a");
    }

    @Test
    void 글자에_null_입력시_에러() {
        assertThrows(IllegalArgumentException.class, () -> new NameSplitter(null));
    }
}