package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrizesTest {

    @Test
    @DisplayName("prizes의 크기는 users의 크기와 같아야 한다.")
    void prizesSizeEqualToUsersSize() {
        //given
        List<String> userNames = List.of("1", "2", "3");
        List<String> prizeNames = List.of("prize", "prize");

        //when
        var users = new Users(userNames);

        //then
        assertThatThrownBy(() -> new Prizes(prizeNames, users))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:pr1", "1:pr2", "2:pr3"}, delimiter = ':')
    @DisplayName("파라미터 인덱스에 해당하는 상품 이름을 반환한다.")
    void getPrizeNameTest(int index, String name) {
        //given
        var users = new Users(List.of("a", "b", "c"));
        List<String> prizeNames = List.of("pr1", "pr2", "pr3");
        //when
        var prizes = new Prizes(prizeNames, users);
        var prizeNameByIndex = prizes.getPrizeNameByIndex(index).getValue();
        //then
        assertThat(prizeNameByIndex).isEqualTo(name);
    }
}
