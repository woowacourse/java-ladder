package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {

    @Test
    @DisplayName("이름이 정상적으로 생성되는가")
    void does_name_create_correctly() {
        String[] rawNames = new String[]{"mang", "pobi"};

        Names names = new Names(rawNames);

        List<Name> expected = Stream.of("mang", "pobi").map(Name::new).toList();
        assertThat(names.names()).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("중복된 이름인가")
    void is_duplicated_names() {
        String[] rawNames = new String[]{"mang", "mang"};

        assertThatThrownBy(() -> new Names(rawNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 허용하지 않습니다");
    }
}
