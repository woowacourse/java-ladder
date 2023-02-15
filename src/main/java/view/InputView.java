package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner reader = new Scanner(System.in);

    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNames = reader.next();
        reader.close();
        // 예외
        return Arrays.stream(splitNames(playerNames))
                .collect(Collectors.toList());
    }

    private String[] splitNames(String playerNames) {
        return playerNames.split(",");
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String height = reader.next();
        reader.close();
        // 예외
        return Integer.parseInt(height);
    }
}
