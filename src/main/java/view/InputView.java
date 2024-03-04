package view;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.*;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public Participants readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateLastDelimiter(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
    }

    public Prizes readPrizesNames(int peopleCount) {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateLastDelimiter(input);
        List<Prize> prizes = Arrays.stream(input.split(DELIMITER))
                .map(Prize::new)
                .collect(toList());

        return new Prizes(prizes, peopleCount);
    }

    public Height readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return new Height(input);
    }

    public String readResultSearch() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private void validateLastDelimiter(String input) {
        if (input == null || input.isBlank() || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백이거나 구분자(" + DELIMITER + ")로 끝날 수 없다.");
        }
    }
}
