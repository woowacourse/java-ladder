package ladder.view;

import java.util.Scanner;
import ladder.dto.request.LadderHeightRequest;
import ladder.dto.request.PlayerNamesRequest;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public PlayerNamesRequest readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        final String input = SCANNER.nextLine();

        return new PlayerNamesRequest(input);
    }

    public LadderHeightRequest readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        final String input = SCANNER.nextLine();

        return new LadderHeightRequest(input);
    }


}
