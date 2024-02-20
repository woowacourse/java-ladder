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
    @DisplayName("이름을 갖는 사용자를 생성한다.")
    void userNameTest() {
        //given
        String userName = "pobia";
        //when
        //then
        Assertions.assertThatCode(() -> new User(userName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자 이름은 5글자 이하이다.")
    void userNameLengthTest() {
        //given
        String userName = "rushrush";
        //when
        //then
        Assertions.assertThatThrownBy(() -> new User(userName)).isInstanceOf(IllegalArgumentException.class);
    }



}
