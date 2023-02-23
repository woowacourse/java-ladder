package laddergame.view;

import laddergame.domain.Height;
import laddergame.domain.Players;
import laddergame.domain.Rewards;
import laddergame.domain.Target;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";


    public Players readUserNames() {
        String inputUserNames = scanner.nextLine();
        List<String> inputPlayers = splitByDelimiter(inputUserNames);
        Players players = new Players(inputPlayers);
        return players;
    }

    public Height readHeight() {
        String inputHeight = scanner.nextLine();
        Height height = new Height(inputHeight);
        return height;
    }

    public Rewards readRewards() {
        String inputReward = scanner.nextLine();
        List<String> inputRewards = splitByDelimiter(inputReward);
        Rewards rewards = new Rewards(inputRewards);
        return rewards;
    }

    public Target readTarget() {
        String inputTarget = scanner.nextLine();
        Target target = new Target(inputTarget);
        return target;
    }

    private List<String> splitByDelimiter(String str) {
        return Arrays.asList(str.split(DELIMITER));
    }
}
