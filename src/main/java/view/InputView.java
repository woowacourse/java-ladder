package view;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Scanner;
import model.Participant;
import model.Participants;

public class InputView {
    private final String DELIMETER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public Participants readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateParticipantsNames(input);
        return Arrays.stream(input.split(DELIMETER))
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
    }

    public int readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return parseInt(input);
    }

    private void validateParticipantsNames(String input) {
        if (input == null || input.isBlank() || input.endsWith(DELIMETER)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백이거나 구분자("+DELIMETER+")로 끝날 수 없다.");
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자형식이어야 한다.");
        }
    }
}
