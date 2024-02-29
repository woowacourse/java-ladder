package domain;

import static domain.Members.MAX_MEMBER_COUNT;
import static domain.Members.MIN_MEMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MembersTest {

    @Test
    @DisplayName("참여자들 입력 성공: 사이즈 일치")
    void test_ok_constructor() {
        Members members = Members.from(List.of("a", "b", "c", "d"));
        assertThat(members.getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("참여자들 입력 실패: 중복")
    void test_exception_duplicatedNames() {
        assertThatThrownBy(() -> Members.from(List.of("a", "a", "c", "d")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 서로 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("참여자들 입력 실패: 인원수 경계값 - 1, 16")
    void test_exception_memberCount() {
        assertThatThrownBy(() -> Members.from(List.of("a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 " + MIN_MEMBER_COUNT + "~" + MAX_MEMBER_COUNT + "명만 허용됩니다.");

        assertThatThrownBy(() -> Members.from(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 " + MIN_MEMBER_COUNT + "~" + MAX_MEMBER_COUNT + "명만 허용됩니다.");
    }

    @Test
    @DisplayName("참여자들 입력 성공: 인원수 경계값 - 2, 15")
    void test_ok_memberCount() {
        assertThat(Members.from(List.of("a", "b"))
                .getCount())
                    .isEqualTo(2);
        assertThat(Members.from(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"))
                .getCount())
                    .isEqualTo(15);
    }

    @Test
    @DisplayName("참여자들 입력 실패: null 입력")
    void test_exception_null() {
        assertThatThrownBy(() -> Members.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null을 입력할 수 없습니다.");
    }
}
