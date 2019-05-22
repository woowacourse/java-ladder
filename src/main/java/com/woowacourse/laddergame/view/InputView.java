package com.woowacourse.laddergame.view;

import com.woowacourse.laddergame.domain.vo.ResultNameVo;
import com.woowacourse.laddergame.domain.vo.HeightVo;
import com.woowacourse.laddergame.domain.vo.LadderResultsVo;
import com.woowacourse.laddergame.domain.vo.PlayerNamesVo;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static PlayerNamesVo inputPlayerNames() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            return new PlayerNamesVo(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }

    }

    public static LadderResultsVo inputGameResult() {
        try {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            return new LadderResultsVo(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameResult();
        }
    }

    public static HeightVo inputHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return new HeightVo(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputHeight();
        }
    }

    public static ResultNameVo inputResultName() {
        try {
            System.out.println("결과를 보고 싶은 사람은?");
            String resultName = scanner.nextLine();
            checkExit(resultName);
            return new ResultNameVo(resultName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputResultName();
        }
    }

    private static void checkExit(String input) {
        if (input.equals("-1")) {
            throw new RuntimeException("종료를 합니다.");
        }
    }
}
