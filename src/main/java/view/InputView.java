package view;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Scanner;
import model.Participant;
import model.Participants;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Participants readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateParticipantsNames(input);
        return Arrays.stream(input.split(","))
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
    }

    public int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return parseInt(input);
    }

    private void validateParticipantsNames(String input) {
        if (input == null || input.isBlank() || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
