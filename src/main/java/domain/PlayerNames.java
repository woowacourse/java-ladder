package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class PlayerNames {
    public static final String PLAYERS_SIZE_ERROR_MESSAGE = "[ERROR] 사다리 게임을 위해서는 2명 이상의 플레이어가 필요합니다";
    public static final int MIN_PLAYERS_SIZE = 2;

    InputView inputView;
    private List<PlayerName> playerNames;

    public PlayerNames(List<String> playerNames, InputView inputView) {
        this.playerNames = new ArrayList<>();
        this.inputView = inputView;
        playerNames = validatePlayerNames(playerNames);
        createPlayerNames(playerNames);
    }

    private void createPlayerNames(List<String> playerNames) {
        for (String playerName : playerNames) {
            this.playerNames.add(new PlayerName(playerName));
        }
    }

    /*TODO: busy-waiting 기법으로 짜자니 코드가 더러워지는 것 같고,
       recursion을 적용하자니 사용자가 무한히 잘못된 값을 입력했을 때 stackOverFlow 발생이 걱정됩니다.
       리뷰어님의 생각이 궁금해요! (일단은 recursion으로 구현했습니다) */
    private List<String> validatePlayerNames(List<String> playerNames) {
        try {
            validatePlayerName(playerNames);
            validatePlayerSize(playerNames);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception.getMessage());
            playerNames = validatePlayerNames(inputView.readPlayerNames());
        }
        return playerNames;
    }

    private static void validatePlayerName(List<String> playerNames) {
        for (String playerName : playerNames) {
            PlayerName.validateName(playerName);
        }
    }

    private static void validatePlayerSize(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYERS_SIZE) {
            throw new IllegalArgumentException(PLAYERS_SIZE_ERROR_MESSAGE);
        }
    }

    public List<PlayerName> getPlayerNames() {
        return this.playerNames;
    }
}
