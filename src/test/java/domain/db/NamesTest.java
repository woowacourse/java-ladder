package domain.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NamesTest {

    @Test
    @DisplayName("이름이 정상적으로 생성되는가")
    void does_name_create_correctly() {
        String mang = "mang";
        String pobi = "pobi";

        Names names = new Names(new String[]{mang, pobi});

        assertAll(
                () -> assertThat(names.getSequence("mang")).isEqualTo(0),
                () -> assertThat(names.getSequence("pobi")).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("중복된 이름인가")
    void is_duplicated_names() {
        String mang = "mang";
        String[] names = new String[]{mang, mang};

        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 허용하지 않습니다");
    }
}
