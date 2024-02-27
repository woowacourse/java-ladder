package domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("이름 일급 컬렉션 테스트")
class NamesTest {

    @DisplayName("이름이 중복될 경우 생성 검증에 실패한다")
    @Test
    void testCreateWithDuplicatedNames() {
        List<String> names = List.of("리비", "리비", "잉크");
        assertThatThrownBy(() -> Names.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복될 수 없습니다");
    }

    @DisplayName("이름이 중복되지 않을 경우 생성 검증에 성공한다")
    @Test
    void testCreateWithUniqueNames() {
        List<String> names = List.of("리비", "테니", "잉크");
        assertThatCode(() -> Names.from(names)).doesNotThrowAnyException();
    }

    @DisplayName("참여 인원 2명 이상이 아니면 생성 검증에 실패한다.")
    @Test
    void testCreateWithNotEnoughEntry() {
        List<String> names = List.of("리비");
        assertThatThrownBy(() -> Names.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여 인원은 2명 이상이어야 합니다");
    }

    @DisplayName("참여 인원이 2명 이상이면 생성 검증에 성공한다 ")
    @Test
    void testCreateWithEnoughEntry() {
        List<String> names = List.of("리비", "잉크");
        assertThatCode(() -> Names.from(names)).doesNotThrowAnyException();
    }

    @DisplayName("찾는 이름이 있으면 검증에 성공한다.")
    @Test
    void testValidateGetName() {
        Names names = Names.from(List.of("a", "b", "c"));
        assertThatCode(() -> names.findName("b")).doesNotThrowAnyException();
    }

    @DisplayName("찾는 이름이 없으면 검증에 실패한다.")
    @Test
    void testInvalidateGetName() {
        Names names = Names.from(List.of("a", "b", "c"));
        assertThatThrownBy(() -> names.findName("d")).isInstanceOf(IllegalArgumentException.class);
    }
}
