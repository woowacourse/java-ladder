package domain;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("참여자들 입력 성공: 사이즈 일치")
    void test_ok_constructor() {
        Members members = Members.from("a,bb,ccc,ddddd");
        assertThat(members.getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("참여자들 입력 실패: 중복")
    void test_exception_duplicatedNames() {
        assertThatThrownBy(() -> Members.from("a,b,c,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 서로 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 16})
    @DisplayName("참여자들 입력 실패: 인원수 경계값 - 1, 16")
    void test_exception_memberCount(int amount) {
        assertThatThrownBy(() -> Members.from(makeMemberNamesForTestCase(amount)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("명만 허용됩니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 15})
    @DisplayName("참여자들 입력 성공: 인원수 경계값 - 2, 15")
    void test_ok_memberCount(int amount) {
        assertThatCode(() -> Members.from(makeMemberNamesForTestCase(amount)))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {" a  , b , c ", "a,b,c"})
    @DisplayName("참여자들 입력 성공: 쉼표로 구분 잘 되는지")
    void test_ok_delimiter(String rawNames) {
        assertThatCode(() -> Members.from(rawNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {",,,a", "a,,,", ",,,", "bb, ,cc"})
    @DisplayName("참여자들 입력 실패: 비정상적인 쉼표 입력")
    void test_exception_delimiter(String rawNames) {
        assertThatThrownBy(() -> Members.from(rawNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자들 입력 실패: null 입력")
    void test_exception_null() {
        assertThatThrownBy(() -> Members.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null을 입력할 수 없습니다.");
    }

    private String makeMemberNamesForTestCase(int amount) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            names.add(Integer.toString(i));
        }
        return String.join(",", names);
    }
}
