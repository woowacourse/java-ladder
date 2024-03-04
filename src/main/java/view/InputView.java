package view;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import model.dto.ParticipantName;

public class InputView {
    private final static String ALL_PARTICIPANTS = "all";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> requestParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return removeBlank(splitName(input));
    }

    public List<String> requestExecutionResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return removeBlank(splitName(input));
    }

    public int requestLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return parseNumeric(input.trim());
    }

    private int parseNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자이어야한다");
        }
    }

    public List<String> requestResultInterestedPeople(List<ParticipantName> participantNames) {
        System.out.println("결과를 보고 싶은 사람은?");
        String input = scanner.nextLine();
        if (Objects.equals(input, ALL_PARTICIPANTS)) {
            return participantNames.stream().map(ParticipantName::name).toList();
        }
        return removeBlank(splitName(input));
    }

    private List<String> splitName(String input) {
        return List.of(input.split(","));
    }

    private List<String> removeBlank(List<String> input) {
        return input.stream().map(String::trim).toList();
    }
}
