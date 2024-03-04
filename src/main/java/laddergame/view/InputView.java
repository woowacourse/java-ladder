package laddergame.view;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;
import laddergame.exception.BaseException;
import laddergame.model.executionresults.ExecutionResult;
import laddergame.model.executionresults.ExecutionResults;
import laddergame.model.laddergame.LadderHeight;
import laddergame.model.participants.InquirySubject;
import laddergame.model.participants.Participant;
import laddergame.model.participants.Participants;

public class InputView {
    private static final String MULTIPLE_INPUTS_DELIMITER = ",";
    private static final String ALL_COMMAND = "all";

    private final Scanner scanner = new Scanner(System.in);

    public Participants readParticipantNames() {
        return repeatUntilSuccess(() -> {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + MULTIPLE_INPUTS_DELIMITER + ")로 구분하세요)");
            String input = scanner.nextLine();
            validateMultipleInputs(input);
            return Arrays.stream(input.split(MULTIPLE_INPUTS_DELIMITER))
                    .map(Participant::new)
                    .collect(collectingAndThen(toList(), Participants::new));
        });
    }

    public ExecutionResults readExecutionResults(Participants participants) {
        return repeatUntilSuccess(() -> {
            System.out.println();
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(" + MULTIPLE_INPUTS_DELIMITER + ")로 구분하세요)");
            String input = scanner.nextLine();
            validateMultipleInputs(input);
            return Arrays.stream(input.split(MULTIPLE_INPUTS_DELIMITER))
                    .map(ExecutionResult::new)
                    .collect(collectingAndThen(toList(), results -> new ExecutionResults(results, participants)));
        });
    }

    public LadderHeight readLadderHeight() {
        return repeatUntilSuccess(() -> {
            System.out.println();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            String input = scanner.nextLine();
            validateSingleInput(input);
            int height = parseInt(input);
            return new LadderHeight(height);
        });
    }

    public InquirySubject readInquirySubject(Participants participants) {
        return repeatUntilSuccess(() -> {
            System.out.println();
            System.out.println("결과를 보고 싶은 사람은?");
            String input = scanner.nextLine();
            validateSingleInput(input);
            return new InquirySubject(new Participant(input), participants, ALL_COMMAND.equals(input));
        });
    }

    private void validateMultipleInputs(String input) {
        if (input == null || input.isBlank() || input.endsWith(MULTIPLE_INPUTS_DELIMITER)) {
            String message = "입력값은 공백이거나 구분자(" + MULTIPLE_INPUTS_DELIMITER
                    + ")로 끝날 수 없습니다. 입력값 : " + input;
            throw new BaseException(message);
        }
    }

    private void validateSingleInput(String input) {
        if (input == null || input.isBlank()) {
            throw new BaseException("입력값은 공백일 수 없습니다. 입력값 : " + input);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BaseException("입력값은 숫자 형식이어야 합니다. 입력값 : " + input);
        }
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (BaseException e) {
            System.out.println(e.getMessage());
            return repeatUntilSuccess(supplier);
        }
    }
}
