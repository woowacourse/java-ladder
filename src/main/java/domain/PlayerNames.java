package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class PlayerNames {
    public static final String PLAYERS_SIZE_ERROR_MESSAGE = "[ERROR] 사다리 게임을 위해서는 2명 이상의 플레이어가 필요합니다";
    public static final String SAME_PLAYER_NAME_ERROR_MESSAGE = "[ERROR] 중복된 플레이어의 이름이 존재합니다";
    public static final int MIN_PLAYERS_SIZE = 2;
    private final List<PlayerName> playerNames;
    InputView inputView;

    public PlayerNames(List<String> playerNames, InputView inputView) {
        this.playerNames = new ArrayList<>();
        this.inputView = inputView;
        playerNames = validatePlayerNames(playerNames);
        createPlayerNames(playerNames);
    }

    private List<String> validatePlayerNames(List<String> playerNames) {
        try {
            validatePlayerName(playerNames);
            validatePlayerSize(playerNames);
            validateSamePlayerName(playerNames);
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

    private void validateSamePlayerName(List<String> playerNames) {
        if (playerNames.size() != playerNames.stream().distinct().count()) {
            throw new IllegalArgumentException(SAME_PLAYER_NAME_ERROR_MESSAGE);
        }
    }

    private void createPlayerNames(List<String> playerNames) {
        for (String playerName : playerNames) {
            this.playerNames.add(new PlayerName(playerName));
        }
    }

    public List<PlayerName> getPlayerNames() {
        return this.playerNames;
    }
}
