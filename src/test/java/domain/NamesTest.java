package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("이름이 정상적으로 생성되는가")
    void does_name_create_correctly() {
        String[] rawNames = new String[]{"mang", "pobi"};

        Names names = new Names(rawNames);

        List<Name> expected = Stream.of("mang", "pobi").map(Name::new).toList();
        assertThat(names.names()).containsExactlyElementsOf(expected);
    }
}
