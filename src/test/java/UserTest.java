import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("사용자를 생성한다.")
    void createUser() {
        User user = new User();
        Assertions.assertThatCode(() -> new User())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자의 이름은 최대 5글자이다.")
    void userNameTest() throws Exception {
        //given
        String userName = "pobia";
        //when
        Assertions.assertThatCode(() -> new User(userName))
                .doesNotThrowAnyException();
    }


}
