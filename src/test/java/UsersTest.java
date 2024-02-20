import domain.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UsersTest {

    @Test
    @DisplayName("Users 생성")
    void createUsers() {
        //given
        String userNames = "pobi,honux,crong,jk";
        //when
        //then
        assertThatCode(() -> new Users(userNames))
                .doesNotThrowAnyException();
    }

}
