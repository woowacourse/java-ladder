package domain.name;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c,d,e,f,g,h,i,j,k",
            "a"})
    @DisplayName("참여자 이름 개수가 부적절(2 미만 10 초과)하면 예외 발생")
    void validateNameCount(String givenName) {
        Assertions.assertThatThrownBy(() -> new Names(Arrays.stream(givenName.split(","))
                        .map(Name::new)
                        .toList()))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_NAMES_RANGE.getMessage());
    }

    @Test
    @DisplayName("참여자 이름이 중복되면 예외 발생")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Names(List.of(new Name("a"), new Name("a"))))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DUPLICATE_NAME.getMessage());
    }

    @Test
    @DisplayName("참여자 이름 개수가 적절하면 해당 개수만큼 참여자 이름 생성")
    void testGetNames() {
        List<Name> expected = List.of(new Name("a"), new Name("b"));
        Names names = new Names(expected);

        List<Name> actual = names.getNames();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("참여자 이름 개수가 적절하면 해당 사람 개수를 반환할 수 있음")
    void testCount() {
        List<Name> givenNames = List.of(new Name("a"), new Name("b"));
        Names names = new Names(givenNames);

        int actual = names.count();
        int expected = 2;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}