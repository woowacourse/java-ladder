package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

    @Test
    @DisplayName("prizes의 크기는 users의 크기와 같다.")
    void prizesSizeEqualToUsersSize() {
        //given
        List<String> userNames = List.of("1", "2", "3");
        List<String> prizeNames = List.of("prize", "prize", "prize");

        //when
        var users = new Users(userNames);
        var prizes = new Prizes(prizeNames, users);

        //then
        assertThat(users.getSize())
                .isEqualTo(prizes.getPrizes().size());

    }

}
