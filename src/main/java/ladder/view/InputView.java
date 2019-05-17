/*
 * @(#)InputView.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.view;

import ladder.model.ladder.Floor;

import java.util.Scanner;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class InputView {
    /*사다리게임의 입력에 대한 클래스*/
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) (\'all\'과 \'exit\'은 이름으로 사용할 수 없습니다.)";
    private static final String INPUT_FLOORS_MESSAGE = "최대 사다리 높이는 몇 개인가요";
    private static final String INPUT_RESULTS_MESSAGE = "실행결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_SELECT_RESULTS_MESSAGE = "결과를 보고 싶은 사람은? (종료를 원하시면 exit을 입력하세요)";
    private static final String NOT_VALID_INPUT_ERROR = "입력 형식 오류";
    private static final String ONE_PLAYER_INPUT_ERROR = "플레이어 1명 입력 오류";
    private static final String RESERVED_WORD_INPUT_ERROR = "예약어 입력 오류";
    private static final String INPUT_REGEX = "^([^,]+)(,[^,]+)*$";
    private static final String DELIMITER = ",";
    private static final String RESERVED_WORD = "exit|all";
    private static final int ONE_PLAYER = 1;

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputPlayers() {
        try {
            System.out.println(INPUT_NAMES_MESSAGE);
            String input = scanner.nextLine();
            checkValidInput(input);
            return checkReservedWord(splitInput(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayers();
        }
    }

    private static String[] checkReservedWord(String[] splittedInput) {
        for (String tagValue : splittedInput) {
            checkReservedWordOneValue(tagValue);
        }
        return splittedInput;
    }

    private static void checkReservedWordOneValue(String tagValue) {
        if (tagValue.matches(RESERVED_WORD)) {
            throw new IllegalArgumentException(RESERVED_WORD_INPUT_ERROR);
        }
    }

    public static String[] inputResults() {
        try {
            System.out.println(INPUT_RESULTS_MESSAGE);
            String input = scanner.nextLine();
            checkValidInput(input);
            return splitInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputResults();
        }
    }

    private static void checkValidInput(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException(NOT_VALID_INPUT_ERROR);
        }
    }

    private static String[] splitInput(String input) {
        String[] splittedInput = input.split(DELIMITER);
        if (splittedInput.length == ONE_PLAYER) {
            throw new IllegalArgumentException(ONE_PLAYER_INPUT_ERROR);
        }
        return splittedInput;
    }

    public static Floor inputFloors() {
        System.out.println(INPUT_FLOORS_MESSAGE);
        return new Floor(scanner.nextLine());
    }

    public static String inputChoice() {
        System.out.println(INPUT_SELECT_RESULTS_MESSAGE);
        return scanner.nextLine();
    }
}
