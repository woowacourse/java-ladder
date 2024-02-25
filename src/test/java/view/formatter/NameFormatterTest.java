package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.formatter.NameFormatter;

class NameFormatterTest {

    @ParameterizedTest(name = "이름을 형식에 맞추어 반환한다.")
    @CsvSource({"'pobi', 'pobi '",
            "'honux', 'honux'",
            "'crong', 'crong'",
            "'jk', '  jk '",
            "'k', '   k '"
    })
    void formatName(String name, String expected) {
        String formattedName = NameFormatter.format(name);
        assertThat(formattedName).isEqualTo(expected);
    }
}
