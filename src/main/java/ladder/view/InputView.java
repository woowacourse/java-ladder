package ladder.view;

import ladder.domain.Player;
import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.domain.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players inputPlayers() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
            String userInput = SCANNER.nextLine();
            String[] commaSeparatedUserInput = userInput.split(",");
            return namesToPlayers(Arrays.asList(commaSeparatedUserInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayers();
        }
    }

    private static Players namesToPlayers(List<String> names) {
        Players.NUM_OF_PLAYERS = names.size();
        List<Player> players = new ArrayList<>();
        for (int i=0; i<names.size(); i++) {
            players.add(new Player(new PlayerName(names.get(i)), new Position(i))); // exception can be thrown
        }
        return new Players(players);
    }
}
