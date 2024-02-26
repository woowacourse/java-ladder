package domain;

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
        var nameCreator = new NamesCreator();
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
    void testGetNameCount() {
        List<Name> givenNames = List.of(new Name("a"), new Name("b"));
        Names names = new Names(givenNames);

        int actual = names.getNameCount();
        int expected = 2;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("참여자 위치를 전달하면 해당 참여자가 반환된다.")
    void testGetNameFromPosition() {
        List<Name> givenNames = List.of(new Name("a"), new Name("b"));
        Names names = new Names(givenNames);
        Name actual = names.getNameFromPosition(0);
        Name expected = givenNames.get(0);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("범위 외 참여자 위치를 전달하면 예외가 발생한다.")
    void testGetNameFromPositionException(int invalidIndex) {
        List<Name> givenNames = List.of(new Name("a"), new Name("b"));
        Names names = new Names(givenNames);
        Assertions.assertThatThrownBy(() -> names.getNameFromPosition(invalidIndex))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_NAMES_POSITION.getMessage());

    }

    @Test
    @DisplayName("위치 값이 주어지면 위치 - 1 참여자와 위치 참여자의 위치를 변경시킬 수 있다.")
    void testSwapName() {
        List<Name> givenNames = List.of(new Name("a"), new Name("b"));
        Names names = new Names(givenNames);
        names.swapNamePosition(1);
        Name actual = names.getNameFromPosition(0);
        Name expected = givenNames.get(1);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}