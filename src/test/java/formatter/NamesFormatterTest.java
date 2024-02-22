package formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesFormatterTest {

    @Test
    @DisplayName("이름들을 형식에 맞추어 반환한다.")
    void formatName() {
        List<String> names = List.of(
                "pobi", "honux", "crong", "jk"
        );
        String formattedNames = NamesFormatter.format(names);
        assertThat(formattedNames).isEqualTo("pobi  honux crong   jk");
    }
}