package controller;

import domain.PlayerName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameTest {

    @Nested
    @DisplayName("플레이어 이름 구분자 테스트")
    class PlayerNameDelimiterTest {

        @Test
        @DisplayName("플레이어 이름은 구분자 단위로 나뉘어진다")
        void splitPlayerNameByDelimiter() {
            //given
            String playerNameInfos = "aa,bb,cc";
            InputView inputView = new InputView(new Scanner(System.in));
            OutputView outputView = new OutputView();
            LadderGame ladderGame = new LadderGame(inputView, outputView);
            //when
            List<PlayerName> playerNames = ladderGame.createPlayerNames(playerNameInfos);
            //then
            assertAll(
                    () -> Assertions.assertThat(playerNames).hasSize(3),
                    () -> Assertions.assertThat(playerNames.get(0).getName()).isEqualTo("aa"),
                    () -> Assertions.assertThat(playerNames.get(1).getName()).isEqualTo("bb"),
                    () -> Assertions.assertThat(playerNames.get(2).getName()).isEqualTo("cc")
            );
        }


    }
}