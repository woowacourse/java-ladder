package laddergame.view;

import laddergame.domain.Height;
import laddergame.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";


    public Players readUserNames() {
        String inputUserNames = scanner.nextLine();
        List<String> inputPlayers = splitInputUserNames(inputUserNames);
        Players players = new Players(inputPlayers);
        return players;
    }

    public Height readHeight() {
        String inputHeight = scanner.nextLine();
        Height height = new Height(inputHeight);
        return height;
    }

    private List<String> splitInputUserNames(String inputUserNames) {
        return Arrays.asList(inputUserNames.split(DELIMITER));
    }
}
