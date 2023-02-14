package factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersFactoryTest {

    @DisplayName("참여자가 20명을 넘을 수 없다.")
    @Test
    void playerSizeNotMoreThan20() {
        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            playerNames.add("test");
        }
        assertThatThrownBy(() -> {
            PlayerFactory.generate(playerNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자가 0명 이하일 수 없다.")
    @Test
    void playerSizeNotLessThan1() {
        List<String> playerNames = Collections.emptyList();
        assertThatThrownBy(() -> {
            PlayerFactory.generate(playerNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 객체를 생성하여 반환한다.")
    @Test
    void generatePlayers() {
        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            playerNames.add("test");
        }
        assertThatNoException()
                .isThrownBy(() -> {
                    PlayerFactory.generate(playerNames);
                });
    }

    @DisplayName("참여자 객체를 생성하여 반환한다.")
    @Test
    void generatePlayers2() {
        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            playerNames.add("test");
        }
        assertThat(PlayerFactory.generate(playerNames).size())
                .isEqualTo(20);
    }
}
