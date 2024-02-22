package controller;

import domain.PlayerNames;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertAll;

class LadderControllerTest {

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
            LadderController ladderController = new LadderController(inputView, outputView);
            //when
            PlayerNames playerNames = ladderController.createPlayerNames(playerNameInfos);
            //then
            assertAll(
                    () -> Assertions.assertThat(playerNames.getCount()).isEqualTo(3),
                    () -> Assertions.assertThat(playerNames.getNameOfIndex(0)).isEqualTo("aa"),
                    () -> Assertions.assertThat(playerNames.getNameOfIndex(1)).isEqualTo("bb"),
                    () -> Assertions.assertThat(playerNames.getNameOfIndex(2)).isEqualTo("cc")
            );
        }


    }
}