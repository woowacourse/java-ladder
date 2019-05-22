package com.woowacourse.laddergame.view;

import com.woowacourse.laddergame.domain.dto.LadderGameDto;

public class OutputView {
    public static void printLadderStatus(LadderGameDto ladderGameDto) {
        System.out.println(ladderGameDto.getMadeLadderVO().toString());
    }

    public static void printLadderGameResult(String targetName, LadderGameDto ladderGameDto) {
        System.out.println("실행 결과");
        if (targetName.equals("all")) {
            printAllLadderGameResult(ladderGameDto);
            return;
        }
        printSelectedLadderGameResult(targetName, ladderGameDto);
    }

    public static void printAllLadderGameResult(LadderGameDto ladderGameDto) {
        System.out.println(ladderGameDto.getLadderMatchingResultVo().toString());
    }

    public static void printSelectedLadderGameResult(String targetName, LadderGameDto ladderGameDto) {
        try {
            System.out.println(ladderGameDto.getLadderMatchingResultVo().getResult(targetName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
