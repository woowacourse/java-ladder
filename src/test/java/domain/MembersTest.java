package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MembersTest {
    @Test
    @DisplayName("참여자들 입력 실패: 중복")
    void members_exception_duplicatedNames() {
        assertThatThrownBy(() -> new Members("a,b,c,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 서로 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 16})
    @DisplayName("참여자들 입력 실패: 인원수 경계값 - 1, 16")
    void members_exception_memberCount(int amount) {
        assertThatThrownBy(() -> new Members(makeMemberNamesForTestCase(amount)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("명만 허용됩니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 15})
    @DisplayName("참여자들 입력 성공: 인원수 경계값 - 2, 15")
    void members_ok_memberCount(int amount) {
        assertThatCode(() -> new Members(makeMemberNamesForTestCase(amount)))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {" a  , b , c ", "a,b,c"})
    @DisplayName("참여자들 입력 성공: 쉼표로 구분 잘 되는지")
    void members_ok_delimiter(String rawNames) {
        assertThatCode(() -> new Members(rawNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {",,,a", "a,,,", ",,,", "bb, ,cc"})
    @DisplayName("참여자들 입력 실패: 비정상적인 쉼표 입력")
    void members_exception_delimiter(String rawNames) {
        assertThatThrownBy(() -> new Members(rawNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자의 이름만 허용합니다.");
    }

    private String makeMemberNamesForTestCase(int amount) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            names.add(Integer.toString(i));
        }
        return String.join(",", names);
    }
}
