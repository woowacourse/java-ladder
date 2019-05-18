package com.woowacourse.laddergame.view;

import com.woowacourse.laddergame.domain.dto.LadderGameResultDto;

public class OutputView {
    public static void printLadderStatus(LadderGameResultDto ladderGameResultDto) {
        System.out.println(ladderGameResultDto.getMadeLadderVO().toString());
    }

    public static void printLadderGameResult(String targetName, LadderGameResultDto ladderGameResultDto) {
        System.out.println("실행 결과");
        if (targetName.equals("all")) {
            printAllLadderGameResult(ladderGameResultDto);
            return;
        }
        printSelectedLadderGameResult(targetName, ladderGameResultDto);
    }

    public static void printAllLadderGameResult(LadderGameResultDto ladderGameResultDto) {
        System.out.println(ladderGameResultDto.getLadderGameResultVo().toString());
    }

    public static void printSelectedLadderGameResult(String targetName, LadderGameResultDto ladderGameResultDto) {
        try {
            System.out.println(ladderGameResultDto.getLadderGameResultVo().getResult(targetName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
