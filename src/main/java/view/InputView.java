package view;

import common.exception.handler.IllegalArgumentExceptionHandler;
import utils.ScannerUtil;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private static final int MIN_PARTICIPANTS = 2;

    public static List<String> inputName() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String input = ScannerUtil.nextLine();
            List<String> names = splitNames(input);
            validateDistinct(names);
            validateParticipantSize(names);
            return names;
        });
    }

    public static int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtil.nextInt();
    }

    private static List<String> splitNames(final String input) {
        return List.of(input.split(","));
    }

    private static void validateParticipantSize(final List<String> participantNames) {
        if (participantNames.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다");
        }
    }

    private static void validateDistinct(List<?> names) {
        if (hasDuplicateIn(names)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static boolean hasDuplicateIn(final Collection<?> target) {
        Set<?> distinct = new HashSet<>(target);
        return target.size() != distinct.size();
    }
}
