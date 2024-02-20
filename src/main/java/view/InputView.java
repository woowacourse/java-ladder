package view;

import domain.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine().replaceAll(" ", "");
        return Arrays.stream(input.split(","))
                .map(Player::new)
                .toList();
    }
}
