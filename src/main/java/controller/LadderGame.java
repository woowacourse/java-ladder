package controller;

import domain.PlayerName;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LadderGame {
    private final InputView inputView;

    public LadderGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        List<PlayerName> playerNames = readPlayerNames();
        System.out.println(playerNames);
    }


    public List<PlayerName> readPlayerNames() {
        return createPlayerNames(inputView.readPlayerNames());
    }


    public List<PlayerName> createPlayerNames(String playerNameInput) {
        playerNameInput = playerNameInput.replace(" ", "");

        Pattern regex = Pattern.compile("[가-힣a-zA-Z]{1,5}(,[가-힣a-zA-Z]{1,5})*");
        if (!regex.matcher(playerNameInput).matches()) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(playerNameInput.split(","))
                .map(PlayerName::new)
                .toList();
    }
}
