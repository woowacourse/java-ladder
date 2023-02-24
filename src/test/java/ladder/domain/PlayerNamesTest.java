package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerNamesTest {
    PlayerNames playerNames;
    
    @BeforeEach
    void setUp() {
        List<PlayerName> names = List.of(new PlayerName("abel"), new PlayerName("chech"), new PlayerName("pobi"));
        playerNames = new PlayerNames(names);
    }
    
    @Test
    @DisplayName("입력받은 이름들을 ,를 기준으로 나눈다.")
    void test_1() {
        assertThat(playerNames.getNames())
                .containsExactly( new PlayerName("abel"), new PlayerName("chech"), new PlayerName("pobi"));
    }
    
    @Test
    @DisplayName("플레이어 명수를 가져온다.")
    void playerSize() {
        assertThat(playerNames.playerSize()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("해당 플레이어 인덱스를 가져온다.")
    void getPlayerIndex() {
        assertThat(playerNames.getPlayerIndex("pobi")).isEqualTo(2);
    }
    
    @Test
    @DisplayName("첫번째 플레이어의 글자 길이를 가져온다.")
    void getFirstPlayerNameLength() {
        assertThat(playerNames.getFirstPlayerNameLength()).isEqualTo(4);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"abel", "chech", "pobi", "all"})
    @DisplayName("all 또는 존재하는 플레이어 이름 입력 시, 정상 동작한다.")
    void existedPlayer(String playerName) {
        assertThatNoException()
                .isThrownBy(() -> playerNames.findByName(playerName));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "abal"})
    @DisplayName("없는 플레이어가 인자로 전달될 경우 예외처리를 한다.")
    void notExistedPlayerException(String playerName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> playerNames.findByName(playerName))
                .withMessage("존재하지 않는 플레이어입니다.");
    }
    
    @Test
    @DisplayName("플레이어 이름 개수가 2미만일 시 예외가 발생한다.")
    void test_3() {
        List<PlayerName> playerNames = List.of(new PlayerName("abel"));
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerNames(playerNames))
                .withMessage("이름의 수가 2이상 100이하여야 합니다.");
    }
    
    @Test
    @DisplayName("플레이어 이름이 중복될 시 예외가 발생한다.")
    void test_4() {
        List<PlayerName> playerNames = List.of(new PlayerName("abel"), new PlayerName("abel"));
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerNames(playerNames))
                .withMessage("중복된 이름은 입력할 수 없습니다.");
    }
}
