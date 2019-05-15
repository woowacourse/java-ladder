package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.Player;
import ladder.validator.PlayerValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<Player> makePlayers() {
        System.out.println(MessageConstant.INPUT_PLAYER_NAME);
        return makePlayers(scanner.nextLine().split(DELIMITER));
    }

    public static List<Player> makePlayers(String[] inputs) {
        PlayerValidator.checkPlayerInputAccuracy(inputs);
        return Arrays.stream(inputs).map(String::trim).map(Player::new).collect(Collectors.toList());
    }
}
