package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Line;
import domain.ladder.Link;
import domain.prize.Prizes;
import domain.user.Users;
import exception.ErrorMessage;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {
    private final List<String> testUserNames = List.of("썬샷", "홍실", "다니");


    @Test
    @DisplayName("유저의 수가 0이 들어오는 경우")
    void usersNumberIsZero() {
        assertThatThrownBy(() -> new Users(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("정상적으로 Users가 생성되는 경우")
    void generateUsersTest() {
        Assertions.assertDoesNotThrow(() -> new Users(testUserNames));
    }

    @Test
    @DisplayName("유저의 수를 반환하는 메서드 테스트")
    void getUsersNumberTest() {
        final Users users = new Users(testUserNames);
        assertThat(users.size()).isEqualTo(testUserNames.size());
    }

    @Test
    @DisplayName("유저의 이름들을 반환하는 메서드 테스트")
    void getUsersNameTest() {
        final Users users = new Users(testUserNames);
        assertThat(users.getUserNames()).containsExactlyElementsOf(testUserNames);
    }

    @Test
    @DisplayName("입력한 사용자와 동일한 이름을 가진 객체가 없는 경우 예외처리")
    void throwExceptionIfCantFindUser() {
        final Users users = new Users(testUserNames);
        final Prizes prizes = new Prizes(List.of("1등", "2등", "3등"), users);
        assertThatThrownBy(() -> users.getPrizeAndUserName("로지", prizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_NOT_FOUND_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("line을 순회하면서 Link가 되어있는 경우, 유저의 위치를 swap")
    void swapUserByLine() {
        final Users users = new Users(testUserNames);
        final Line line = new Line(List.of(Link.LINKED, Link.UNLINKED));

        users.swapUserByLine(line);

        assertThat(users.getUserNames())
                .containsExactly("홍실", "썬샷", "다니");
    }

    @Test
    @DisplayName("User와 Prize를 Map형태로 반환받는 기능")
    void getPrizeAndUserName() {
        final Users users = new Users(testUserNames);
        final Prizes prizes = new Prizes(List.of("1등", "2등", "3등"), users);

        final Map<String, String> prizeAndUserName = users.getPrizeAndUserName("다니", prizes);

        assertThat(prizeAndUserName)
                .contains(Map.entry("다니", "3등"));
    }

    @Test
    @DisplayName("모든 User와 prize를 반환하는 기능")
    void getAllUsersAndPrizes() {
        final Users users = new Users(testUserNames);
        final Prizes prizes = new Prizes(List.of("1등", "2등", "3등"), users);

        final Map<String, String> allUsersAndPrizes = users.getPrizeAndUserName("all", prizes);

        assertThat(allUsersAndPrizes)
                .contains(Map.entry("썬샷", "1등"))
                .contains(Map.entry("홍실", "2등"))
                .contains(Map.entry("다니", "3등"));
    }

    @Test
    @DisplayName("Users를 입력받을 때 이름에 중복이 있으면 예외처리")
    void throwExceptionWhenUsersNameHasDuplicate() {
        final List<String> userNames = List.of("홍실", "홍실", "에단");

        assertThatThrownBy(() -> new Users(userNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USERS_NAME_HAS_DUPLICATE.getMessage());
    }
}
