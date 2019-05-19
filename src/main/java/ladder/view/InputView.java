package ladder.view;

import ladder.domain.PlayerName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<PlayerName> inputPlayerNames() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
            String userInput = SCANNER.nextLine();
            String[] commaSeparatedUserInput = userInput.split(",");
            return stringsToPlayerNames(Arrays.asList(commaSeparatedUserInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }

    private static List<PlayerName> stringsToPlayerNames(List<String> commaSeperatedUserInput) {
        List<PlayerName> playerNames = new ArrayList<>();
        for (String name : commaSeperatedUserInput) {
            playerNames.add(new PlayerName(name)); // exception can be thrown
        }
        return playerNames;
    }
}
